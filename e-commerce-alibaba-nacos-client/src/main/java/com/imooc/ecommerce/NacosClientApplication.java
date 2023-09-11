package com.imooc.ecommerce;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 工程启动入口
 *
 * @EnableDiscoveryClient 实现服务注册与发现
 */
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class NacosClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
        log.info("项目启动成功");
    }
}
