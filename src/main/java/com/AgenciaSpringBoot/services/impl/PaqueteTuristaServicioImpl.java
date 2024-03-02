package com.AgenciaSpringBoot.services.impl;

import com.AgenciaSpringBoot.repositories.PaqueteTuristaRepo;
import com.AgenciaSpringBoot.Modelo.Data.PaqueteTuristaData;
import com.AgenciaSpringBoot.Modelo.PaqueteTurista;
import com.AgenciaSpringBoot.services.PaqueteTuristaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PaqueteTuristaServicioImpl implements PaqueteTuristaServicio {

    @Autowired
    private PaqueteTuristaRepo paqueteTuristaRepo;
    @Override
    public List<PaqueteTurista> findAll() {
        return paqueteTuristaRepo.findAll();
    }

    @Override
    public PaqueteTurista save(PaqueteTurista paqueteTurista) {
        return paqueteTuristaRepo.save(paqueteTurista);
    }

    @Override
    public PaqueteTurista findById(Integer id) {
        return paqueteTuristaRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        paqueteTuristaRepo.deleteById(id);
    }

    @Override
    public PaqueteTurista factory(PaqueteTuristaData paqueteTuristaData) throws ParseException {
        PaqueteTurista paqueteTurista = new PaqueteTurista();
        paqueteTurista.setPrecio(paqueteTuristaData.getPrecio());
        paqueteTurista.setNombre(paqueteTuristaData.getNombre());
        paqueteTurista.setTiempo(paqueteTuristaData.getTiempo());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        paqueteTurista.setFecha(dateFormat.parse(paqueteTuristaData.getFecha()));
        return save(paqueteTurista);
    }
}
