package com.MTAPizza.Sympoll.api_gateway_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ApiGatewayServiceApplication.class);
	@Value("${poll.route.uri}")
	private String pollRouteUri;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		log.info("Received request, routing to the specified route...");
		return builder.routes()
				.route(r -> r.path("/api/poll/**")
						.filters(f -> f
								.addResponseHeader("Response-Powered-By", "API Gateway Service"))
						.uri(pollRouteUri)
				)
//				.route(r -> r.path("/api/user/**"))
				.build();
	}
}
