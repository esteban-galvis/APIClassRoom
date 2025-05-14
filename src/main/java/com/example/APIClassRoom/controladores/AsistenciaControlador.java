package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaControlador {

    @Autowired
    AsistenciaServicio servicio;

    //CONTROLADOR PARA GUARDAR
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Asistencia datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.servicio.guardarAsistencia(datosEnviadosPorElCliente));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA MODIFICAR

    //CONTROLADOR PARA BUSCAR POR ID

    //CONTROLADOR PARA BUSCARLOS TODOS

    //CONTROLADOR PARA ELIMINAR
}
