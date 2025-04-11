package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Integer idMateria;
    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @JsonBackReference
    Curso curso;

    @OneToMany
    @JsonManagedReference
    private List<Calificacion>calificaciones;

    public Materia() {
    }

    public Materia(Integer idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
