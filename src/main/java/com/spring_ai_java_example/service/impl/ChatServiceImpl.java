package com.spring_ai_java_example.service.impl;

import com.spring_ai_java_example.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @Override
    public String generateResponse(String query) {

        return chatClient.prompt()
                .user(query)
                .call()
                .content();
    }

    @Override
    public ChatResponse generateJsonResponse(String query) {
        return chatClient.prompt()
                .user(query)
                .call()
                .chatResponse();
    }

}
