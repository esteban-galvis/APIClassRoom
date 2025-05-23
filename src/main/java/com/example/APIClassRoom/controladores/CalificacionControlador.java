package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Calificacion;
import com.example.APIClassRoom.servicios.CalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Controlador para modificar

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Calificacion datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.modificarCalificacion(id, datos));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.buscarCalificacionPorId(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //Controlador para buscarlos a todos
    @GetMapping
    public ResponseEntity<?> buscarTodo(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.buscarTodasCalificaciones());
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.eliminarCalificacion(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }
}
