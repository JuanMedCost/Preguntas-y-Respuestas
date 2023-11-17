package com.example.IT.modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String correct_answer;
    private String incorrect_answer_a;
    private String incorrect_answer_b;
    private String incorrect_answer_c;
    //private int visualizaciones;

    @ManyToOne
    @JoinColumn(name="id_category", nullable = false, referencedColumnName = "id")
    private Categoria categoria;


}




