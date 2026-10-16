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

    // inyecta una dependencia hacia el repositorio
    @Autowired
    private IRepositorioPrioridad repositorioPrioridad;

    // operaciones que habilitamos ejecutamos nuestra tabla

    // guardar
    public Prioridad guardPrioridad(Prioridad datosPrioridad) {
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
            // hay a quien actualizar
            Prioridad prioridadEncontrada = prioridadBuscada.get();

            // Modificando los datos 
            prioridadEncontrada.setNombre(datosNuevos.getNombre());

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

