package com.example.APIClassRoom.ayudas;

public enum MensajesAPI {

    USUARIO_NO_ENCONTRADO("El usuario que busca no se encuentra en BD"),

    MATERIA_NO_ENCONTRADA("La materia que busca no se encuentra en BD"),

    INSCRIPCION_NO_ENCONTRADA("La inscripcion que busca no se encuentra en BD"),

    ESTUDIANTE_NO_ENCONTRADO("El estudiante que busca no se encuentra en BD"),

    CURSO_NO_ENCONTRADO("El curso que busca no se encuentra en BD"),

    CALIFICACION_NO_ENCONTRADA("La calificacion que busca no se encuentra en BD"),

    ASISTENCIA_NO_ENCONTRADA("La asistencia que busca no se encuentra en BD"),

    DOCENTE_NO_ENCONTRADO("El docente que buscas no se encuentra en BD");

    private String texto;

    MensajesAPI(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
