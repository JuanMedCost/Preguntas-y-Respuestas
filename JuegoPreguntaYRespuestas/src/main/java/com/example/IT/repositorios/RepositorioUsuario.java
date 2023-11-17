package com.example.IT.repositorios;

import com.example.IT.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

    Usuario save(Usuario articulo);

    Usuario findById(long id);

    Usuario findByUsername(String nombre);



}
