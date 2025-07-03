package com.cpt.payments.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
/*
* 29-6-2025 W5 D1 */

@Configuration
public class WebClientConfig {

    public WebClientConfig() {
        System.out.println("✅ WebClientConfig loaded...");
    }
    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
