package com.example.IT.servicios;

import com.example.IT.modelos.Categoria;
import com.example.IT.modelos.Pregunta;
import com.example.IT.repositorios.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCategoria {

    @Autowired
    RepositorioCategoria repositorioCategoria;

    public Categoria findById(long id) {

        return repositorioCategoria.findById(id).get();
    }

    public Categoria findByNameCategory(String nombre) {

        return repositorioCategoria.findByNameCategory(nombre);
    }

    public Categoria save(Categoria a) {
        repositorioCategoria.save(a);
        return a;
    }


}
