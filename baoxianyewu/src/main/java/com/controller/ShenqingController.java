package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
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

import com.entity.ShenqingEntity;

import com.service.ShenqingService;
import com.entity.view.ShenqingView;
import com.service.BaoxianService;
import com.entity.BaoxianEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 赔偿申请
 * 后端接口
 * @author
 * @email
 * @date 2021-03-24
*/
@RestController
@Controller
@RequestMapping("/shenqing")
public class ShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(ShenqingController.class);

    @Autowired
    private ShenqingService shenqingService;


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
        PageUtils page = shenqingService.queryPage(params);

        //字典表数据转换
        List<ShenqingView> list =(List<ShenqingView>)page.getList();
        for(ShenqingView c:list){
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
        ShenqingEntity shenqing = shenqingService.selectById(id);
        if(shenqing !=null){
            //entity转view
            ShenqingView view = new ShenqingView();
            BeanUtils.copyProperties( shenqing , view );//把实体数据重构到view中

            //级联表
            BaoxianEntity baoxian = baoxianService.selectById(shenqing.getBaoxianId());
            if(baoxian != null){
                BeanUtils.copyProperties( baoxian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBaoxianId(baoxian.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shenqing.getYonghuId());
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
    public R save(@RequestBody ShenqingEntity shenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shenqing:{}",this.getClass().getName(),shenqing.toString());
        Wrapper<ShenqingEntity> queryWrapper = new EntityWrapper<ShenqingEntity>()
            .eq("yonghu_id", shenqing.getYonghuId())
            .eq("baoxian_id", shenqing.getBaoxianId())
            .eq("jieguo_types", shenqing.getJieguoTypes())
            .eq("shenqing_content", shenqing.getShenqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingEntity shenqingEntity = shenqingService.selectOne(queryWrapper);
        if(shenqingEntity==null){
            shenqing.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shenqing.set
        //  }
            shenqingService.insert(shenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShenqingEntity shenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shenqing:{}",this.getClass().getName(),shenqing.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShenqingEntity> queryWrapper = new EntityWrapper<ShenqingEntity>()
            .notIn("id",shenqing.getId())
            .andNew()
            .eq("yonghu_id", shenqing.getYonghuId())
            .eq("baoxian_id", shenqing.getBaoxianId())
            .eq("jieguo_types", shenqing.getJieguoTypes())
            .eq("shenqing_content", shenqing.getShenqingContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenqingEntity shenqingEntity = shenqingService.selectOne(queryWrapper);
        if(shenqingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shenqing.set
            //  }
            shenqingService.updateById(shenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 同意
    */
    @RequestMapping("/agreement")
    public R agreement(Integer ids){
        ShenqingEntity shenqing = shenqingService.selectById(ids);
        if(shenqing == null){
            return R.error();
        }
        shenqing.setJieguoTypes(1);
        shenqingService.updateById(shenqing);
        return R.ok();
    }

    /**
    * 拒绝
    */
    @RequestMapping("/reject")
    public R reject(Integer ids){
        ShenqingEntity shenqing = shenqingService.selectById(ids);
        if(shenqing == null){
            return R.error();
        }
        shenqing.setJieguoTypes(2);
        shenqingService.updateById(shenqing);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

