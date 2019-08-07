package com.palani.springmongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 public static final String CONTROLLER_BASEPACKAGE = "com.palani.springmongo.controller";

	
	 	@Value("${swagger.api.title}")
	    private String title;

	    @Value("${swagger.api.description}")
	    private String description;
	    
	    
	    @Bean
	    public Docket api() {
	        return generateDocket("api", CONTROLLER_BASEPACKAGE,
	                "/**");
	    }
	    
	    @Bean
	    public Docket actuator() {
	        return generateDocket("actuator", "org.springframework.boot", "/actuator/**");
	    }
	    
	    private Docket generateDocket(String groupName, String basePackage, String antPattern) {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName(groupName)
	                .apiInfo(metaData())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage(basePackage))
	                .paths(PathSelectors.ant(antPattern))
	                .build();
	    }
	    
	    private ApiInfo metaData() {
	        return new ApiInfoBuilder().title(title).description(description).build();
	    }

}
