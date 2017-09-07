package com.redteamobile.matrix.controller.sandbox;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redteamobile.matrix.config.resource.CustomResource;
import com.redteamobile.matrix.controller.BaseController;
import com.redteamobile.matrix.model.page.ResponseStruct;
import com.redteamobile.matrix.model.page.SwaggerSamplePage;
import com.redteamobile.matrix.model.req.UserParam;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/v1/sandbox")
public class SandboxController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }

    @Autowired
    private CustomResource customResource;

    @ResponseBody
    @RequestMapping("/config/resource")
    @ApiOperation(notes = "写一个测试用来读取资源文件", httpMethod = "GET", response = ResponseStruct.class, value = "资源文件读取", produces = "application/json;charset=utf-8")
    public ResponseStruct config() {
        String result = "hello: " + customResource.getName();
        ResponseStruct res = new ResponseStruct();
        res.setCode("200");
        res.setMsg("success");
        res.setObj(result);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/config/i18n", method = RequestMethod.GET)
    @ApiOperation(notes = "写一个测试用来测国际化模块的可用性", httpMethod = "GET", response = ResponseStruct.class, value = "国际化的测试入口", produces = "application/json;charset=utf-8")
    public ResponseStruct i18n() {
        // 尝试不抛出异常，来对比
        String slogan = localeMessageSource.getMessage("RT_MATRIX_INFO_101");
        logger.info("slogan from i18n config: " + slogan);
        ResponseStruct res = new ResponseStruct();
        res.setCode("200");
        res.setMsg("success");
        res.setObj(slogan);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/swagger/apiModel", method = RequestMethod.POST)
    @ApiOperation(notes = "SwaggerApiModel示范", httpMethod = "POST", response = SwaggerSamplePage.class, value = "Swagger的注解说明:https://github.com/swagger-api/swagger-core/wiki/Annotations", produces = "application/json;charset=utf-8")
    public SwaggerSamplePage apiModelUsage(@RequestBody UserParam userParam) {
        logger.info("userParam: {}", userParam);
        SwaggerSamplePage res = new SwaggerSamplePage();
        res.setCode("200");
        res.setCountries(new ArrayList<String>());
        res.setMsg("Slence is gold");
        res.setSuccess(true);
        return res;
    }

}
