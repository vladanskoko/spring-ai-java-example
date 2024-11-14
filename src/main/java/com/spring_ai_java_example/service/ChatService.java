package com.spring_ai_java_example.service;

import org.springframework.ai.chat.model.ChatResponse;

public interface ChatService {
    String generateResponse(String query);
    ChatResponse generateJsonResponse(String query);
    String getSongsByArtist(String artist);
}
