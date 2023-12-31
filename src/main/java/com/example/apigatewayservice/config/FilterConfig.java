package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){ // application 설정 파일에서도 설정가능(properties, yml)
        return builder.routes()
                .route(r -> r.path("/first-service/**") //path 확인
                        .filters(f -> f.addRequestHeader("first-request","first-request-header")
                                       .addResponseHeader("first-response", "first-response-header")) //필터 적용
                        .uri("http://localhost:8081")) //uri로 이동
                .route(r -> r.path("/second-service/**") //path 확인
                        .filters(f -> f.addRequestHeader("second-request","second-request-header")
                                .addResponseHeader("second-response", "second-response-header")) //필터 적용
                        .uri("http://localhost:8082")) //uri로 이동
                .build();
    }
}
