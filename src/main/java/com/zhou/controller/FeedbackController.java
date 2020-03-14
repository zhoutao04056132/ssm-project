package com.zhou.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhou.common.ResponseData;
import com.zhou.common.constant.QueryConstant;
import com.zhou.model.Feedback;
import com.zhou.service.IFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api("Feedback管理")
@Controller
@RequestMapping("/user")
public class FeedbackController {
    @Autowired
    private IFeedbackService feedbackService;

    @ApiOperation(value = "根据用户id查询Feedback信息", notes = "根据用户id查询Feedback信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "Feedback的id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/common/feedback/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseData queryFeedbackById(@PathVariable("id") Integer id) throws Exception {
        ResponseData responseData = ResponseData.ok();
        Feedback feedback = feedbackService.selectFeedbackById(id);

        responseData.getData().put("feedback", feedback);

        return responseData;
    }

    @ApiOperation(value = "按条件分页查询Feedback", notes = "按条件分页查询Feedback", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = true, name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = true, name = "size", value = "每页数据条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/feedback", method = RequestMethod.GET)
    public @ResponseBody ResponseData queryFeedbackByUserIdByPage(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "size", required = true) Integer size) throws Exception {
        ResponseData responseData = ResponseData.ok();

        if (null == page) {
            page = QueryConstant.DEFAULT_QUERY_PAGE;
        }

        if (null == size) {
            size = QueryConstant.DEFAULT_QUERY_PAGE_SIZE;
        }

        Page<Feedback> feedbackPage = feedbackService.selectFeedbackByUserIdByPage(userId, page, size);
        PageInfo<Feedback> feedbackPageInfo = feedbackPage.toPageInfo();

        responseData.getData().put("feedbackPageInfo", feedbackPageInfo);

        return responseData;
    }


    @ApiOperation(value = "保存Feedback", notes = "保存Feedback", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "feedback", value = "Feedback对象", dataType = "Feedback"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public @ResponseBody ResponseData saveFeedback(@RequestBody Feedback feedback) throws Exception {
        ResponseData responseData = ResponseData.ok();
        feedback = feedbackService.insertFeedback(feedback);

        responseData.getData().put("feedback", feedback);

        return responseData;
    }

    @ApiOperation(value = "修改Feedback", notes = "修改Feedback", httpMethod = "PUT", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "school", value = "Feedback对象", dataType = "Feedback"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/feedback", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateFeedback(@RequestBody Feedback feedback)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = feedbackService.updateFeedback(feedback);

        responseData.getData().put("result", result);

        return responseData;
    }

    @ApiOperation(value = "按id删除Feedback", notes = "按id删除Feedback", httpMethod = "DELETE", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "Feedback的id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseData deleteFeedbackById(@PathVariable("id") Integer id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = feedbackService.deleteFeedbackById(id);

        responseData.getData().put("result", result);

        return responseData;
    }
}
