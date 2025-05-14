package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(nullable = false,length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_docente", referencedColumnName = "id_docente")
    @JsonBackReference(value = "docente-curso")
    private Docente docente;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Inscripcion>inscripciones;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Materia>materias;

    @OneToMany(mappedBy = "curso")
    @JsonManagedReference
    private List<Asistencia>asistencias;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombre) {
        this.idCurso = idCurso;
        this.nombre = nombre;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
