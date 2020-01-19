package com.zhou.controller;

import com.zhou.common.ResponseData;
import com.zhou.model.User;
import com.zhou.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
@Api("用户管理")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询用户信息，默认id", notes = "查询用户信息，默认id", httpMethod = "GET", response = ResponseData.class)
    @RequestMapping("/selectById")
    /**
     * url:http://localhost:8080/ssm_project_war/user/selectById
     */
    public @ResponseBody ResponseData selectUser() throws Exception {
        ResponseData responseData = ResponseData.ok();
        User user = userService.selectUserById(1);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/selectById1")
    /**
     * url:http://localhost:8080/ssm_project_war/user/selectById1?id=1
     */
    public @ResponseBody ResponseData selectUser1(long id) throws Exception {
        ResponseData responseData = ResponseData.ok();
        User user = userService.selectUserById(id);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据id查询用户信息，使用RequestParam注解", notes = "根据id查询用户信息，使用RequestParam注解", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/selectById2")
    /**
     * url:http://localhost:8080/ssm_project_war/user/selectById2?id=1
     */
    public @ResponseBody ResponseData selectUser2(@RequestParam(value = "id", required = false, defaultValue = "1") long id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        User user = userService.selectUserById(id);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据id查询用户信息，以资源方式", notes = "根据id查询用户信息，以资源方式", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/selectById3/{id}")
    /**
     * url:http://localhost:8080/ssm_project_war/user/selectById3/1
     */
    public @ResponseBody ResponseData selectUser3(@PathVariable("id") long id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        User user = userService.selectUserById(id);
        System.out.println("-----------------------user:" + user.getName());

        responseData.getData().put("user", user);

        return responseData;
    }

    @ApiOperation(value = "保存用户", notes = "保存用户", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "user", value = "用户User对象", dataType = "User"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    /**
     * url:http://localhost:8080/ssm_project_war/user/saveUser
     */
    public @ResponseBody ResponseData saveUser(@RequestBody User user)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = userService.insertUser(user);

        responseData.getData().put("result", result);

        return responseData;
    }
}
