package com.lengke.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//注册中心是eureka 推荐使用@EnableEurekaClient,如果是其他的 推荐使用@EnableDiscoveryClient
//@EnableDiscoveryClient
@EnableEurekaClient
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
