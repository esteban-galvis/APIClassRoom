package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Column(nullable = false)
    private Integer grado;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Column(nullable = false, length = 255)
    private String direccion;

    @OneToMany
    @JsonManagedReference
    private List<Inscripcion>inscripciones;

    @OneToMany
    @JsonManagedReference
    private List<Calificacion>calificaciones;

    @OneToMany
    @JsonManagedReference
    private List<Asistencia>asistencias;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, Integer grado, LocalDate fechaNacimiento, String direccion) {
        this.idEstudiante = idEstudiante;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
