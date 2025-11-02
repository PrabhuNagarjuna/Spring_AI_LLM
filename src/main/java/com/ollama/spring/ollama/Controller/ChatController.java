package com.ollama.spring.ollama.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;

@RestController
@RequestMapping
public class ChatController {

    private static final Logger log = LogManager.getLogger(ChatController.class);
    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder){

        this.chatClient=builder.build();
    }

    @GetMapping("/chat")
    public org.springframework.http.ResponseEntity<String> chat(@RequestParam(value = "q") String query
    ) {
        String responseContent= this.chatClient.prompt(query).call().content();
        return org.springframework.http.ResponseEntity.ok(responseContent);
    }
}
