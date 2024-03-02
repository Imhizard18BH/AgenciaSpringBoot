package com.AgenciaSpringBoot.services;

import com.AgenciaSpringBoot.Modelo.Reserva;

import java.text.ParseException;
import java.util.List;

public interface ReservaServicio {
    public List<Reserva> findAll();
    public Reserva save(Reserva reserva);
    public Reserva findById(Integer id);
    public void delete(Integer id);

    public Reserva factory(Integer idTurista, Integer idTuristaPaquete, String fecha, Integer cantidad) throws ParseException;
}
