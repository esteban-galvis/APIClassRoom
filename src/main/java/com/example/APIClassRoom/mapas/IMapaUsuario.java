package com.example.APIClassRoom.mapas;

import com.example.APIClassRoom.DTO.DTOUsuario;
import com.example.APIClassRoom.modelos.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IMapaUsuario {

    IMapaUsuario INSTANCIA= Mappers.getMapper(IMapaUsuario.class);

    //CREANDO EL DTO
    DTOUsuario transformarModeloADto(Usuario usuario);

}
