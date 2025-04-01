package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaoxianEntity;
import java.util.Map;

/**
 * 保险 服务类
 * @author 
 * @since 2021-03-24
 */
public interface BaoxianService extends IService<BaoxianEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}