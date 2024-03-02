package com.AgenciaSpringBoot.repositories;

import com.AgenciaSpringBoot.Modelo.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepo extends JpaRepository<Destino, Integer> {
}
