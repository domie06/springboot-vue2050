package com.dao;

import com.entity.GaoumaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GaoumaiView;

/**
 * 已有保险 Dao 接口
 *
 * @author 
 * @since 2021-03-24
 */
public interface GaoumaiDao extends BaseMapper<GaoumaiEntity> {

   List<GaoumaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
