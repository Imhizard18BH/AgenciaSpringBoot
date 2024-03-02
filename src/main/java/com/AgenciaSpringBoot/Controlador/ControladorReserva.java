package com.AgenciaSpringBoot.Controlador;

import com.AgenciaSpringBoot.Modelo.Reserva;
import com.AgenciaSpringBoot.services.ReservaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ControladorReserva {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/get-reservas")
    public ResponseEntity getReservas() {
        List<Reserva> lstReservas = reservaServicio.findAll();
        return ResponseEntity.ok(lstReservas);
    }

}
