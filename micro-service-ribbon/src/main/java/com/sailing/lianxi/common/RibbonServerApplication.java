
package com.sailing.lianxi.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
该注解指定项目为springboot，由此类当作程序入口
自动装配 web 依赖的环境
**/
@SpringBootApplication(scanBasePackages="com.sailing.*")
@EnableDiscoveryClient //通过@EnableDiscoveryClient向服务中心注册
@EnableHystrix
public class RibbonServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RibbonServerApplication.class, args);
    }
}

