package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer idDocente;
    @Column(nullable = false, length = 100)
    private String especialidad;

    @OneToMany(mappedBy = "docente")
    @JsonManagedReference
    private List<Curso> cursos;



    public Docente() {
    }

    public Docente(Integer idDocente, String especialidad) {
        this.idDocente = idDocente;
        this.especialidad = especialidad;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
