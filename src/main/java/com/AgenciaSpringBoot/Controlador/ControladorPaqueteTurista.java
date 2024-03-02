package com.AgenciaSpringBoot.Controlador;

import com.AgenciaSpringBoot.Modelo.Data.PaqueteTuristaData;
import com.AgenciaSpringBoot.Modelo.PaqueteTurista;
import com.AgenciaSpringBoot.services.PaqueteTuristaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ControladorPaqueteTurista {

    @Autowired
    private PaqueteTuristaServicio paqueteTuristaServicio;

    @GetMapping("/get-turista-packages")
    public ResponseEntity getPaqueteTurista() {
        List<PaqueteTurista> lstPaqueteTuristas = paqueteTuristaServicio.findAll();
        return ResponseEntity.ok(lstPaqueteTuristas);
    }

    @PostMapping("/save-paquete-turista")
    public ResponseEntity save(@ModelAttribute PaqueteTuristaData paqueteTuristaData) {
        try {
            paqueteTuristaServicio.factory(paqueteTuristaData);
            return ResponseEntity.ok("Guardado Exitosamente");
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return  null;
    }
}
