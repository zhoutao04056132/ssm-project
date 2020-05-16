package com.zhou.controller.other;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhou.common.ResponseData;
import com.zhou.common.constant.QueryConstant;
import com.zhou.model.TestFile;
import com.zhou.service.ITestFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

@Controller
@Api(tags = "TestFile管理", description = "用于测试文件上传和下载")
@Validated
public class TestFileController {
    @Autowired
    private ITestFileService testFileService;

    @ApiOperation(value = "根据用户id查询TestFile信息", notes = "根据用户id查询TestFile信息", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/common/testFile/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseData queryTestFileById(@PathVariable("id") Integer id) throws Exception {
        ResponseData responseData = ResponseData.ok();
        TestFile testFile = testFileService.selectTestFileById(id);

        responseData.getData().put("testFile", testFile);

        return responseData;
    }

    @ApiOperation(value = "按条件分页查询TestFile", notes = "按条件分页查询TestFile", httpMethod = "GET", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", required = false, name = "page", value = "页码", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", required = false, name = "size", value = "每页数据条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = false, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = false, name = "accessToken", value = "accessToken", dataType = "String")
    })
    @RequestMapping(value = "/common/testFile", method = RequestMethod.GET)
    public @ResponseBody ResponseData queryTestFileByPage(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size) throws Exception {
        ResponseData responseData = ResponseData.ok();

        if (null == page) {
            page = QueryConstant.DEFAULT_QUERY_PAGE;
        }

        if (null == size) {
            size = QueryConstant.DEFAULT_QUERY_PAGE_SIZE;
        }

        Page<TestFile> testFilePage = testFileService.selectTestFilesByPage(page, size);
        PageInfo<TestFile> testFilePageInfo = testFilePage.toPageInfo();

        responseData.getData().put("testFilePageInfo", testFilePageInfo);

        return responseData;
    }


    @ApiOperation(value = "保存TestFile", notes = "保存TestFile", httpMethod = "POST", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "testFile", value = "TestFile对象", dataType = "TestFile"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/testFile", method = RequestMethod.POST)
    public @ResponseBody ResponseData saveTestFile(@RequestBody TestFile testFile) throws Exception {
        ResponseData responseData = ResponseData.ok();
        testFile = testFileService.insertTestFile(testFile);

        responseData.getData().put("testFile", testFile);

        return responseData;
    }

    @ApiOperation(value = "修改TestFile", notes = "修改TestFile", httpMethod = "PUT", consumes = "application/json", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", required = true, name = "testFile", value = "TestFile对象", dataType = "TestFile"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/testFile", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateTestFile(@RequestBody TestFile testFile)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = testFileService.updateTestFile(testFile);

        responseData.getData().put("result", result);

        return responseData;
    }

    @ApiOperation(value = "按id删除TestFile", notes = "按id删除TestFile", httpMethod = "DELETE", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", required = true, name = "id", value = "id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/testFile/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseData deleteTestFileById(@PathVariable("id") Integer id)
            throws Exception {
        ResponseData responseData = ResponseData.ok();
        int result = testFileService.deleteTestFileById(id);

        responseData.getData().put("result", result);

        return responseData;
    }

    @ApiOperation(value = "上传文件", notes = "上传文件", httpMethod = "POST", response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", required = true, name = "name", value = "用户名", dataType = "String"),
            @ApiImplicitParam(paramType = "header", required = true, name = "userId", value = "用户id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", required = true, name = "accessToken", value = "accessToken", dataType = "String")

    })
    @RequestMapping(value = "/common/testFile/upload", method = RequestMethod.POST)
    public @ResponseBody ResponseData uploadTestFile(
            @RequestParam(value = "file", required = true)CommonsMultipartFile file,
            HttpServletRequest request,
            ModelMap model) throws Exception {
        ResponseData responseData = ResponseData.ok();
        // 获得原始文件名
        String fileName = file.getOriginalFilename();

        // 生成新文件名
        String newFileName = UUID.randomUUID() + fileName;

        // 文件上传路径
        String path = "F:\\work\\upload\\";

        File newFile = new File(path);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();

                int bits = 0;
                while ((bits = in.read()) != -1) {
                    fos.write(bits);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
                responseData = ResponseData.uploadFail();
                return responseData;
            }
        }

        TestFile testFile = new TestFile();
        testFile.setName(newFileName);
        testFile.setUrl(path + newFileName);
        testFile = testFileService.insertTestFile(testFile);

        responseData.getData().put("testFile", testFile);

        return responseData;
    }

    @RequestMapping(value = "/common/testFile/loadFile", method = RequestMethod.GET)
    public String loadFile(ModelMap modelMap) throws Exception {
        return "loadFile";
    }
}
