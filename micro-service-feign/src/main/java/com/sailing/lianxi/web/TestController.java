
package com.sailing.lianxi.web;

import com.sailing.lianxi.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {

		//编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
	  	@Autowired
		HiService schedualServiceHi;
	  	
	    @RequestMapping(value = "/hi",method = RequestMethod.GET)
	    public String sayHi(@RequestParam String name){
	        return schedualServiceHi.sayHiFromClientOne(name);
	    }

	    @RequestMapping(value = "/hi/{name}/{method}",method = RequestMethod.POST)
		public String queryUserInfo(
				 @PathVariable(value = "name") String name
				,@PathVariable(value = "method") String method
				,@RequestBody(required = false) String condition
				,@RequestHeader("userId") String userId){
			return "";
		}
}

