package com.imransoft.content_calendar.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imransoft.content_calendar.model.Content;
import com.imransoft.content_calendar.model.Status;
import com.imransoft.content_calendar.model.Type;
import com.imransoft.content_calendar.repository.ContentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper mapper;

    public DataLoader(ContentRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");

        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
            repository.saveAll(mapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }

    }
}
