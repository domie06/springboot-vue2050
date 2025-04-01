package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.GaoumaiEntity;
import com.service.GaoumaiService;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BaoxianEntity;

import com.service.BaoxianService;
import com.entity.view.BaoxianView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 保险
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/baoxian")
public class BaoxianController {
    private static final Logger logger = LoggerFactory.getLogger(BaoxianController.class);

    @Autowired
    private GaoumaiService gaoumaiService;

    @Autowired
    private BaoxianService baoxianService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = baoxianService.queryPage(params);

        //字典表数据转换
        List<BaoxianView> list =(List<BaoxianView>)page.getList();
        for(BaoxianView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BaoxianEntity baoxian = baoxianService.selectById(id);
        if(baoxian !=null){
            //entity转view
            BaoxianView view = new BaoxianView();
            BeanUtils.copyProperties( baoxian , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BaoxianEntity baoxian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,baoxian:{}",this.getClass().getName(),baoxian.toString());
        Wrapper<BaoxianEntity> queryWrapper = new EntityWrapper<BaoxianEntity>()
            .eq("bxname", baoxian.getBxname())
            .eq("leixing_types", baoxian.getLeixingTypes())
            .eq("neirong_content", baoxian.getNeirongContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxianEntity baoxianEntity = baoxianService.selectOne(queryWrapper);
        if(baoxianEntity==null){
            baoxian.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      baoxian.set
        //  }
            baoxianService.insert(baoxian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaoxianEntity baoxian, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,baoxian:{}",this.getClass().getName(),baoxian.toString());
        //根据字段查询是否有相同数据
        Wrapper<BaoxianEntity> queryWrapper = new EntityWrapper<BaoxianEntity>()
            .notIn("id",baoxian.getId())
            .andNew()
            .eq("bxname", baoxian.getBxname())
            .eq("leixing_types", baoxian.getLeixingTypes())
            .eq("neirong_content", baoxian.getNeirongContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaoxianEntity baoxianEntity = baoxianService.selectOne(queryWrapper);
        if(baoxianEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      baoxian.set
            //  }
            baoxianService.updateById(baoxian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 购买
    */
    @RequestMapping("/purchase")
    public R purchase(Integer ids, HttpServletRequest request){
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        BaoxianEntity baoxian = baoxianService.selectById(ids);
        if(baoxian == null){
           return R.error();
        }
        GaoumaiEntity gaoumai = new GaoumaiEntity();
        gaoumai.setCreateTime(new Date());
        gaoumai.setGoumaiTime(new Date());
        gaoumai.setBaoxianId(ids);
        gaoumai.setYonghuId(userId);
        gaoumaiService.insert(gaoumai);
        return R.ok().put("hf",baoxian.getBxmoney());
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        baoxianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

