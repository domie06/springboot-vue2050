package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GaoumaiEntity;
import java.util.Map;

/**
 * 已有保险 服务类
 * @author 
 * @since 2021-03-24
 */
public interface GaoumaiService extends IService<GaoumaiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}