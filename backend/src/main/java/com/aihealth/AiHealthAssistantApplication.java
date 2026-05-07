package com.aihealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AiHealthAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiHealthAssistantApplication.class, args);
    }
}
