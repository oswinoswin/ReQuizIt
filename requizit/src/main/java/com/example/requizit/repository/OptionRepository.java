package com.example.requizit.repository;

import com.example.requizit.model.Question.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Integer> {
}
