package com.example.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {

    private int id;
    private String detalle;
    private String prioridad;
    private String estado;
    private String responsable;
    private String fechaInicio;
    private String fechaTermino;

}
