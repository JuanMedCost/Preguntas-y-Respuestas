package com.example.IT.modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "nombre", nullable = false)
    private String nameCategory;

    @OneToMany(targetEntity = Pregunta.class, mappedBy = "categoria")
    private List<Pregunta> preguntas;

}