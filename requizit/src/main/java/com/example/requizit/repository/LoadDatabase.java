package com.example.requizit.repository;

import com.example.requizit.model.Question.Option;
import com.example.requizit.model.Question.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(QuestionRepository questionRepository){
        return args -> {
            log.info("Saving: "+ questionRepository.save(new  Question("Can I add a question? ", List.of(new Option("YES", true), new Option("NO", false)))));
            log.info("Saving: "+ questionRepository.save(new  Question("Can I add a second question? ", List.of(new Option("YES", true), new Option("NO", false)))));
        };
    }
}
