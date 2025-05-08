package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.repositorios.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicio {

    @Autowired
    IMateriaRepositorio repositorio;

    //GUARDAR
    public Materia guardarMateria(Materia datosMateria)throws Exception{
        try {
            return this.repositorio.save(datosMateria);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR
    public Materia modificarMateria(Integer id, Materia datosMateria)throws Exception{
        try {
            Optional<Materia>materiaBuscada=this.repositorio.findById(id);
            if (materiaBuscada.isPresent()){
                materiaBuscada.get().setNombre(datosMateria.getNombre());
                return this.repositorio.save(materiaBuscada.get());
            }else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Materia buscarMateriaPorId(Integer id)throws Exception{
        try {
            Optional<Materia> materiaQueBusco = this.repositorio.findById(id);

            if (materiaQueBusco.isPresent()){
                return materiaQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR TODOS
    public List<Materia> buscarTodasMaterias()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarMateria(Integer id)throws Exception{
        try {
            Optional<Materia>materiaBuscada=this.repositorio.findById(id);
            if (materiaBuscada.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
