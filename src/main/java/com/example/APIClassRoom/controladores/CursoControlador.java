package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.servicios.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoControlador {

    @Autowired
    CursoServicio servicio;

    //CONTROLADOR PARA GUARDAR
    public ResponseEntity<?> guardar(@RequestBody Curso datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.servicio.guardarCurso(datosEnviadosPorElCliente));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

}
