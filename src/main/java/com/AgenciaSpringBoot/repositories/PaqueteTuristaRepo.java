package com.AgenciaSpringBoot.repositories;

import com.AgenciaSpringBoot.Modelo.PaqueteTurista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteTuristaRepo extends JpaRepository<PaqueteTurista, Integer> {
}
