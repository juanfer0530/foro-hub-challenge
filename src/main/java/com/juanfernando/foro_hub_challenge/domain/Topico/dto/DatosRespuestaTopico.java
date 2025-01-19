package com.juanfernando.foro_hub_challenge.domain.topico.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.juanfernando.foro_hub_challenge.domain.topico.Curso;

public record DatosRespuestaTopico(
    long id,
    String titulo,
    String mensaje,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime fecha,
    Boolean solucionado,
    String autor,
    Curso curso

) {

}