package com.example.requizit.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(int id) {
        super("Could not find question: " + id);
    }
}
