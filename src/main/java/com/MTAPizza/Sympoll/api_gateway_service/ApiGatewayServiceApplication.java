package com.MTAPizza.Sympoll.api_gateway_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayServiceApplication {

	@Value("${poll.route.uri}")
	private String pollRouteUri;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/poll/**")
						.filters(f -> f
								.prefixPath("/api")
								.addResponseHeader("Response-Powered-By", "API Gateway Service"))
						.uri(pollRouteUri)
				)
				.build();
	}
}
