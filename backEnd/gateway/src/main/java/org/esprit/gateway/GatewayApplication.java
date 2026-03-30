package org.esprit.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("candidat",
                        r->r.path("/candidat/**")
                                .uri("lb://candidat"))
                .route("job",
                        r->r.path("/job/**")
                                .uri("lb://Job"))
                .route("candidature",
                        r->r.path("/candidature/**")
                                .uri("lb://candidature"))
                .route("meeting",
                        r->r.path("/meeting/**")
                                .uri("lb://meeting"))
                .route("notification",
                        r->r.path("/notification/**")
                                .uri("lb://notification"))
                .build();
    }
}