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

import com.example.beta_1_nororiental.models.Empresa;
import com.example.beta_1_nororiental.Service.ServicioEmpresa;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaControlador {

    @Autowired
    private ServicioEmpresa servicioEmpresa;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Empresa datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioEmpresa.guardarEmpresa(datos));
    }

    @GetMapping
    public ResponseEntity<?> buscar() {
        return ResponseEntity.status(HttpStatus.OK).body(servicioEmpresa.buscar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable UUID id, @RequestBody Empresa datos) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioEmpresa.modificar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioEmpresa.eliminar(id));
    }
}
