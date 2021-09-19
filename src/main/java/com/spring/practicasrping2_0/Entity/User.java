package com.spring.practicasrping2_0.Entity;

import lombok.Builder;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Embedded
    private Persona datosPersonales;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public User() {

    }

    public User(String nombre, String apellidos, String telefono, String direccion, String email, Date edad) {

        this.datosPersonales = new Persona(nombre,apellidos,telefono,direccion,email,edad);

    }

    public User(String username, String password, String nombre, String apellidos, String telefono, String direccion, String email, Date edad) {

        this.username = username;
        this.password = password;
        this.datosPersonales = new Persona(nombre,apellidos,telefono,direccion,email,edad);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public List<String> getRoles() {

        return roles;

    }

    public void setRoles(List<String> roles) {

        this.roles = roles;

    }

    public void setPassword(String password) {

        this.password = password;

    }
}
