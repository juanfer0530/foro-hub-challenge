package com.juanfernando.foro_hub_challenge.domain.Topico.dto;

import com.juanfernando.foro_hub_challenge.domain.Topico.Curso;


public record DatosActualizarTopico(
    long id,
    String titulo,
    String mensaje,
    String autor,
    Curso curso
) {

}
