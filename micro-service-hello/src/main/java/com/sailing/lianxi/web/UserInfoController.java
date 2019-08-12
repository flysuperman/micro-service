
package com.sailing.lianxi.web;

import com.sailing.lianxi.entity.UserInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 类名称：UserInfoController
 * 类描述：获取信息controller
 * 创建人：wanggang
 * 创建时间：2018年4月27日 上午11:04:30
 * 修改人：wanggang
 * 修改时间：2018年4月27日 上午11:04:30
 * 修改备注：
 */
@Api(value="用户信息类",tags={"测试接口"})
@ApiModel(description="查询用户信息")
@RestController
@RequestMapping("user")
public class UserInfoController {
 
    @ApiOperation(value="获取用户信息",notes="输入字段包括名称")
    @ApiImplicitParams(
        @ApiImplicitParam(name="name",value="用户名",required=true,dataType="string",paramType="path")
    )
    @PostMapping("/test/{name}")
    public UserInfo findUser(@PathVariable("name") String name ){
        System.out.println("name============="+name);
        UserInfo userInfo = new UserInfo();
        if(name.equals("wanggang")){
            userInfo.setUserName(name);
            userInfo.setPassWord("11111111");
        }else{
           int a = 1/0; 
        }
        return userInfo;
    }
    
}

