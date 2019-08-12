
package com.sailing.lianxi.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 该注解指定项目为springboot，由此类当作程序入口
 自动装配 web 依赖的环境
 **/
@SpringBootApplication(scanBasePackages="com.sailing.*")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.sailing.lianxi.service","com.sailing.lianxi.web"})
public class FeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApplication.class, args);
    }

}
