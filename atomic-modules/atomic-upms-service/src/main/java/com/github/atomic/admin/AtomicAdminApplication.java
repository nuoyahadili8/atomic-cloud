package com.github.atomic.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Project:
 * @Description:
 * @Version 1.0.0
 * @Throws SystemException:
 * @Author: <li>2018/12/14/014 Administrator Create 1.0
 * @Copyright ©2018-2019 al.github
 * @Modified By:
 */
@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.github.atomic.admin", "com.github.atomic.common.bean"})
@MapperScan("com.github.atomic.admin.mapper")
public class AtomicAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtomicAdminApplication.class,args);
    }
}
