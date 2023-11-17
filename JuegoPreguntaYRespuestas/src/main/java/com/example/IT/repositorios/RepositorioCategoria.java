package com.example.IT.repositorios;

import com.example.IT.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {

    List<Categoria> findAll();

    Categoria findByNameCategory(String nombre);

    Optional<Categoria> findById(Long id);

    List<Categoria> findByNameCategoryContains(String nombre);
}
