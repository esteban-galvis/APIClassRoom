package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Calificacion;
import com.example.APIClassRoom.servicios.CalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionControlador {

    @Autowired
    CalificacionServicio servicio;

    //CONTROLADOR PARA GUARDAR
    public ResponseEntity<?> guardar(@RequestBody Calificacion datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.servicio.guardarCalificacion(datosEnviadosPorElCliente));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }
}
