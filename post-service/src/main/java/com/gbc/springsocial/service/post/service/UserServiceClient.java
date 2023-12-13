package com.gbc.springsocial.service.post.service;

import com.gbc.springsocial.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserServiceClient {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public UserServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<User> getUserDetails(String userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://user-service/api/user/{userId}", userId)
                .retrieve()
                .bodyToMono(User.class);
    }
}
