package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;
    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    Curso curso;

    public Inscripcion() {
    }

    public Inscripcion(Integer idInscripcion, LocalDate fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
