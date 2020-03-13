package com.zhou.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhou.common.ResponseData;
import com.zhou.common.util.AuthUtil;
import com.zhou.common.util.DateUtil;
import com.zhou.model.User;
import com.zhou.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
        User user = userService.selectUserById(1l);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping("/without/selectById1")
    /**
     * url:http://localhost:8080/ssm_project_war/user/selectById1?id=1
     */
    public @ResponseBody ResponseData selectUser1(HttpServletRequest request, long id) throws Exception {
        String accessToken = request.getHeader("accessToken");
        String name = request.getHeader("name");
        String userIdStr = request.getHeader("userId");
        ResponseData responseData = null;
        // 拦截器规则放过了该请求，在接口层进行token验证
        if (!AuthUtil.verifyAuth(accessToken, name, userIdStr)) {
            responseData = ResponseData.unAuthorized();
            return responseData;
        }

        responseData = ResponseData.ok();

        User user = userService.selectUserById(id);
        System.out.println("-----------------------user:" + user.getName());

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据id查询用户信息，使用RequestParam注解", notes = "根据id查询用户信息，使用RequestParam注解", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/without/selectById2")
    /**
     * url:http://localhost:8080/ssm_project_war/user/selectById2?id=1
     */
    public @ResponseBody ResponseData selectUser2(@RequestParam(value = "id", required = false, defaultValue = "1") long id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        User user = userService.selectUserById(id);
        if (null == user) {
            System.out.println("-----------------------user is null");
        } else {
            System.out.println("-----------------------user:" + user.getName());
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);

        responseData.setData(data);
        return responseData;
    }

    @ApiOperation(value = "根据id查询用户信息，以资源方式", notes = "根据id查询用户信息，以资源方式", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "long")
    @RequestMapping("/without/queryById3/{id}")
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

    @ApiOperation(value = "分页查询用户信息", notes = "分页查询用户信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", required = true, name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = true, name = "size", value = "每页数据条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = true, name = "name", value = "姓名", dataType = "String")
    })
    @RequestMapping("/without/selectUsersByPage")
    public @ResponseBody ResponseData selectUsersByPage(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "size", required = true) Integer size,
            @RequestParam(value = "name", required = true) String name) throws Exception {
        ResponseData responseData = ResponseData.ok();
        Page<User> userList = userService.selectUsersByPage(page, size, name);
        PageInfo pageInfo = userList.toPageInfo();

        responseData.getData().put("pageInfo", pageInfo);

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

    @ApiOperation(value = "保存用户", notes = "保存用户", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "user", value = "用户User对象", dataType = "User"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/saveUser1", method = RequestMethod.POST)
    /**
     * url:http://localhost:8080/ssm_project_war/user/saveUser1
     */
    public @ResponseBody ResponseData saveUser1(@RequestBody User user)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        User returnUser = userService.insertUserAndReturnUser(user);

        responseData.getData().put("user", returnUser);

        return responseData;
    }

    @ApiOperation(value = "批量保存用户", notes = "批量保存用户", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "userList", value = "用户User对象集合", dataType = "List"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/saveUserBatch", method = RequestMethod.POST)
    /**
     * url:http://localhost:8080/ssm_project_war/user/saveUserBatch
     */
    public @ResponseBody ResponseData saveUserBatch(@RequestBody List<User> userList)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = userService.insertUserBatch(userList);

        responseData.getData().put("result", result);

        return responseData;
    }

    @ApiOperation(value = "批量保存用户", notes = "批量保存用户", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "userList", value = "用户User对象集合", dataType = "List"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/saveUserBatch1", method = RequestMethod.POST)
    /**
     * url:http://localhost:8080/ssm_project_war/user/saveUserBatch1
     */
    public @ResponseBody ResponseData saveUserBatch1(@RequestBody List<User> userList)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        // 在接口层对参数进行验证，判空处理
        for (User user: userList) {
            if (null == user.getCreateTime()) {
                user.setCreateTime(DateUtil.createDefaultDate());
            }
        }
        System.out.println("userList:" + userList.toString());
        List<User> returnUserList = userService.insertUserBatchAndReturnUserList(userList);

        responseData.getData().put("userList", returnUserList);

        return responseData;
    }

    @ApiOperation(value = "批量修改用户名", notes = "批量修改用户名", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "name", value = "用户name", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/updateUserName/{name}", method = RequestMethod.GET)
    /**
     * url:http://localhost:8080/ssm_project_war/user/updateUserName/jason
     */
    public @ResponseBody ResponseData updateUserName(@PathVariable("name") String name)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = userService.updateUserName(name);

        responseData.getData().put("result", result);

        return responseData;
    }
}
