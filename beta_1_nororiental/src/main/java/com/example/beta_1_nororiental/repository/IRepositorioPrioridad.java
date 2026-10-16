package com.example.beta_1_nororiental.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beta_1_nororiental.models.Prioridad;

public interface IRepositorioPrioridad extends JpaRepository<Prioridad, UUID> {

}
