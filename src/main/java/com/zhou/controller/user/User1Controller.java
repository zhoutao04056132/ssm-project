package com.zhou.controller.user;

import com.zhou.common.ResponseData;
import com.zhou.model.User;
import com.zhou.model.User1;
import com.zhou.service.IUser1Service;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class User1Controller {
    @Autowired
    private IUser1Service user1Service;

    @ApiOperation(value = "根据id查询用户信息，使用RequestParam注解", notes = "根据id查询用户信息，使用RequestParam注解", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/common/user1s/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseData selectUser2(@PathVariable(value = "id", required = true) Integer id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        User1 user1 = user1Service.selectUser1ById(id);

        responseData.getData().put("user1", user1);

        return responseData;
    }

    @ApiOperation(value = "查询用户数量", notes = "查询用户数量", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/common/user1s-count", method = RequestMethod.GET)
    public @ResponseBody
    ResponseData selectUser1Count()
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = user1Service.selectUser1Count();

        responseData.getData().put("result", result);

        return responseData;
    }

}
