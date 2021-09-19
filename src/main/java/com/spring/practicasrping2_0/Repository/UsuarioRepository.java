package com.spring.practicasrping2_0.Repository;


import com.spring.practicasrping2_0.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}

