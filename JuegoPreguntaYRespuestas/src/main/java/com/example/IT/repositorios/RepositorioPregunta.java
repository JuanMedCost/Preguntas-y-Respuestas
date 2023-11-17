package com.example.IT.repositorios;

import com.example.IT.modelos.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPregunta  extends JpaRepository<Pregunta, Long> {

    List<Pregunta> findAll();

    Pregunta findByQuestion(String question);

    List<Pregunta> findByQuestionContains(String question);




}
