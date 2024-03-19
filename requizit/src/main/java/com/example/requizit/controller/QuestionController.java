package com.example.requizit.controller;

import com.example.requizit.exception.QuestionNotFoundException;
import com.example.requizit.model.Question.Question;
import com.example.requizit.repository.QuestionRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class QuestionController {
    private final QuestionRepository repository;
    private final QuestionModelAssembler assembler;

    public QuestionController(QuestionRepository repository, QuestionModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/questions")
    CollectionModel<EntityModel<Question>> all(){
        List<EntityModel<Question>> questions = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(questions, linkTo(methodOn(QuestionController.class).all()).withSelfRel());
    }

    @GetMapping("/questions/{id}")
    EntityModel<Question> one(@PathVariable int id) {

        Question question = repository.findById(id).orElseThrow(() -> new QuestionNotFoundException(id));

        return assembler.toModel(question);
    }

    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question question) {
        return repository.save(question);
    }

    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable int id) {

        return repository.findById(id)
                .map(question -> {
                    question.setText(newQuestion.getText());
                    question.setOptions(newQuestion.getOptions());
                    return repository.save(question);
                })
                .orElseGet(() -> {
                    newQuestion.setId(id);
                    return repository.save(newQuestion);
                });
    }

    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable int id) {
        repository.deleteById(id);
    }
}
