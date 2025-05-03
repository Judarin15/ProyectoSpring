package com.javaspring.controladores;

import com.javaspring.modelos.Horario;
import com.javaspring.servicios.ServicioHorario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-horario")
@CrossOrigin(origins = "http://localhost:8080")
public class ControladorHorario {

    public static final Logger logger = LoggerFactory.getLogger(ControladorHorario.class);

    @Autowired
    private ServicioHorario servicioHorario;

    @GetMapping("/horario")
    public List<Horario> listarHorarios() {
        List<Horario> listaDeHorarios = this.servicioHorario.listaHorarios();
        logger.info("Lista de horarios obtenida");
        listaDeHorarios.forEach(horario -> logger.info(horario.toString()));
        return listaDeHorarios;
    }

    @PostMapping("/horario")
    public Horario guardarHorario(@RequestBody Horario horario) {
        logger.info("Horario agregado: " + horario);
        return this.servicioHorario.guardarHorario(horario);
    }
}
