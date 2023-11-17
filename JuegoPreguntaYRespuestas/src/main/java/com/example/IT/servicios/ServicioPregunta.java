package com.example.IT.servicios;

import com.example.IT.modelos.Pregunta;
import com.example.IT.repositorios.RepositorioPregunta;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPregunta {

    @Autowired
    RepositorioPregunta repositorioPregunta;

    public Pregunta save(Pregunta a) {
        repositorioPregunta.save(a);
        return a;
    }

    public List<Pregunta> findAll() {
        return (List<Pregunta>) repositorioPregunta.findAll();
    }

    public Pregunta findById(long id) {

        return repositorioPregunta.findById(id).get();
    }


    public Pregunta edit(Pregunta a) {
        repositorioPregunta.save(a);
        return a;
    }

    /**
     * @PreAuthorize("#entity.username == authentication.name") Se debería usar pero no lo uso por que en la pagina que se eliminara solo tendra acceso
     *     //el administrador que soy yo
     */
    public void deleteArticulo(long id) {

        repositorioPregunta.deleteById(id);
    }

}
