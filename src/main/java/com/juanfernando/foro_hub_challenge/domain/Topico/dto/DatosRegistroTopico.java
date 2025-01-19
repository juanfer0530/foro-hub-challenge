package com.juanfernando.foro_hub_challenge.domain.Topico.dto;

import java.time.LocalDateTime;

import com.juanfernando.foro_hub_challenge.domain.Topico.Curso;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
    @NotBlank(message = "El titulo es obligatorio")
    String titulo,

    @NotBlank(message = "El mensaje es obligatorio")
    String mensaje,

    @NotBlank(message = "El autor es obligatorio")
    String autor,

    @NotNull(message = "El curso es obligatorio")
    Curso curso
) {
}
