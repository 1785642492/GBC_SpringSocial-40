import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
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

}
