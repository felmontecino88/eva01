package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Tarea;
import com.example.api.service.TareaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    public TareaController(TareaService tareaService) {
                this.tareaService = tareaService;
    }

    @GetMapping
    public List<Tarea> listarTareas() {
        return tareaService.getTareas();
    }

    @PostMapping
    public Tarea agregarTarea(@RequestBody Tarea tarea) {
        return tareaService.saveTarea(tarea);
    }

    @PutMapping("{id}")
    public Tarea actualizarTarea(@PathVariable int id, @RequestBody Tarea tarea) {
        return tareaService.updateTarea(tarea);
    }

    @DeleteMapping("{id}")
    public String eliminarTarea(@PathVariable int id) {
        return tareaService.deleteTarea(id);
    }

    @GetMapping("/total")
    public int totalTareas() {
        return tareaService.totalTareas();
    }

    @GetMapping("{id}")
    public Tarea buscarTareaId(@PathVariable int id) {
        return tareaService.getTareaId(id);
    }

    @GetMapping("/prioridad/{prioridad}")
    public List<Tarea> buscarTareaPrioridad(@PathVariable String prioridad) {
        return tareaService.getTareaPrioridad(prioridad);
    }

    @GetMapping("/responsable/{responsable}")
    public List<Tarea> buscarTareaResponsable(@PathVariable String responsable) {
        return tareaService.getTareaResponsable(responsable);
    }

    @GetMapping("/fechaInicio/{fechaInicio}")
    public List<Tarea> buscarTareaFechaInicio(@PathVariable String fechaInicio) {
        return tareaService.getTareaFechaInicio(fechaInicio);
    }

    @GetMapping("/fechaTermino/{fechaTermino}")
    public List<Tarea> buscarTareaFechaTermino(@PathVariable String fechaTermino) {
        return tareaService.getTareaFechaTermino(fechaTermino);
    }
}
