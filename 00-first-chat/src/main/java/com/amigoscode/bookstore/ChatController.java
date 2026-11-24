package com.amigoscode.bookstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;


@RestController
@RequestMapping("/api")
public class ChatController {

	private static final Logger log = LoggerFactory.getLogger(ChatController.class);

	private final BookAssistant bookAssistant;

	private final JsonMapper jsonMapper;

	// 构造器注入 Spring Boot 自动配置的 JsonMapper BookAssistant
	public ChatController(BookAssistant bookAssistant, JsonMapper jsonMapper) {
		this.bookAssistant = bookAssistant;
		this.jsonMapper = jsonMapper;
	}

	// TODO task-5: expose GET /api/chat?question=... that returns BookAssistant.Answer as JSON
	@RequestMapping("/chat")
	public String chat(String question) throws JsonProcessingException {
		log.info(question);
		String s = jsonMapper.writeValueAsString(bookAssistant.askWithUsage(question));
		log.info(s);
		return s;
	}

}
