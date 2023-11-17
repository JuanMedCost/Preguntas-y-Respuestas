package com.example.IT.servicios;

import com.example.IT.modelos.Usuario;
import com.example.IT.repositorios.RepositorioUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class UsuarioServicio {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    public void save(Usuario usuario){

        repositorioUsuario.save(usuario);
    }

    /**
     * @PreAuthorize("#entity.username == authentication.name") Se debería usar pero no lo uso por que en la pagina que se eliminara solo tendra acceso
     *     //el administrador que soy yo
     */
    public void delete(Usuario entity){

        repositorioUsuario.delete(entity);
    }

    public Usuario findByUsername(String nombre){

        return repositorioUsuario.findByUsername(nombre);
    }

    public List<Usuario> findAll(){

        return repositorioUsuario.findAll();
    }
}
