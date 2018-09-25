package com.spring_mvc.controller;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.spring_mvc.model.User;
import com.spring_mvc.service.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api(value = "/user", tags = "User接口")
@EnableWebMvc
public class main {
    @Resource
    private UserService userService;

    @ApiOperation(value = "验证登录", notes = "根据name，password判断登录情况。")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "名称",paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",paramType = "query",dataType = "String")})
    @ResponseBody//将controller的方法返回的对象通过适当的转换器转换为指定的格式
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public JSONObject login(String name,String password){
        int id=userService.checkLogin(name, password);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        System.out.println(id);
        if(id>0){
            result.put("message", "登录成功");
        }else if(id==0){
            result.put("message", "无此用户");
        }else {
            result.put("message", "密码错误");
        }
        return result;
    }
    @ApiOperation(value = "验证注册", notes = "根据name，password判断注册情况。")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户id",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "name", value = "名称",paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码",paramType = "query",dataType = "String")})
    @ResponseBody
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public JSONObject register(int id,String name,String password){
        System.out.println(id+name+password);
        int res = userService.register(id,name, password);
        JSONObject  result = new JSONObject();
        result.put("code",res);
        if(res==0){
            result.put("message", "注册成功");
        }else {
            result.put("message", "注册失败");
        }
        return result;
    }
    @ApiOperation(value = "测试专用")
    @RequestMapping(value="/test",method=RequestMethod.GET)
    @ResponseBody
    public JSONObject test(){
        List<User> user = userService.alluser();
        JSONArray json = JSONArray.fromObject(user);
        JSONObject result = new JSONObject();
        result.put("result", 1);
        result.put("object", json);
        return result;
    }
}
