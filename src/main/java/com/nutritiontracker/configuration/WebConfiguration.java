package com.nutritiontracker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * we don't need to implement every method of this interface because the interface itself provides
 * default implementation for each method (that's why there is the keyword default if we look into its source)
 *
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * https://docs.spring.io/spring-framework/reference/web/webmvc-cors.html
     * https://www.baeldung.com/spring-cors
     *
     * https://stackoverflow.com/questions/19976487/explicitly-calling-a-default-method-in-java
     * https://www.baeldung.com/java-static-default-methods
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //WebMvcConfigurer.super.addCorsMappings(registry); // calling default method in the interface
        registry.addMapping("/**") // for which actions on our server (paths) will be the new rules applied ("/**" means all paths starting with "/")
                .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedOriginPatterns("**") // which foreign paths to allow ("**" means all)
                .allowCredentials(true); // allow sending of cookies to foreign URL, later used for authentication
    }

}
