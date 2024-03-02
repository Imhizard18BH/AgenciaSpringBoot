package com.AgenciaSpringBoot.services;

import com.AgenciaSpringBoot.Modelo.Data.PaqueteTuristaData;
import com.AgenciaSpringBoot.Modelo.PaqueteTurista;

import java.text.ParseException;
import java.util.List;

public interface PaqueteTuristaServicio {
    public List<PaqueteTurista> findAll();
    public PaqueteTurista save(PaqueteTurista paqueteTurista);
    public PaqueteTurista findById(Integer id);
    public void delete(Integer id);

    public PaqueteTurista factory(PaqueteTuristaData paqueteTuristaData) throws ParseException;
}
