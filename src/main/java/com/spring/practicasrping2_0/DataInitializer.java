package com.spring.practicasrping2_0;

import com.spring.practicasrping2_0.Entity.Cliente;
import com.spring.practicasrping2_0.Entity.User;
import com.spring.practicasrping2_0.Repository.ClienteRepository;
import com.spring.practicasrping2_0.Repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

      /*  User us = new User("Marciano","González García","900600900","AV Andrés Segovia 14 3º D","pollo@hotmail.com",new Date());
        us.setPassword(this.passwordEncoder.encode("password"));
        us.setUsername("user");
        us.setRoles(Arrays.asList("ROLE_USER"));

        users.save(us);

        User us2 = new User("Clint","Eastwood","900600900","Sunnyvale CA","pollo@hotmail.com",new Date());

        us2.setUsername("admin");
        us2.setPassword(this.passwordEncoder.encode("password"));
        us2.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

        users.save(us2);

        log.debug("printing all users...");
        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));*/
    }
}
