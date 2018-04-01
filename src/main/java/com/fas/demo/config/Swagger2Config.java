package com.fas.demo.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ResponseHeader
 * @Api：修饰整个类，描述Controller的作用,用在类上，说明该类的作用。可以标记一个Controller类做为swagger文档资源
 * @ApiOperation：描述一个类的一个方法，或者说一个接口,用在方法上，说明方法的作用，每一个url资源的定义
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数,描述一个Model的信息（这种一般用在post创建的时候，使用
 * @ApiProperty：用对象接收参数时，描述对象的一个字段,描述一个model的属性。
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError: 发生错误返回的信息
 * @ApiImplicitParam：一个请求参数
 * @ApiImplicitParams：多个请求参数

 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket apiDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Swagger2 API")
                .description("系统描述信息")
                .termsOfServiceUrl("").version("1.0")
                .contact(new Contact("fasminelee", "https://blog.fasminelee.com/", "fasminelee@163.com"))
                .version("1.0.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }
}