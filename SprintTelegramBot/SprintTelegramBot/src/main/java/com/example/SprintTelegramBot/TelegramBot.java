package com.example.SprintTelegramBot;

import com.example.SprintTelegramBot.OpenAI.OpenAIClient;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class TelegramBot extends TelegramLongPollingBot {
    public final OpenAIClient openAIClient;
    public TelegramBot(DefaultBotOptions options, String botToken, OpenAIClient openAIClient) {
        super(options, botToken);

        this.openAIClient = openAIClient;


    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){

        var text = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();

        var chatCompletionResponse = openAIClient.createChatCompletion(text);
        var textResponse = chatCompletionResponse.choices().get(0).message().content();

        SendMessage sendMessage = new SendMessage(chatId.toString(), textResponse);
        sendApiMethod(sendMessage);
        }

    }

    @Override
    public String getBotUsername() {
        return "My-test-bot";
    }
}
