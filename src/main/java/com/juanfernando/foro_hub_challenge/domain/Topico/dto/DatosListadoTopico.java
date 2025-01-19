package com.juanfernando.foro_hub_challenge.domain.Topico.dto;

import java.time.LocalDateTime;

import com.juanfernando.foro_hub_challenge.domain.Topico.Topico;

public record DatosListadoTopico(
    long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha
) {
    public DatosListadoTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFecha()
        );
    }
}
