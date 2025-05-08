package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.repositorios.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServicio {

    @Autowired
    IInscripcionRepositorio repositorio;

    //GUARDAR
    public Inscripcion guardarInscripcion(Inscripcion datosInscripcion)throws Exception{
        try {
            return this.repositorio.save(datosInscripcion);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR
    public Inscripcion modificarInscripcion(Integer id, Inscripcion datosInscripcion)throws Exception{
        try {
            Optional<Inscripcion>inscripcionBuscada=this.repositorio.findById(id);
            if (inscripcionBuscada.isPresent()){
                inscripcionBuscada.get().setFechaInscripcion(datosInscripcion.getFechaInscripcion());
                return this.repositorio.save(inscripcionBuscada.get());
            }else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Inscripcion buscarInscripcionPorId(Integer id)throws Exception{
        try {
            Optional<Inscripcion>inscripcionQueBusco = this.repositorio.findById(id);

            if (inscripcionQueBusco.isPresent()){
                return inscripcionQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR TODOS
    public List<Inscripcion> buscarTodasInscripciones()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarInscripcion(Integer id)throws Exception{
        try {
            Optional<Inscripcion>inscripcionBuscada=this.repositorio.findById(id);
            if (inscripcionBuscada.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
