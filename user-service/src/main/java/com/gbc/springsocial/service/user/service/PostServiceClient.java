package com.gbc.springsocial.service.user.service;

import com.gbc.springsocial.shared.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PostServiceClient {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public PostServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Post> getPostDetails(String postId) {
        return webClientBuilder.build()
                .get()
                .uri("http://post-service/api/post/{postId}", postId)
                .retrieve()
                .bodyToMono(Post.class);
    }
}
