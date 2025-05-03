package com.javaspring.modelos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_horario")
    private Long id;

    @Column(name = "hora_inicio")
    private LocalDateTime hora_inicio;

    @Column(name = "hora_fin")
    private LocalDateTime hora_fin;

    @Column(name = "fecha_inicio")
    private LocalDateTime fecha_inicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fecha_fin;

    @ManyToOne
    @JoinColumn(name = "fk_id_cooordinador")
    private Cooordinador cooordinador;
}