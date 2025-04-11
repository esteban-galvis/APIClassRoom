package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Integer idCalificacion;
    @Column(nullable = false)
    private Double nota;
    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id_estudiante")
    @JsonBackReference
    Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id_materia")
    @JsonBackReference
    Materia materia;

    public Calificacion() {
    }

    public Calificacion(Integer idCalificacion, Double nota, LocalDate fechaEvaluacion) {
        this.idCalificacion = idCalificacion;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Integer idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
