
package com.sailing.lianxi.web;

import com.sailing.lianxi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用于负载均衡 访问地址：http://localhost:8764/cm?name=forezp
 */
@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
    @RequestMapping("/cm")
    public String home(@RequestParam String name) {
      return testService.hiService(name);
    }
}

