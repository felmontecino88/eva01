package com.example.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Tarea;
import com.example.api.repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    // C R U D
    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.guardarTarea(tarea);
    }

    public List<Tarea> getTareas() {
        return tareaRepository.obtenerTareas();
    }

    public Tarea updateTarea(Tarea tarea) {
        return tareaRepository.actualizarTarea(tarea);
    }

    public String deleteTarea(int id) {
        return tareaRepository.eliminarTarea(id);
    }

    // negocio
    public int totalTareas() {
        return tareaRepository.totalTareas();
    }

    // busqueda
    public Tarea getTareaId(int id) {
        return tareaRepository.buscarPorId(id);
    }

    public List<Tarea> getTareaPrioridad(String prioridad) {
        return tareaRepository.buscarPorPrioridad(prioridad);
    }

    public List<Tarea> getTareaResponsable(String responsable) {
        return tareaRepository.buscarPorResponsable(responsable);
    }

    public List<Tarea> getTareaFechaInicio(String fechaInicio) {
        return tareaRepository.buscarPorFechaInicio(fechaInicio);
    }

    public List<Tarea> getTareaFechaTermino(String fechatermino) {
        return tareaRepository.buscarPorFechaTermino(fechatermino);
    }


}
