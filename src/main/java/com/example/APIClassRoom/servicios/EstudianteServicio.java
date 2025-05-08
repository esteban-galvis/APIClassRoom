package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Estudiante;
import com.example.APIClassRoom.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    IEstudianteRepositorio repositorio;

    //GUARDAR
    public Estudiante guardarEstudiante(Estudiante datosEstudiante)throws Exception{
        try {
            return this.repositorio.save(datosEstudiante);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR
    public Estudiante modificarEstudiante(Integer id, Estudiante datosEstudiante)throws Exception{
        try {
            Optional<Estudiante>estudianteBuscado=this.repositorio.findById(id);
            
            if (estudianteBuscado.isPresent()){
                estudianteBuscado.get().setDireccion(datosEstudiante.getDireccion());
                estudianteBuscado.get().setGrado(datosEstudiante.getGrado());
                estudianteBuscado.get().setFechaNacimiento(datosEstudiante.getFechaNacimiento());
                return this.repositorio.save(estudianteBuscado.get());
            }else {
                throw new Exception(MensajesAPI.ESTUDIANTE_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Estudiante buscarEstudiantePorId(Integer id)throws Exception{
        try {
            Optional<Estudiante>estudianteQueBusco = this.repositorio.findById(id);

            if (estudianteQueBusco.isPresent()){
                return estudianteQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.ESTUDIANTE_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR TODOS
    public List<Estudiante> buscarTodosEstudiantes()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarEstudiante(Integer id)throws Exception{
        try {
            Optional<Estudiante>estudianteBuscado=this.repositorio.findById(id);

            if (estudianteBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ESTUDIANTE_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
