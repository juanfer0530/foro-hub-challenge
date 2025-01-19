package com.juanfernando.foro_hub_challenge.domain.topico.dto;

import com.juanfernando.foro_hub_challenge.domain.topico.Curso;


public record DatosActualizarTopico(
    long id,
    String titulo,
    String mensaje,
    String autor,
    Curso curso
) {

}
