package com.github.atomic.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Project:
 * @Description:
 * @Version 1.0.0
 * @Throws SystemException:
 * @Author: <li>2018/12/19/019 Administrator Create 1.0
 * @Copyright ©2018-2019 al.github
 * @Modified By:
 */
@EnableZuulProxy
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.github.atomic.gateway", "com.github.atomic.common.bean"})
public class AtomicGatewayApplication {

//  http://localhost:9999/auth/oauth/token?username=admin&password=123456&grant_type=password&scope=server&client_id=atomic&client_secret=atomic
    public static void main(String[] args) {
        SpringApplication.run(AtomicGatewayApplication.class,args);
    }
}
