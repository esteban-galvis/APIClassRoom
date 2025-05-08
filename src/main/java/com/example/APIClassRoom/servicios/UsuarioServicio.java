package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Usuario;
import com.example.APIClassRoom.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

    //GUARDAR
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try {
            return this.repositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    
    //MODIFICAR
    public Usuario modificarUsuario(Integer id, Usuario datosUsuario)throws Exception{
        try {
            Optional<Usuario>usuarioBuscado=this.repositorio.findById(id);

            if (usuarioBuscado.isPresent()){
                usuarioBuscado.get().setNombre(datosUsuario.getNombre());
                usuarioBuscado.get().setTipoUsuario(datosUsuario.getTipoUsuario());
                usuarioBuscado.get().setContraseña(datosUsuario.getContraseña());
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                return this.repositorio.save(usuarioBuscado.get());
            }else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR POR ID
    public Usuario buscarUsuarioPorId(Integer id)throws Exception{
        try {
            Optional<Usuario>usuarioQueBusco = this.repositorio.findById(id);

            if (usuarioQueBusco.isPresent()){
                return usuarioQueBusco.get();
            }else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //BUSCAR TODOS
    public List<Usuario> buscarTodosUsuarios()throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarUsuario(Integer id)throws Exception{
        try {
            Optional<Usuario>usuarioBuscado=this.repositorio.findById(id);

            if (usuarioBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
