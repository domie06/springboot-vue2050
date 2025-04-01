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

import com.dao.BaoxianDao;
import com.entity.BaoxianEntity;
import com.service.BaoxianService;
import com.entity.view.BaoxianView;

/**
 * 保险 服务实现类
 * @author 
 * @since 2021-03-24
 */
@Service("baoxianService")
@Transactional
public class BaoxianServiceImpl extends ServiceImpl<BaoxianDao, BaoxianEntity> implements BaoxianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<BaoxianView> page =new Query<BaoxianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
