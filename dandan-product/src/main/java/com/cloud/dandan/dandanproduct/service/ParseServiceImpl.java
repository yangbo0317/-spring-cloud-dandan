package com.cloud.dandan.dandanproduct.service;

import com.cloud.dandan.dandanproduct.HtmlParesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParseServiceImpl implements ParseDataService {
    @Autowired
    private HtmlParesUtil htmlParesUtil;
    @Override
    public List<GoodsInfo> getJdGoods(String keyWords) {
        List<GoodsInfo> goodsInfoList = htmlParesUtil.parseJdData(keyWords);
        return goodsInfoList;
    }
}