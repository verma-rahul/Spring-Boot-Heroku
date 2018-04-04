package com.project.coursemanager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Rahul Verma
 * @version 0.0.1
 *
 * Class
 * WebConfig: used tp configure spring mvc configurations
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Method (overridden)
     * addCorsMappings: configure the CORS Support for All types of request for the Spring Boot Application
     * @param registry: CorsRegistry object
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
    }

}