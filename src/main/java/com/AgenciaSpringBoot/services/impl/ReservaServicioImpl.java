package com.AgenciaSpringBoot.services.impl;

import com.AgenciaSpringBoot.repositories.ReservaRepo;
import com.AgenciaSpringBoot.Modelo.Turista;
import com.AgenciaSpringBoot.Modelo.Reserva;
import com.AgenciaSpringBoot.Modelo.PaqueteTurista;
import com.AgenciaSpringBoot.services.PersonaServicio;
import com.AgenciaSpringBoot.services.ReservaServicio;
import com.AgenciaSpringBoot.services.PaqueteTuristaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ReservaServicioImpl implements ReservaServicio {

    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private PaqueteTuristaServicio paqueteTuristaServicio;

    @Override
    public List<Reserva> findAll() {
        return reservaRepo.findAll();
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    @Override
    public Reserva findById(Integer id) {
        return reservaRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        reservaRepo.deleteById(id);
    }

    @Override
    public Reserva factory(Integer idTurista, Integer idPaqueteTurista, String fecha, Integer cantidad) throws ParseException {
        Turista turistaFound = personaServicio.findById(idTurista);
        PaqueteTurista paqueteTurista = paqueteTuristaServicio.findById(idPaqueteTurista);
        Reserva reserva = new Reserva();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        reserva.setFechaReserva(dateFormat.parse(fecha));
        reserva.setCantidad(cantidad);
        reserva.setTurista(turistaFound);
        reserva.setPaqueteTurista(paqueteTurista);
        return save(reserva);
    }
}
