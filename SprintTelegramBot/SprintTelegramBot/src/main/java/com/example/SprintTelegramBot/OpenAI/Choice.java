package com.example.SprintTelegramBot.OpenAI;

import com.fasterxml.jackson.annotation.JsonProperty;
public record Choice (
        @JsonProperty("message")Message message){
}