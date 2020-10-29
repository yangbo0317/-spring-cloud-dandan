package com.cloud.dandan.dandangateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DandanGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DandanGatewayApplication.class, args);
    }

}
