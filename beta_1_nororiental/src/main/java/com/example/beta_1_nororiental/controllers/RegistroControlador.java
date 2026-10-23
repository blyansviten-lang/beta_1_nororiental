package com.example.beta_1_nororiental.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beta_1_nororiental.models.Registro;
import com.example.beta_1_nororiental.Service.ServicioRegistro;

@RestController
@RequestMapping("/api/registro")
public class RegistroControlador {

    @Autowired
    private ServicioRegistro servicioRegistro;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Registro datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioRegistro.guardarregistro(datos));
    }

    @GetMapping
    public ResponseEntity<?> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicioRegistro.buscar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable UUID id, @RequestBody Registro datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioRegistro.modificar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioRegistro.eliminar(id));
    }
}
