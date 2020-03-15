package com.zhou.controller.user;

import com.zhou.common.ResponseData;
import com.zhou.common.util.JwtUtil;
import com.zhou.model.User;
import com.zhou.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "权限管理", description = "用于测试基础功能，没有实际业务含义")
@RequestMapping("/auth")
@Validated
public class AuthController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    /**
     * url:http://localhost:8080/ssm_project_war/auth/login?name=jason&realName=jason-zhou
     */
    public @ResponseBody ResponseData login(@RequestParam(value = "name", required = true) String name,
                       @RequestParam(value = "realName", required = true) String realName)
            throws Exception {
        User user = userService.selectUserByName(name, realName);

        // DB获取用户失败则直接返回登录失败页面
        if (null == user) {
            ResponseData responseData = ResponseData.loginFail();
            return responseData;
        }

        System.out.println("-----------------------user:" + user.getName());

        // 生成token
        String token = JwtUtil.sign(name, String.valueOf(user.getId()));
        ResponseData responseData = ResponseData.ok();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("user", user);
        data.put("token", token);
        responseData.setData(data);

        return responseData;
    }
}
