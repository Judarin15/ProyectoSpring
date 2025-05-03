package com.javaspring.servicios;

import com.javaspring.modelos.Horario;

import java.util.List;

public interface IServicioHorario {


    List<Horario> listaHorarios();  // Listar todos los horarios

    Horario buscarHorarioPorId(Long id);  // Buscar horario por ID

    Horario guardarHorario(Horario horario);  // Guardar un horario

    void eliminarHorario(Long id);  // Eliminar un horario por ID

    // Si deseas agregar consultas adicionales, como buscar por fecha
    List<Horario> buscarPorFechaInicio(String fechaInicio);
}
