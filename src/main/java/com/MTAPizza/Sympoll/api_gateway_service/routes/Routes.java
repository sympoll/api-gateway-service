package com.MTAPizza.Sympoll.api_gateway_service.routes;

import com.MTAPizza.Sympoll.api_gateway_service.ApiGatewayServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    private static final Logger log = LoggerFactory.getLogger(ApiGatewayServiceApplication.class);

    @Value("${poll.route.uri}")
    private String pollRouteUri;

    @Value("${group.route.uri}")
    private String groupRouteUri;

    @Value("${user.route.uri}")
    private String userRouteUri;

    @Value("${vote.route.uri}")
    private String voteRouteUri;

    @Value("${media.route.uri}")
    private String mediaRouteUri;

    @Bean
    public RouterFunction<ServerResponse> pollServiceRoute() {
        log.info("Received a poll route request");
        return GatewayRouterFunctions.route("poll-service")
                .route(RequestPredicates.path("api/poll/**"), HandlerFunctions.http(pollRouteUri))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> groupServiceRoute() {
        log.info("Received a group route request");
        return GatewayRouterFunctions.route("group-service")
                .route(RequestPredicates.path("api/group/**"), HandlerFunctions.http(groupRouteUri))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        log.info("Received a user route request");
        return GatewayRouterFunctions.route("user-service")
                .route(RequestPredicates.path("api/user/**"), HandlerFunctions.http(userRouteUri))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> voteServiceRoute() {
        log.info("Received a vote route request");
        return GatewayRouterFunctions.route("vote-service")
                .route(RequestPredicates.path("api/vote/**"), HandlerFunctions.http(voteRouteUri))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> mediaServiceRoute() {
        log.info("Received a media route request");
        return GatewayRouterFunctions.route("media-service")
                .route(RequestPredicates.path("api/media/**"), HandlerFunctions.http(mediaRouteUri))
                .build();
    }
}
