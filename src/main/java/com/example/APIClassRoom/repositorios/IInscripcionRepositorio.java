package com.example.APIClassRoom.repositorios;

import com.example.APIClassRoom.modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscripcionRepositorio extends JpaRepository<Inscripcion, Integer> {
}
