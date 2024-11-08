package com.spring_ai_java_example.controller;

import com.spring_ai_java_example.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/generate")
    public String generateResponse(@RequestParam(defaultValue = "write greetings message") String query) {
        return chatService.generateResponse(query);
    }

    @GetMapping("/generate-json")
    public ChatResponse generateResponseJson(@RequestParam(defaultValue = "write greetings message") String query) {
        return chatService.generateJsonResponse(query);
    }

}
