package com.sailing.lianxi.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 向程序的ioc注入一个bean: restTemplate;
 * 并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
 * @author Administrator
 *
 */
@Configuration
public class RibbonConfig {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
