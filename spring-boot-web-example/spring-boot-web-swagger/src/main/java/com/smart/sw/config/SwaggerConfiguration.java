package com.smart.sw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

@Configuration
public class SwaggerConfiguration {
//    注解注入的

    //
    @Bean
    public Docket docket(ApiInfo apiInfo){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo);
    }

    /**
     * Docket
     * ApiInfo
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxx项目接口文档")
                .description("xxx项目的所有api文档")
                .build();
    }


}
