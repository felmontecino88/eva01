package com.example.api.mapper;

import com.example.api.model.Tarea;
import com.example.api.dto.CreateTareaRequest;


public class TareaMapper {

    public static Tarea toModel(CreateTareaRequest request) {
        return new Tarea(0, // ID temporal, será asignado por el service/repository
                request.detalle(), request.prioridad(), request.estado(), request.responsable(),
                request.fechaInicio(), null);
    }

}
