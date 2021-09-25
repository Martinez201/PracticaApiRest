package com.spring.practicasrping2_0.Repository;

import com.spring.practicasrping2_0.Entity.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cuenta", collectionResourceRel = "cuenta", itemResourceRel = "cuenta")
public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {

}
