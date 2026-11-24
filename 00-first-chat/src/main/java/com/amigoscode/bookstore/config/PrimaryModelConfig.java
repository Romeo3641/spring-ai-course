package com.amigoscode.bookstore.config;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryModelConfig {

    @Bean
    @Primary
    public ChatModel primaryChatModel(ChatModel openAiChatModel) {
        return openAiChatModel;
    }
}