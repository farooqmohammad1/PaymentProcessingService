package com.cpt.payments.service.http;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class HttpClientService {

    private final WebClient.Builder webClientBuilder;

    public <T, R> R sendRequest(String baseUrl, String path, HttpMethod method, T requestBody, Class<R> responseType) {
        return webClientBuilder.build()
                .method(method)
                .uri(baseUrl + path)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType)
                .block(); // blocking here for simplicity
    }
}
