package com.spring.practicasrping2_0.Controller;


import com.spring.practicasrping2_0.Entity.Cliente;
import com.spring.practicasrping2_0.Entity.Persona;
import com.spring.practicasrping2_0.Exception.ClienteNotFoundException;
import com.spring.practicasrping2_0.Form.ClienteForm;
import com.spring.practicasrping2_0.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clientes;

    @GetMapping
    public ResponseEntity all() {

        return ok(this.clientes.findAll());

    }

    @PostMapping("/new")
    public ResponseEntity save(@RequestBody ClienteForm form, HttpServletRequest request) {
        Cliente saved = new Cliente();
        return created( // CREA UN HATEOAS ==> UN HATEOAS ES UNA URL PARA REDIRIGIR EN SYMFONY ES ==> return redirect("url")
                ServletUriComponentsBuilder
                        .fromContextPath(request)
                        .path("/clientes/{id}")
                        .buildAndExpand(saved.getId())
                        .toUri())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ok(this.clientes.findById(id).orElseThrow(() -> new ClienteNotFoundException(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ClienteForm form) {
        Cliente existed = this.clientes.findById(id).orElseThrow(() -> new ClienteNotFoundException(id)); // busca un coche y si existe actualiza los datos si no lanza una excepción

       Persona per = existed.getDatosPersonales();

       per.setNombre(form.getNombre());
       per.setApellidos(form.getApellidos());
       per.setDireccion(form.getDireccion());
       per.setEdad(form.getEdad());
       per.setTelefono(form.getTelefono());
       per.setEmail(form.getEmail());

        this.clientes.save(existed);
        return noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Cliente existed = this.clientes.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
        this.clientes.delete(existed);
        return noContent().build();
    }


}
