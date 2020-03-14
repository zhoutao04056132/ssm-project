package com.zhou.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhou.common.ResponseData;
import com.zhou.common.constant.QueryConstant;
import com.zhou.model.School;
import com.zhou.service.ISchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api("学校管理")
@Controller
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private ISchoolService schoolService;

    @ApiOperation(value = "根据用户id查询学校信息", notes = "根据用户id查询学校信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "学校id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/common/schools/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseData querySchoolById(@PathVariable("id") Integer id) throws Exception {
        ResponseData responseData = ResponseData.ok();
        School school = schoolService.selectSchoolById(id);

        responseData.getData().put("school", school);

        return responseData;
    }

    @ApiOperation(value = "默认的分页查询学校，按学校名称拼音排序", notes = "默认的分页查询学校，按学校名称拼音排序", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", required = true, name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = true, name = "size", value = "每页数据条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/schools", method = RequestMethod.GET)
    public @ResponseBody ResponseData querySchoolsByPage(
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "size", required = true) Integer size) throws Exception {
        ResponseData responseData = ResponseData.ok();

        if (null == page) {
            page = QueryConstant.DEFAULT_QUERY_PAGE;
        }

        if (null == size) {
            size = QueryConstant.DEFAULT_QUERY_PAGE_SIZE;
        }

        Page<School> schoolPage = schoolService.selectSchoolsByPage(page, size);
        PageInfo<School> schoolPageInfo = schoolPage.toPageInfo();

        responseData.getData().put("schoolPageInfo", schoolPageInfo);

        return responseData;
    }


    @ApiOperation(value = "按条件分页查询学校", notes = "按条件分页查询学校", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", required = false, name = "provinceId", value = "省id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = false, name = "sourceId", value = "地区id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = false, name = "subjectionName", value = "院校隶属名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", required = true, name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = true, name = "size", value = "每页数据条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/schools/condition", method = RequestMethod.GET)
    public @ResponseBody ResponseData querySchoolsByConditionByPage(
            @RequestParam(value = "provinceId", required = false) Integer provinceId,
            @RequestParam(value = "sourceId", required = false) Integer sourceId,
            @RequestParam(value = "subjectionName", required = false) String subjectionName,
            @RequestParam(value = "page", required = true) Integer page,
            @RequestParam(value = "size", required = true) Integer size) throws Exception {
        ResponseData responseData = ResponseData.ok();

        if (null == page) {
            page = QueryConstant.DEFAULT_QUERY_PAGE;
        }

        if (null == size) {
            size = QueryConstant.DEFAULT_QUERY_PAGE_SIZE;
        }

        Page<School> schoolPage = schoolService.selectSchoolsByConditionByPage(provinceId, sourceId, subjectionName, page, size);
        PageInfo<School> schoolPageInfo = schoolPage.toPageInfo();

        responseData.getData().put("schoolPageInfo", schoolPageInfo);

        return responseData;
    }


    @ApiOperation(value = "保存学校", notes = "保存学校", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "school", value = "学校对象", dataType = "School"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/schools", method = RequestMethod.POST)
    public @ResponseBody ResponseData saveSchool(@RequestBody School school)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        school = schoolService.insertSchool(school);

        responseData.getData().put("school", school);

        return responseData;
    }

    @ApiOperation(value = "修改学校信息", notes = "修改学校信息", httpMethod = "PUT", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "school", value = "学校对象", dataType = "School"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/schools", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateSchool(@RequestBody School school)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = schoolService.updateSchool(school);

        responseData.getData().put("result", result);

        return responseData;
    }

    @ApiOperation(value = "按id删除学校", notes = "按id删除学校", httpMethod = "DELETE", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "学校id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/schools/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseData deleteSchoolById(@PathVariable("id") Integer id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = schoolService.deleteSchoolById(id);

        responseData.getData().put("result", result);

        return responseData;
    }
}
