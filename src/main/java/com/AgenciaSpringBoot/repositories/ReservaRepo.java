package com.AgenciaSpringBoot.repositories;

import com.AgenciaSpringBoot.Modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Integer> {
}
