package com.ntt.gateway.config;
import com.ntt.gateway.application.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableHystrix
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service", r -> r.path("/api/accounts/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://account-service"))

                .route("user-service", r -> r.path("/api/customers/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))
                .build();
    }

}