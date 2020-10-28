package com.cloud.dandan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;
//    @Value("${need.login}")
//    private Boolean needLogin;
//    @Value("${order.pwd}")
//    private String orderPwd;
    @RequestMapping("getUserServiceList")
    public String getUserServiceList(HttpServletRequest request){
        String remoteHost = getRemoteHost(request);
        List<ServiceInstance> dandan_user_instance = discoveryClient.getInstances("dandan_user");
        //轮训
//      ServiceInstance serviceInstance = loadBalancer.getSingleAddres(dandan_user_instance);
        //一致性hash
        ServiceInstance serviceInstance = loadBalancer.getSingleAddres(dandan_user_instance,remoteHost);
        if(serviceInstance==null){
            return "User-service not AVliable";
        }
        URI uri = serviceInstance.getUri();
        String restTemplateForObject = restTemplate.getForObject(uri + "/getUser", String.class);
        System.out.println(restTemplateForObject);
        return uri.getHost()+uri.getPort();
    }
    @RequestMapping("testConfig")
    public String testConfig(){
//        return "";
        return "ok";
    }
    /**
     * 获取目标主机的ip
     *
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }
}
