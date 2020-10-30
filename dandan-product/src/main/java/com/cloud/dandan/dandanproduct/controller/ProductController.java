package com.cloud.dandan.dandanproduct.controller;

import com.cloud.dandan.dandanproduct.mapper.GoodsInfoDOMapper;
import com.cloud.dandan.dandanproduct.mapper.GoodsInfoMapper;
import com.cloud.dandan.dandanproduct.model.GoodsInfoDO;
import com.cloud.dandan.dandanproduct.service.GoodsInfo;
import com.cloud.dandan.dandanproduct.service.ParseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * yangbo
 * 2020-10-30
 * spring-cloud-dandan
 **/
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private GoodsInfoDOMapper goodsInfoDOMapper;
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private ParseDataService parseDataService;

    @GetMapping("getAllProduct")
    public Object getAllProduct() {
        GoodsInfoDO goodsInfoDO = goodsInfoDOMapper.selectByPrimaryKey(1L);
        return goodsInfoDO;
    }

    @GetMapping("insertProduct")
    public Object insertProduct(String keyword,@RequestParam(required = false,defaultValue = "10") Integer pageCount) {
        for (int i = 1; i < pageCount; i++) {
            List<GoodsInfo> jdGoods = parseDataService.getJdGoods(keyword,i);
            List<GoodsInfoDO> goodsInfoDOS = new ArrayList<>();
            for (GoodsInfo jdGood : jdGoods) {
                GoodsInfoDO goodsInfoDO = new GoodsInfoDO();
                goodsInfoDO.setImageUrl(jdGood.getImg());
                goodsInfoDO.setGoodName(jdGood.getGoodsName());
                goodsInfoDO.setPrice(jdGood.getPrice());
                goodsInfoDO.setIsDel(0);
                goodsInfoDO.setCreateTime(new Date());
                goodsInfoDO.setUpdateTime(new Date());
                //goodsInfoDOS.add(goodsInfoDO);
                goodsInfoDOMapper.insert(goodsInfoDO);
            }
            //goodsInfoMapper.saveBatch(goodsInfoDOS);
        }
        return "goodsInfoDO";
    }
}
