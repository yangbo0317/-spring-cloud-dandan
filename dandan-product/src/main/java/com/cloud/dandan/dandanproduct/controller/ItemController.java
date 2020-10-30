package com.cloud.dandan.dandanproduct.controller;

import com.cloud.dandan.dandanproduct.service.GoodsInfo;
import com.cloud.dandan.dandanproduct.service.ParseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ParseDataService parseDataService;
    @RequestMapping("getAllItem")
    public List<GoodsInfo> getAllItem(String keyWords){
        List<GoodsInfo> jdGoods = parseDataService.getJdGoods(keyWords,1);
        return jdGoods;
    }
}
