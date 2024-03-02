package com.AgenciaSpringBoot.Controlador;

import com.AgenciaSpringBoot.Modelo.Data.TuristaData;
import com.AgenciaSpringBoot.Modelo.Turista;
import com.AgenciaSpringBoot.Modelo.Reserva;
import com.AgenciaSpringBoot.services.PersonaServicio;
import com.AgenciaSpringBoot.services.ReservaServicio;
import com.AgenciaSpringBoot.services.PaqueteTuristaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ControadorTurista {

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private PaqueteTuristaServicio paqueteTuristaServicio;

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/get-turistas")
    public ResponseEntity getTuristas() {
        List<Turista> lstTuristas = personaServicio.findAll();
        return ResponseEntity.ok(lstTuristas);
    }

    @GetMapping("/get-turista-by-id/{idTurista}")
    public ResponseEntity getTurista(@PathVariable Integer idTurista) {
        Turista turista = personaServicio.findById(idTurista);
        return ResponseEntity.ok(turista);
    }

    @PostMapping("/save-person")
    public ResponseEntity save(@ModelAttribute TuristaData turistaData) {
        System.err.println("No se pudo guardar");
        personaServicio.factory(turistaData);
        return ResponseEntity.ok("Guardado Exitosamente");
    }

    @GetMapping("/edit-turista/{idturista}/{idpaqueteturista}/{fecha}/{cantidad}")
    public ResponseEntity editPerson(@PathVariable Integer idturista, @PathVariable Integer idpaqueteturista,
                                             @PathVariable String fecha, @PathVariable Integer cantidad) {
        try {
            Reserva reserv = reservaServicio.factory(idturista, idpaqueteturista, fecha, cantidad);
            return ResponseEntity.ok(reserv);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
