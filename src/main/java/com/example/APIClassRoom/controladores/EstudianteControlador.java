package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Estudiante;
import com.example.APIClassRoom.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    EstudianteServicio servicio;

    //CONTROLADOR PARA GUARDAR
    public ResponseEntity<?> guardar(@RequestBody Estudiante datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.servicio.guardarEstudiante(datosEnviadosPorElCliente));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //Controlador para modificar

    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Estudiante datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.modificarEstudiante(id, datos));
        }catch (Exception errorAPPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPPI.getMessage());
        }
    }

    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.buscarEstudiantePorId(id));
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
                    .status(HttpStatus.OK).body(this.servicio.buscarTodosEstudiantes());
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
                    .status(HttpStatus.OK).body(this.servicio.eliminarEstudiante(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }
}
