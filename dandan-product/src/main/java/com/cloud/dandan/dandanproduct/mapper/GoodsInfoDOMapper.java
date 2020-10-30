package com.cloud.dandan.dandanproduct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.dandan.dandanproduct.model.GoodsInfoDO;
import com.cloud.dandan.dandanproduct.model.GoodsInfoDOExample;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsInfoDOMapper  {
    long countByExample(GoodsInfoDOExample example);

    int deleteByExample(GoodsInfoDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfoDO record);

    int insertSelective(GoodsInfoDO record);

    List<GoodsInfoDO> selectByExample(GoodsInfoDOExample example);

    GoodsInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsInfoDO record, @Param("example") GoodsInfoDOExample example);

    int updateByExample(@Param("record") GoodsInfoDO record, @Param("example") GoodsInfoDOExample example);

    int updateByPrimaryKeySelective(GoodsInfoDO record);

    int updateByPrimaryKey(GoodsInfoDO record);
}