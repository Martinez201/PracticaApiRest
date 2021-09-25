package com.spring.practicasrping2_0;

import com.spring.practicasrping2_0.Entity.Cliente;
import com.spring.practicasrping2_0.Entity.User;
import com.spring.practicasrping2_0.Repository.ClienteRepository;
import com.spring.practicasrping2_0.Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    ClienteRepository clientes;

    @Autowired
    UsuarioRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente("Antonio","González García","900600900","AV Andrés Segovia 14 3º D","pollo@hotmail.com",new Date());
        Cliente cliente2 = new Cliente("Rafael","González García","900600900","AV Andrés Segovia 14 3º D","pollo@hotmail.com",new Date());
        Cliente cliente3 = new Cliente("José","Martínez Molina","900600900","AV Andalucia 52 6º D","pollo@hotmail.com",new Date());

        clientes.save(cliente1);
        clientes.save(cliente2);
        clientes.save(cliente3);

        log.debug("printing all Clients...");
        this.clientes.findAll().forEach(v -> log.debug(" Cliente :" + v.toString()));

        this.users.save(User.builder()
                .username("user")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList( "ROLE_USER"))
                .build()
        );

        this.users.save(User.builder()
                .username("admin")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );

        log.debug("printing all users...");
        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));

    }

}
