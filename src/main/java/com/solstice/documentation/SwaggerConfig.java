/*
*  Created by
*  @Author Avanish Patel
*/

package com.solstice.documentation;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author avanish
 * class to generate the API documentation
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.solstice")).paths(PathSelectors.regex("/contacts.*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Contacts REST API",
				"A​ ​RESTful​ ​API​ ​that​ ​would​ ​allow​ ​a​ ​web​ ​or​ ​mobile​ ​front-end​ ​to:\n"
						+ "● Create​ ​a​ ​contact​ ​record\n" + "● Retrieve​ ​a​ ​contact​ ​record\n"
						+ "● Update​ ​a​ ​contact​ ​record\n" + "● Delete​ ​a​ ​contact​ ​record\n"
						+ "● Search​ ​for​ ​a​ ​record​ ​by​ ​email​ ​or​ ​phone​ ​number\n"
						+ "● Retrieve​ ​all​ ​records​ ​from​ ​the​ ​same​ ​state​ ​or​ ​city",
				"API TOS", "Terms of service",
				new springfox.documentation.service.Contact("Avanishbhai Patel", "", "patelabout@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}
}
