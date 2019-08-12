
package com.sailing.lianxi.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("helloword1")
    public String hellWorld(){
        return "你好 hellloword1";
    }
    
    /**
     * 访问url:http://127.0.0.1:8002/helloword2
     * @return
     */
    @GetMapping("helloword2")
    public String helloword2(){
        ServerProperties dd;
        return "你好 hellloword2";
    }
    
    @GetMapping("helloword3")
    public String helloword3(){
        ServerProperties dd;
        return "你好 hellloword3";
    }
    
    /**
     * 访问url:http://127.0.0.1:8002/hi?name=wg
     */
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",你访问到项目是【micor-service-hello】项目: port:" +port;
    }
}

