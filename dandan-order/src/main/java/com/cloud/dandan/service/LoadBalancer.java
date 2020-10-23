package com.cloud.dandan.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 轮训算法
     * @param dandan_user_instance
     * @return
     */
    public ServiceInstance getSingleAddres(List<ServiceInstance> dandan_user_instance) {
        int size = dandan_user_instance.size();
        //轮训算法
        int index = atomicInteger.incrementAndGet()%dandan_user_instance.size();
//        随机算法
//        int ran2 = (int) (Math.random()*(size));
        return dandan_user_instance.get(index);
    }

    /**
     * 一致性hash
     * @param dandan_user_instance
     * @param ipAdrr
     * @return
     */
    public ServiceInstance getSingleAddres(List<ServiceInstance> dandan_user_instance,String ipAdrr) {
        //一致性hash
        int index = ipAdrr.hashCode()%dandan_user_instance.size();
        return dandan_user_instance.get(index);
    }
}
