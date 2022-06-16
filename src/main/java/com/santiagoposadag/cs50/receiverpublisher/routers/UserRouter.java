package com.santiagoposadag.cs50.receiverpublisher.routers;

import com.santiagoposadag.cs50.receiverpublisher.dto.UserDTO;
import com.santiagoposadag.cs50.receiverpublisher.usecases.AuthenticateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class UserRouter {

    private final ApplicationEventPublisher publisher;

    @Bean
    public RouterFunction<ServerResponse> authenticateUser(AuthenticateUserUseCase authenticateUserUseCase) {

        Function<UserDTO, Mono<ServerResponse>> executor =
                userDTO -> authenticateUserUseCase.apply(userDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/Authentication").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDTO.class)
                        .flatMap(executor));
    }


}
