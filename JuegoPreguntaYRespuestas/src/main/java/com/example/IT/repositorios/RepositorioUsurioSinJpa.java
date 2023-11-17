package com.example.IT.repositorios;

import com.example.IT.modelos.Usuario;
import org.springframework.data.repository.Repository;

public interface RepositorioUsurioSinJpa extends Repository<Usuario, Long> {

    Usuario findByUsername (String username) ;
}
