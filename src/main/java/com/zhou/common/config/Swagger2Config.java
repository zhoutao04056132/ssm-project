package com.zhou.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurationSupport {
    @Bean
    public Docket buildDocket() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .groupName("默认接口分组分组")
                .apiInfo(apiInfo())
                .select()
//                Controller所在路径
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.zhou.controller.other"))
                .paths(PathSelectors.any())
                .build();

    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户和权限接口分组")
                .genericModelSubstitutes(DeferredResult.class)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhou.controller.user"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("e-xuanbao系统在线API文档")
                .description("http对外开放接口，如有疑问请联系管理员")
                .termsOfServiceUrl("http://localhost:8080")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket openRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("学校接口分组")
                .genericModelSubstitutes(DeferredResult.class)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhou.controller.school"))
//     .apis(predicate)
                .paths(PathSelectors.any())
                .build();
    }
}
