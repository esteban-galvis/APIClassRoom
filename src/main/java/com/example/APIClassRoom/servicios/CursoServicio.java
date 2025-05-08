package com.example.APIClassRoom.servicios;


import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.repositorios.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    @Autowired
    ICursoRepositorio repositorio;

    //GUARDAR
    public Curso guardarCurso(Curso datosCurso)throws Exception{
        try {
            return this.repositorio.save(datosCurso);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR
    public Curso modificarCurso(Integer id, Curso datosCurso)throws Exception{
        try {
            Optional<Curso>cursoBuscado=this.repositorio.findById(id);

            if (cursoBuscado.isPresent()){
                cursoBuscado.get().setNombre(datosCurso.getNombre());
                return this.repositorio.save(cursoBuscado.get());
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Curso buscarCursoPorId(Integer id)throws Exception{
        try {
            Optional<Curso> cursoQueBusco = this.repositorio.findById(id);

            if (cursoQueBusco.isPresent()){
                return cursoQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR TODOS
    public List<Curso> buscarTodosCursos()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarCurso(Integer id)throws Exception{
        try {
            Optional<Curso>cursoBuscado = this.repositorio.findById(id);
            if (cursoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
