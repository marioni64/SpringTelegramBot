package com.example.SprintTelegramBot;

import com.example.SprintTelegramBot.OpenAI.OpenAIClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TGconfig {

    @SneakyThrows
    @Bean
    public TelegramBot telegramBot(@Value("${bot.token}") String botToken, TelegramBotsApi telegramBotsApi, OpenAIClient openAIClient){

        var botOptions = new DefaultBotOptions();
        var bot = new TelegramBot(botOptions, botToken, openAIClient);

        telegramBotsApi.registerBot(bot);
        return bot;
    }


    @SneakyThrows
    @Bean
    public TelegramBotsApi telegramBotsApi() throws TelegramApiException {
        return new TelegramBotsApi(DefaultBotSession.class);
    }
}
