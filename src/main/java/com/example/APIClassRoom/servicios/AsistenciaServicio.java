package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.repositorios.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    IAsistenciaRepositorio repositorio;

    //GUARDAR
    public Asistencia guardarAsistencia(Asistencia datosAsistencia)throws Exception{
        try {
            return this.repositorio.save(datosAsistencia);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR
    public Asistencia modificarAsistencia(Integer id, Asistencia datosAsistencia)throws Exception{
        try {
            Optional<Asistencia>asistenciaBuscada=this.repositorio.findById(id);

            if (asistenciaBuscada.isPresent()){
                asistenciaBuscada.get().setTipoAsistencia(datosAsistencia.getTipoAsistencia());
                asistenciaBuscada.get().setFecha(datosAsistencia.getFecha());
                return this.repositorio.save(asistenciaBuscada.get());
            }else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Asistencia buscarAsistenciaPorId(Integer id)throws Exception{
        try {
            Optional<Asistencia> asistenciaQueBusco = this.repositorio.findById(id);

            if (asistenciaQueBusco.isPresent()){
                return asistenciaQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR TODOS
    public List<Asistencia> buscarTodasAsistencias()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarAsistencia(Integer id)throws Exception{
        try {
            Optional<Asistencia> asistenciaBuscada = this.repositorio.findById(id);

            if (asistenciaBuscada.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

