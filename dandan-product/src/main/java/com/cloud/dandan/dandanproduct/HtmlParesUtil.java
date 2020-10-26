package com.cloud.dandan.dandanproduct;

import com.cloud.dandan.dandanproduct.service.GoodsInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Component
public class HtmlParesUtil {
//    public static void main(String[] args) {
//        String url = "https://search.jd.com/Search?keyword=java";
//        try {
//            Document document = Jsoup.parse(new URL(url),30000);
//            Element j_goodsList = document.getElementById("J_goodsList");
//            Elements elements = j_goodsList.getElementsByTag("li");
//            for (Element el:elements){
//                String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img").substring(2);
//                String price = el.getElementsByClass("p-price").eq(0).text();
//                String name = el.getElementsByClass("p-name").eq(0).text();
//                System.out.println(img);
//                System.out.println(price);
//                System.out.println(name);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public List<GoodsInfo> parseJdData(String keysWords){
        List<GoodsInfo> goodsInfoList = new ArrayList();
        String url = "https://search.jd.com/Search?keyword="+keysWords;
        try {
            Document document = Jsoup.parse(new URL(url),30000);
            Element j_goodsList = document.getElementById("J_goodsList");
            Elements elements = j_goodsList.getElementsByTag("li");
            for (Element el:elements){
                GoodsInfo goodsInfo = new GoodsInfo();
                String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img").substring(2);
                String price = el.getElementsByClass("p-price").eq(0).text();
                String name = el.getElementsByClass("p-name").eq(0).text();
                goodsInfo.setGoodsName(name);
                goodsInfo.setPrice(price);
                goodsInfo.setImg(img);
                goodsInfoList.add(goodsInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return goodsInfoList;
    }


}
