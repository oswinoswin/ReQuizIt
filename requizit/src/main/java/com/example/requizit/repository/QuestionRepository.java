package com.example.requizit.repository;

import com.example.requizit.model.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
