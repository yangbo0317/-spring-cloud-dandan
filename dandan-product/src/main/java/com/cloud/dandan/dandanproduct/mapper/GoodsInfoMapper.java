package com.cloud.dandan.dandanproduct.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.dandan.dandanproduct.model.GoodsInfoDO;
import com.cloud.dandan.dandanproduct.model.GoodsInfoDOExample;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GoodsInfoMapper extends IService<GoodsInfoDO> {
}