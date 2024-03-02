package com.AgenciaSpringBoot.services.impl;

import com.AgenciaSpringBoot.Modelo.Turista;
import com.AgenciaSpringBoot.repositories.TuristaRepo;
import com.AgenciaSpringBoot.Modelo.Data.TuristaData;
import com.AgenciaSpringBoot.services.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuristaServicioImpl implements PersonaServicio {

    @Autowired
    private TuristaRepo turistaRepo;
    @Override
    public List<Turista> findAll() {
        return turistaRepo.findAll();
    }

    @Override
    public Turista save(Turista turista) {
        return turistaRepo.save(turista);
    }

    @Override
    public Turista findById(Integer id) {
        return turistaRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        turistaRepo.deleteById(id);
    }

    @Override
    public Turista factory(TuristaData turistaData) {
        Turista turista = new Turista();
        System.err.println(turistaData);
        turista.setDocumento(turistaData.getDocumento());
        turista.setDireccion(turista.getDireccion());
        turista.setEmail(turistaData.getEmail());
        turista.setNombre(turistaData.getNombre());
        turista.setTelefono(turistaData.getTelefono());
        return save(turista);
    }
}
