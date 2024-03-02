package com.AgenciaSpringBoot.Controlador;

import com.AgenciaSpringBoot.Modelo.Destino;
import com.AgenciaSpringBoot.services.DestinoServicio;
import com.AgenciaSpringBoot.services.PaqueteTuristaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ControladorDestino {

    @Autowired
    private DestinoServicio destinoServicio;

    @Autowired
    private PaqueteTuristaServicio paqueteTuristaServicio;

    @GetMapping("/getdestinos")
    public ResponseEntity getDestinos() {
        List<Destino> lstDestinos = destinoServicio.findAll();
        return ResponseEntity.ok(lstDestinos);
    }

    @GetMapping("/save-destino/{value}/{paqueteturistaid}")
    public ResponseEntity save(@PathVariable String value, @PathVariable Integer paqueteturistaid) {
        Destino destino = new Destino();
        destino.setValue(value);
        destino.setPaqueteTurista(paqueteTuristaServicio.findById(paqueteturistaid));
        destino = destinoServicio.save(destino);
        return ResponseEntity.ok(destino);
    }
}
