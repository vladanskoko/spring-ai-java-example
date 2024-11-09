package com.spring_ai_java_example.service.impl;

import com.spring_ai_java_example.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public String getSongsByArtist(String artist) {
        String query = """
                Please give me a list of top 10 songs for the artist {artist}. If you don't know the answer, just say.
                """;
        PromptTemplate promptTemplate = new PromptTemplate(query, Map.of("artist", artist));
        Prompt prompt = promptTemplate.create();

        ChatResponse chatResponse = chatClient
                .prompt(prompt)
                .call()
                .chatResponse();

        return chatResponse
                .getResult()
                .getOutput()
                .getContent();
    }

}
