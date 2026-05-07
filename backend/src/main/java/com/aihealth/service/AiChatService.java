package com.aihealth.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class AiChatService {

    @Value("${app.openai.api-key}")
    private String apiKey;

    @Value("${app.openai.model}")
    private String model;

    private ChatLanguageModel chatModel;

    @PostConstruct
    public void init() {
        this.chatModel = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(model)
                .temperature(0.3)
                .build();
    }

    public String chat(String userMessage, String context) {
        String prompt = String.format(
            "You are an AI health assistant. Use the following patient context to answer:\n%s\n\nUser Question: %s",
            context, userMessage
        );
        return chatModel.generate(prompt);
    }

    public String analyzeSymptoms(String symptoms) {
        String prompt = String.format(
            "Based on these symptoms: %s, provide possible conditions and suggest if medical attention is needed. Disclaimer: This is not a diagnosis.",
            symptoms
        );
        return chatModel.generate(prompt);
    }
}
