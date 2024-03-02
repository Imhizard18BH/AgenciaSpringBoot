package com.AgenciaSpringBoot.repositories;

import com.AgenciaSpringBoot.Modelo.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristaRepo extends JpaRepository<Turista, Integer> {
}
