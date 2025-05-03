package com.javaspring.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cooordinador {
    @Id
    @Column(name = "pk_id_coordinador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "apellido",length = 50)
    private String apellido;
    @Column(name = "correo",length = 100, unique = true)
    private String correo;
    @Column(name = "telefono", unique = true)
    private Long telefono;
    @OneToMany(mappedBy = "cooordinador")
    private List<Horario> horarios;
}
