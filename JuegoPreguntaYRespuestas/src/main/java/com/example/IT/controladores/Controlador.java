package com.example.IT.controladores;


import com.example.IT.modelos.Usuario;
import com.example.IT.servicios.ServicioPregunta;
import com.example.IT.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class Controlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    ServicioPregunta servicioPregunta;

    @GetMapping("/")
    public String principal(Model model, Authentication authentication){
        //model.addAttribute("lista", usuarioServicio.findAll());
        model.addAttribute("authentication", authentication);
        return "index";
    }

    @GetMapping("/juego1")
    public String juego1(Model model, Authentication authentication){
        long nPreguntas = servicioPregunta.findAll().size();
        Random ran = new Random();
        long numeroPregunta = ran.nextLong(nPreguntas + 1);
        model.addAttribute("pregunta", servicioPregunta.findById(numeroPregunta));
        //model.addAttribute("lista", usuarioServicio.findAll());
        model.addAttribute("authentication", authentication);
        model.addAttribute("mensaje","");
        return "juego1";
    }

    @GetMapping("/juego1/revisar/{id}/{respuesta}")
    public String revisarJuego1(@PathVariable long id, @PathVariable String respuesta, Model model, Authentication authentication){
        Usuario usuario = usuarioServicio.findByUsername(authentication.getName());
        if(servicioPregunta.findById(id).getCorrect_answer().equals(respuesta)){
            model.addAttribute("mensaje", "Has acertado :)");
            usuario.setAciertos(usuario.getAciertos() + 1);
        }else{
            model.addAttribute("mensaje", "Has fallado :(");
            usuario.setFallos(usuario.getFallos() + 1);
        }
        model.addAttribute("aciertos", usuario.getAciertos());
        model.addAttribute("fallos", usuario.getFallos());
        usuarioServicio.save(usuario);
        return "juego1";
    }

    @GetMapping("/juego2")
    public String juego2(Model model, Authentication authentication){
        //model.addAttribute("lista", usuarioServicio.findAll());
        model.addAttribute("authentication", authentication);
        return "juego2";
    }

    @GetMapping("/juego3")
    public String juego3(Model model, Authentication authentication){
        int contador = 1;
        model.addAttribute("contador", contador);
            long nPreguntas = servicioPregunta.findAll().size();
            Random ran = new Random();
            long numeroPregunta = ran.nextLong(nPreguntas + 1);
            model.addAttribute("pregunta", servicioPregunta.findById(numeroPregunta));
            //model.addAttribute("lista", usuarioServicio.findAll());
            model.addAttribute("authentication", authentication);
            model.addAttribute("mensaje","");


        return "juego3";
    }

    @GetMapping("/juego3/revisar/{id}/{respuesta}/{contador}")
    public String revisarJuego3(@PathVariable long id, @PathVariable String respuesta,@PathVariable int contador ,Model model, Authentication authentication){
        Usuario usuario = usuarioServicio.findByUsername(authentication.getName());
        if(servicioPregunta.findById(id).getCorrect_answer().equals(respuesta)){
            model.addAttribute("mensaje", "Has acertado :)");
            usuario.setAciertos(usuario.getAciertos() + 1);
        }else{
            model.addAttribute("mensaje", "Has fallado :(");
            usuario.setFallos(usuario.getFallos() + 1);
        }
        model.addAttribute("aciertos", usuario.getAciertos());
        model.addAttribute("fallos", usuario.getFallos());
        usuarioServicio.save(usuario);
        contador++;
        model.addAttribute("contador", contador);
        if ( contador <= 30){
            return "juego3";
        }else{
            return "resultadoExamen";
        }

    }

    /*@GetMapping("/crud/preguntas")
    public String listarPregunta(Model model, Authentication authentication){
        model.addAttribute("listaPregunta", servicioPregunta.findAll());
        return "listaPreguntas";
    }*/

}
