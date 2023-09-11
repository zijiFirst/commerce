package com.imooc.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NacosClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    // 服务实例可能有多个，使用List
    // ServiceInstance对应每一个服务实例

    /**
     * 打印Nacos Client 信息到日志中
     *
     * @param serviceId 应用名称
     * @return
     */
    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        log.info("request nacos client to get service instance info:[{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }
}
