package com.sailing.lianxi.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixHiService implements HiService {
	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		return "sorry:"+name+",服务已中断";
	}


}
