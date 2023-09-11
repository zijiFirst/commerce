package com.imooc.ecommerce.controller;

import com.imooc.ecommerce.service.NacosClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * nacos client controller
 */

@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    @Resource
    private NacosClientService nacosClientService;

    /**
     * 根据 service id 获取服务所有的实例信息
     * @param serviceId
     * @return
     */
    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosClientInfo(
            @RequestParam(defaultValue = "4a57fa2c-f8f9-4105-82c5-f7032feb8e9d") String serviceId) {
        log.info("coming in log nacos client info:[{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }
}
