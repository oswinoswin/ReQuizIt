package com.example.requizit.model;

import com.example.requizit.model.Question.Question;

public class Answer {
    int id;
    Question question;

    AnswerStatus status;
    public Answer(Question question) {
        this.question = question;
        this.status = AnswerStatus.NOT_ANSWERED;
    }

    public boolean check(){
        return false; // TODO - check if answer was correct
    }
}
