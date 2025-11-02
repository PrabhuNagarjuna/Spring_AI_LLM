package com.ollama.spring.ollama;

import org.springframework.ai.model.openai.autoconfigure.OpenAiChatAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {OpenAiChatAutoConfiguration.class})
public class Application {

	public static void main(String [] args) {

        SpringApplication.run(Application.class, args);
	}

}
// main runner class for ai