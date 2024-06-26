package com.example.SprintTelegramBot.OpenAI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAIcofigretion {

    @Bean
    public OpenAIClient openAIClient(
            @Value("${openAI.token}") String botToken,
            RestTemplateBuilder restTemplateBuilder){

        return new OpenAIClient(botToken, restTemplateBuilder.build());

    }

}