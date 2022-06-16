package com.santiagoposadag.cs50.receiverpublisher.usecases;

import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverpublisher.config.RabbitMQConfig;
import com.santiagoposadag.cs50.receiverpublisher.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
@RequiredArgsConstructor
public class AuthenticateUserUseCase implements Function<UserDTO, Mono<UserDTO>> {

    private final RabbitTemplate rabbitTemplate;
    private final Gson gson = new Gson();

    @Override
    public Mono<UserDTO> apply(@Validated UserDTO userDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                userDTO.getRoutingKey(),
                gson.toJson(userDTO));
        return Mono.just(userDTO);
    }
}
