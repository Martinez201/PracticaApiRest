package com.spring.practicasrping2_0.Repository;


import com.spring.practicasrping2_0.Entity.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "operacion", collectionResourceRel = "operacion", itemResourceRel = "operacion")
public interface OperacionRepository extends JpaRepository<Operacion, Long> {

}
