package com.example.IT.seguridad;

import com.example.IT.modelos.Usuario;
import com.example.IT.repositorios.RepositorioUsuario;
import com.example.IT.repositorios.RepositorioUsurioSinJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class Security {

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @Autowired
    RepositorioUsurioSinJpa repositorioUsurioSinJpa;

    /*
    * Se deberia de encriptar la contraseña
    */
    /*@Bean
    public UserDetailsService userDetailsService () {
        UserDetailsManager userDetailsManager =
                new InMemoryUserDetailsManager() ;
        userDetailsManager.createUser(
                User. withDefaultPasswordEncoder()
                        .username( "user")
                        .password( "password")
                        .roles( "USER")
                        .build()) ;
        userDetailsManager.createUser(
                User. withDefaultPasswordEncoder()
                        .username( "admin")
                        .password( "password")
                        .roles( "ADMIN")
                        .build()) ;
        return userDetailsManager ;
    }*/

    @Bean
    CommandLineRunner guardarUsuarios(RepositorioUsuario repositorioUsuario) {
        return args -> {
            repositorioUsuario.save(new Usuario("user", "user@gmail.com", "ROLE_USER", "1234" ));
            repositorioUsuario.save(new Usuario("admin", "admin@gmail.com", "ROLE_ADMIN","1234" ));
            repositorioUsuario.save(new Usuario("moderador", "moderador@gmail.com", "ROLE_STAFF","1234" ));
        };
    }

    @Bean
    UserDetailsService userService (RepositorioUsurioSinJpa repositorioUsuario) {
        return username ->
                repositorioUsuario.findByUsername(username).asUser() ;
    }



}
