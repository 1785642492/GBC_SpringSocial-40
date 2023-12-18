package com.gbc.springsocial.service.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gbc.springsocial.shared.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

/*@Component
public class UserServiceClient {

    private final WebClient webClient;

    @Autowired
    public UserServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://user-service").build();
    }

    public User getUserById(String userId) {
        return webClient.get()
                .uri("/user/{userId}", userId)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

}*/

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
