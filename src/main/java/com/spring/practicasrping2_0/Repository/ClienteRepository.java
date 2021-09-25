package com.spring.practicasrping2_0.Repository;

import com.spring.practicasrping2_0.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "clients", collectionResourceRel = "clients", itemResourceRel = "client")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
