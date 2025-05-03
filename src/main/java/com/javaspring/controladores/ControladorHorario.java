package com.javaspring.controladores;

import com.javaspring.modelos.Horario;
import com.javaspring.servicios.IServicioHorario;
import com.javaspring.servicios.ServicioHorario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/horario/")
@CrossOrigin(origins = "http://localhost:8080")
public class ControladorHorario {

    public static final Logger logger = LoggerFactory.getLogger(ControladorHorario.class);

    @Autowired
    private IServicioHorario servicioHorario;

    @GetMapping
    public List<Horario> listarHorarios() {
        List<Horario> listaDeHorarios = this.servicioHorario.listaHorarios();
        logger.info("Lista de horarios obtenida");
        listaDeHorarios.forEach(horario -> logger.info(horario.toString()));
        return listaDeHorarios;
    }

    @PostMapping
    public Horario guardarHorario(@RequestBody Horario horario) {
        logger.info("Horario agregado: " + horario);
        return this.servicioHorario.guardarHorario(horario);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Horario> buscarHorarioPorId(@PathVariable Long id) {
        Horario horario = servicioHorario.buscarHorarioPorId(id);
        if (horario != null) {
            return ResponseEntity.ok(horario);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizar(@PathVariable Long id, @RequestBody Horario horario) {
        Horario horarioExistente = servicioHorario.buscarHorarioPorId(id);
        if (horarioExistente != null) {
            horario.setId(id); // aseguramos que se actualice el correcto
            return ResponseEntity.ok(servicioHorario.guardarHorario(horario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
