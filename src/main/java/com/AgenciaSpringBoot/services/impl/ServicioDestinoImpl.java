package com.AgenciaSpringBoot.services.impl;

import com.AgenciaSpringBoot.Modelo.Destino;
import com.AgenciaSpringBoot.repositories.DestinoRepo;
import com.AgenciaSpringBoot.services.DestinoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServicioDestinoImpl implements DestinoServicio {

    @Autowired
    private DestinoRepo destinoRepo;
    @Override
    public List<Destino> findAll() {
        return destinoRepo.findAll();
    }

    @Override
    public Destino save(Destino destino) {
        return destinoRepo.save(destino);
    }

    @Override
    public Destino findById(Integer id) {
        return destinoRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        destinoRepo.deleteById(id);
    }
}
