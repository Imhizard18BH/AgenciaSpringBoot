package com.AgenciaSpringBoot.services;

import com.AgenciaSpringBoot.Modelo.Data.TuristaData;
import com.AgenciaSpringBoot.Modelo.Turista;

import java.util.List;

public interface PersonaServicio {

    public List<Turista> findAll();
    public Turista save(Turista turista);
    public Turista findById(Integer id);
    public void delete(Integer id);
    public Turista factory(TuristaData turistaData);
}
