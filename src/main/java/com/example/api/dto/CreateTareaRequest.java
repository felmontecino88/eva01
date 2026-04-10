package com.example.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTareaRequest(@NotBlank(message = "Detalle no puede estar vacío") String detalle,
                                @NotBlank(message = "Prioridad no puede estar vacío") String prioridad,
                                @NotBlank(message = "Estado no puede estar vacío") String estado,
                                @NotBlank(message = "Responsable no puede estar vacío") String responsable,
                                @NotBlank(message = "Fecha Inicio no puede estar vacío") String fechaInicio) {
                                }
