package com.MTAPizza.Sympoll.api_gateway_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("Configuring CORS...");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://localhost", "http://sympoll.ddns.net")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600); // Cache preflight response for 1 hour
        logger.info("CORS configured with allowed origins: http://localhost:8080, http://localhost, http://sympoll.ddns.net"); // Cache preflight response for 1 hour
    }
}
