package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.servicios.InscripcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionControlador {

    @Autowired
    InscripcionServicio servicio;

    //CONTROLADOR PARA GUARDAR
    public ResponseEntity<?> guardar(@RequestBody Inscripcion datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.servicio.guardarInscripcion(datosEnviadosPorElCliente));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Inscripcion datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.modificarInscripcion(id, datos));
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
                    .status(HttpStatus.OK).body(this.servicio.buscarInscripcionPorId(id));
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
                    .status(HttpStatus.OK).body(this.servicio.buscarTodasInscripciones());
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
                    .status(HttpStatus.OK).body(this.servicio.eliminarInscripcion(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }
}
