package com.AgenciaSpringBoot.services;

import com.AgenciaSpringBoot.Modelo.Destino;

import java.util.List;

public interface DestinoServicio {
    public List<Destino> findAll();
    public Destino save(Destino destino);
    public Destino findById(Integer id);
    public void delete(Integer id);
}
