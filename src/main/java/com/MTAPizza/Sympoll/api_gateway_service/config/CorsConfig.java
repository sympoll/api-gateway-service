package com.MTAPizza.Sympoll.api_gateway_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@Configuration
public class CorsConfig {

    @Bean
    public WebFilter corsWebFilter() {
        return (ServerWebExchange exchange, WebFilterChain chain) -> {
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://localhost:8080");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Credentials", "true");
            return chain.filter(exchange);
        };
    }
}
