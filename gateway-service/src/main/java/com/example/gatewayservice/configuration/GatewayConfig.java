package com.example.gatewayservice.configuration;


import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("microservice-produits", p -> p
                        .path("/products/**")
                        .filters(
                                f -> f.stripPrefix(1)
                                        .circuitBreaker(c->c.setName("circuitBreaker").setFallbackUri("/defaultFallback"))
                        )
                        .uri("lb://MICROSERVICE-PRODUITS/"))
                .route("microservice-commandes", p -> p
                        .path("/commands/**")
                        .filters(
                                f -> f.stripPrefix(1)
                                        .circuitBreaker(c->c.setName("circuitBreaker").setFallbackUri("/defaultFallback"))
                        )
                        .uri("lb://MICROSERVICE-COMMANDES"))
                .route("microservice-paiments", p -> p
                        .path("/payments/**")
                        .filters(
                                f -> f.stripPrefix(1)
                                        .circuitBreaker(c->c.setName("circuitBreaker").setFallbackUri("/defaultFallback"))
                        )
                        .uri("lb://MICROSERVICE-PAIMENTS"))
                .build();
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer()
    {
        return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(2)).build()).build());
    }
}
