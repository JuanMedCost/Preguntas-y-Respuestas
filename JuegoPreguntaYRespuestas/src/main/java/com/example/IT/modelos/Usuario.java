package com.example.IT.modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ElementCollection(fetch = FetchType.EAGER) //Anotación especial para que JPA/Hibernate creen una tabla para los posibles valores
    private List<GrantedAuthority> authorities = new ArrayList<>();


    @Column(nullable=false, unique = false)
    private String username;

    @Column(nullable=false, unique = false)
    private String password;

    @Column(nullable=false, unique = true)
    private String email;

    @Column(nullable=false, unique = false)
    private String rol;

    private int aciertos;

    private  int fallos;

    @OneToMany
    private List<Calificacion> calificaciones;

    public Usuario(String nombre, String email,String rol, String password) {
        this.username = nombre;
        this.email = email;
        this.rol = rol;
        this.password = password;
        this.aciertos = 0;
        this.fallos = 0;
    }



    public Usuario() {
        this.aciertos = 0;
        this.fallos = 0;
    }

    public UserDetails asUser() {
        return User.withDefaultPasswordEncoder() //
                .username(getEmail()) //
                .password(getPassword()) //
                .authorities(getRol()) //
                .build();
    }




}
