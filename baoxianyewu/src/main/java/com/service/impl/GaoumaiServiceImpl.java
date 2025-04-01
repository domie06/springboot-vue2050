package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.GaoumaiDao;
import com.entity.GaoumaiEntity;
import com.service.GaoumaiService;
import com.entity.view.GaoumaiView;

/**
 * 已有保险 服务实现类
 * @author 
 * @since 2021-03-24
 */
@Service("gaoumaiService")
@Transactional
public class GaoumaiServiceImpl extends ServiceImpl<GaoumaiDao, GaoumaiEntity> implements GaoumaiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<GaoumaiView> page =new Query<GaoumaiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
