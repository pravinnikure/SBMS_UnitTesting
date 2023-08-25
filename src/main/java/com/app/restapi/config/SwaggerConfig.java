package com.app.restapi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig 
{
	//Step Create bean of entire Docket 
	
	/*
	 * @Bean public Docket configureDocket() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage("com.app.restapi")) //Controller
	 * base package .paths(PathSelectors.regex("/v1/api.*")) //Meantion the
	 * controller start path of API means your rest controller start with this path
	 * .build() .apiInfo(apiInfo());//Metadata }
	 * 
	 * private ApiInfo apiInfo() {
	 * 
	 * return new ApiInfo( "Student Service", "Student Test Service", "v1.0",
	 * "http://student.com", new Contact("Pravin", "http://student.com",
	 * "pravin@gmail.com"), "V1-License", "http://v1-license.com",
	 * Collections.emptyList()); }
	 */
	
	
	
}
