package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ShenqingEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GaoumaiEntity;

import com.entity.view.GaoumaiView;
import com.entity.BaoxianEntity;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 已有保险
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/gaoumai")
public class GaoumaiController {
    private static final Logger logger = LoggerFactory.getLogger(GaoumaiController.class);
    @Autowired
    private ShenqingService shenqingService;
    @Autowired
    private GaoumaiService gaoumaiService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private BaoxianService baoxianService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = gaoumaiService.queryPage(params);

        //字典表数据转换
        List<GaoumaiView> list =(List<GaoumaiView>)page.getList();
        for(GaoumaiView c:list){
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
        GaoumaiEntity gaoumai = gaoumaiService.selectById(id);
        if(gaoumai !=null){
            //entity转view
            GaoumaiView view = new GaoumaiView();
            BeanUtils.copyProperties( gaoumai , view );//把实体数据重构到view中

            //级联表
            BaoxianEntity baoxian = baoxianService.selectById(gaoumai.getBaoxianId());
            if(baoxian != null){
                BeanUtils.copyProperties( baoxian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBaoxianId(baoxian.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(gaoumai.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody GaoumaiEntity gaoumai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gaoumai:{}",this.getClass().getName(),gaoumai.toString());
        Wrapper<GaoumaiEntity> queryWrapper = new EntityWrapper<GaoumaiEntity>()
            .eq("yonghu_id", gaoumai.getYonghuId())
            .eq("baoxian_id", gaoumai.getBaoxianId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GaoumaiEntity gaoumaiEntity = gaoumaiService.selectOne(queryWrapper);
        if(gaoumaiEntity==null){
            gaoumai.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      gaoumai.set
        //  }
            gaoumaiService.insert(gaoumai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GaoumaiEntity gaoumai, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gaoumai:{}",this.getClass().getName(),gaoumai.toString());
        //根据字段查询是否有相同数据
        Wrapper<GaoumaiEntity> queryWrapper = new EntityWrapper<GaoumaiEntity>()
            .notIn("id",gaoumai.getId())
            .andNew()
            .eq("yonghu_id", gaoumai.getYonghuId())
            .eq("baoxian_id", gaoumai.getBaoxianId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GaoumaiEntity gaoumaiEntity = gaoumaiService.selectOne(queryWrapper);
                gaoumai.setGoumaiTime(new Date());
        if(gaoumaiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      gaoumai.set
            //  }
            gaoumaiService.updateById(gaoumai);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 申请
    */
    @RequestMapping("/renting")
    public R renting(String yuanyin,Integer ids, HttpServletRequest request){
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        GaoumaiEntity gaoumai = gaoumaiService.selectById(ids);
        if(gaoumai == null){
            return R.error();
        }
        BaoxianEntity baoxian = baoxianService.selectById(gaoumai.getBaoxianId());
        if(baoxian == null){
            return R.error();
        }
        ShenqingEntity shenqing = new ShenqingEntity();
        shenqing.setCreateTime(new Date());
        shenqing.setAmountpaid(baoxian.getBxamountpaid());
        shenqing.setBaoxianId(baoxian.getId());
        shenqing.setJieguoTypes(0);//未处理
        shenqing.setShenqingContent(yuanyin);
        shenqing.setYonghuId(userId);
        shenqingService.insert(shenqing);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gaoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

