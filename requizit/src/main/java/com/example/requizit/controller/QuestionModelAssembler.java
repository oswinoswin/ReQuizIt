package com.example.requizit.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.requizit.model.Question.Question;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class QuestionModelAssembler implements RepresentationModelAssembler<Question, EntityModel<Question>> {

    @Override
    public EntityModel<Question> toModel(Question question) {
        return EntityModel.of(question,
                linkTo(methodOn(QuestionController.class).one(question.getId())).withSelfRel(),
                linkTo(methodOn(QuestionController.class).all()).withRel("questions"));
    }
}
