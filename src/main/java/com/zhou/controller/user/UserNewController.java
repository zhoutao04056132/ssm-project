package com.zhou.controller.user;

import com.zhou.common.ResponseData;
import com.zhou.model.GroupNameVo;
import com.zhou.model.UserNew;
import com.zhou.service.IUserNewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "New用户管理", description = "用于测试基础功能，没有实际业务含义")
@RequestMapping("/common/user-new")
@Validated
public class UserNewController {
    @Autowired
    private IUserNewService userNewService;

    @ApiOperation(value = "查询用户信息，默认id", notes = "查询用户信息，默认id", httpMethod = "GET", response = ResponseData.class)
    @RequestMapping("/selectById")
    public @ResponseBody ResponseData selectUser() throws Exception {
        ResponseData responseData = ResponseData.ok();
        UserNew user = userNewService.selectUserNewById(1);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/selectById1")
    public @ResponseBody ResponseData selectUser1(long id) throws Exception {
        ResponseData responseData = ResponseData.ok();
        UserNew user = userNewService.selectUserNewById(id);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据id查询用户信息，使用RequestParam注解", notes = "根据id查询用户信息，使用RequestParam注解", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/selectById2")
    public @ResponseBody ResponseData selectUser2(@RequestParam(value = "id", required = false, defaultValue = "1") long id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        UserNew user = userNewService.selectUserNewById(id);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据id查询用户信息，以资源方式", notes = "根据id查询用户信息，以资源方式", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/selectById3/{id}")
    public @ResponseBody ResponseData selectUser3(@PathVariable("id") long id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        UserNew user = userNewService.selectUserNewById(id);

        System.out.println("-----------------------user:" + user.getName());

        responseData.getData().put("user", user);

        return responseData;
    }

    @ApiOperation(value = "按分组查询用户名", notes = "按分组查询用户名", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping("/group-names")
    public @ResponseBody ResponseData queryGroupNames() throws Exception {
        ResponseData responseData = ResponseData.ok();
        List<String> nameList = userNewService.selectGroupNames();

        responseData.getData().put("nameList", nameList);

        return responseData;
    }

    @ApiOperation(value = "按分组查询用户名", notes = "按分组查询用户名，返回信息包括分组对应的数量", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping("/group-name-vos")
    public @ResponseBody ResponseData queryGroupNameVos() throws Exception {
        ResponseData responseData = ResponseData.ok();
        List<GroupNameVo> nameVoList = userNewService.selectGroupNameVos();

        responseData.getData().put("nameVoList", nameVoList);

        return responseData;
    }
}
