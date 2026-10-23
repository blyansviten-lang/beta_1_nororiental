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

import com.example.beta_1_nororiental.models.Prioridad;
import com.example.beta_1_nororiental.Service.ServicioPrioridad;

@RestController
@RequestMapping("/api/prioridad")
public class PrioridadControlador {

    @Autowired
    private ServicioPrioridad servicioPrioridad;

    // controlador para guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Prioridad datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioPrioridad.guardar(datos));
    }

    // controlador para buscar
    @GetMapping
    public ResponseEntity<?> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicioPrioridad.buscar());
    }

    // controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable UUID id, @RequestBody Prioridad datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioPrioridad.modificar(id, datos));
    }

    // controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioPrioridad.eliminar(id));
    }
}