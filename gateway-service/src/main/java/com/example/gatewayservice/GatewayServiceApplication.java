package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/*
	 * Dynamic routing locator using the eureka server
	 * */
//	@Bean
//	public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
//		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
//	}

}
