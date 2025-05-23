package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Usuario;
import com.example.APIClassRoom.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio servicio;

    //CONTROLADOR PARA GUARDAR
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.servicio.guardarUsuario(datosEnviadosPorElCliente));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }

    //CONTROLADOR PARA MODIFICAR
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Usuario datos){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.modificarUsuario(id, datos));
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
                    .status(HttpStatus.OK).body(this.servicio.buscarUsuarioPorId(id));
        }catch (Exception erroAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(erroAPI.getMessage());
        }
    }

    //Controlador para buscarlos a todos
    @GetMapping
    public ResponseEntity<?> buscarTodo(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.servicio.buscarTodosUsuarios());
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
                    .status(HttpStatus.OK).body(this.servicio.eliminarUsuario(id));
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).body(errorAPI.getMessage());
        }
    }
}
