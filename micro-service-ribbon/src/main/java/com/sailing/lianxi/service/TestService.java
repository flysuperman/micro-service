package com.sailing.lianxi.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sailing.lianxi.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

	 @Autowired
	RestTemplate restTemplate;

	 @Value("${clientPath}")
	 private String clientPath;

	@HystrixCommand(fallbackMethod = "hiError")
	public String hiService(String name) {
		String url = clientPath+"?name="+name;
		System.out.println("url="+url);
		return restTemplate.getForObject(url, String.class);
	}

	public String hiError(String name){
		return "hi,"+name+",访问服务失败!";
	}
}
