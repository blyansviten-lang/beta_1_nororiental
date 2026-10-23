package com.example.beta_1_nororiental.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.beta_1_nororiental.Repository.IRepositorioPrioridad;
import com.example.beta_1_nororiental.models.Prioridad;

@Service
public class ServicioPrioridad {

    @Autowired
    private IRepositorioPrioridad repositorioPrioridad;

    // guardar
    public Prioridad guardar(Prioridad datosPrioridad) {
        return this.repositorioPrioridad.save(datosPrioridad);
    }

    // buscar
    public List<Prioridad> buscar() {
        return this.repositorioPrioridad.findAll();
    }

    // actualizar
    public Prioridad modificar(UUID id, Prioridad datosNuevos) {
        Optional<Prioridad> prioridadBuscada = this.repositorioPrioridad.findById(id);
        if (prioridadBuscada.isPresent()) {
            Prioridad prioridadEncontrada = prioridadBuscada.get();
            
            // Modificando los datos usando los nombres correctos en español
            prioridadEncontrada.setNombre(datosNuevos.getNombre());
            prioridadEncontrada.setNivel(datosNuevos.getNivel());

            // guardo los cambios y retorno el objeto actualizado
            return this.repositorioPrioridad.save(prioridadEncontrada);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prioridad no encontrada");
        }
    }

    // eliminar
    public boolean eliminar(UUID id) {
        Optional<Prioridad> prioridadBuscada = this.repositorioPrioridad.findById(id);
        if (prioridadBuscada.isPresent()) {
            this.repositorioPrioridad.deleteById(id);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Prioridad no encontrada");
        }
    }
}