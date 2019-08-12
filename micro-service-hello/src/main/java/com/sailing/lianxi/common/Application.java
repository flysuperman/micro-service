package com.sailing.lianxi.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication(scanBasePackages = Constants.SCANBASEPACKAGES)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
