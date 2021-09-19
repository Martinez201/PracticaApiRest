package com.spring.practicasrping2_0.Repository;

import com.spring.practicasrping2_0.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
