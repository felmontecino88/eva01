package com.example.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.api.model.Tarea;

@Repository
public class TareaRepository {

    private List<Tarea> listaTareas = new ArrayList<>();

    //C R U D
    public Tarea guardarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTareas() {
        return listaTareas;
    }

    public Tarea actualizarTarea(Tarea tarea) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == tarea.getId()) {
                id = tarea.getId();
                idPosicion = i;
            }
        }

        Tarea tarea1 = new Tarea();
        tarea1.setId(id);
        tarea1.setDetalle(tarea.getDetalle());
        tarea1.setEstado(tarea.getEstado());
        tarea1.setPrioridad(tarea.getPrioridad());
        tarea1.setResponsable(tarea.getResponsable());
        tarea1.setFechaInicio(tarea.getFechaInicio());
        tarea1.setFechaTermino(tarea.getFechaTermino());

        listaTareas.set(idPosicion, tarea1);
        return tarea1;
    }

    public String eliminarTarea(int id) {
        listaTareas.removeIf(tarea -> tarea.getId()==id);
        return "Tarea eliminada";
    }

    //funciones de negocio
    public int totalTareas() {
        return listaTareas.size();
    }

    //funciones de busqueda
    public Tarea buscarPorId(int id) {
        for (Tarea tarea : listaTareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        return null;
    }

    public List<Tarea> buscarPorPrioridad(String prioridad) {

        List<Tarea> resultadoPrioridad = new ArrayList<>();

        for (Tarea tarea : listaTareas) {
            if (tarea.getPrioridad().equalsIgnoreCase(prioridad)) {
                resultadoPrioridad.add(tarea);
            }
        }

        if (resultadoPrioridad.isEmpty()) {
            System.out.println("No hay tareas con esa prioridad");
        }
        return resultadoPrioridad;
    }

    public List<Tarea> buscarPorResponsable(String responsable) {
        List<Tarea> resultadoResponsable = new ArrayList<>();

        for (Tarea tarea : listaTareas) {
            if (tarea.getResponsable().equalsIgnoreCase(responsable)) {
                resultadoResponsable.add(tarea);
            }
        }

        if (resultadoResponsable.isEmpty()) {
            System.out.println("No hay coincidencias.");
        }
        return resultadoResponsable;
    }
/* 
    public List<Libro> buscarPorAnio(int anio) {
        List<Libro> resultado = new ArrayList<>();

        for (Libro l : listaLibros) {
            if (l.getFechaPublicacion() == anio) {
                resultado.add(l);
            }
        }

        if (resultado.isEmpty()) {
            System.out.println("No hay libros");
        }

        return resultado;
    }
*/
    public List<Tarea> buscarPorFechaInicio(String fechaInicio) {
        List<Tarea> resultadoFechaInicio = new ArrayList<>();

        for (Tarea tarea : listaTareas) {
            if (tarea.getFechaInicio().equalsIgnoreCase(fechaInicio)) {
                resultadoFechaInicio.add(tarea);
            }
        }
        if (resultadoFechaInicio.isEmpty()) {
            System.out.println("No hay coincidencias con esa fecha.");
        }

        return resultadoFechaInicio;
    }

    public List<Tarea> buscarPorFechaTermino(String fechaTermino) {
        List<Tarea> resultadoFechaTermino = new ArrayList<>();

        for (Tarea tarea : listaTareas) {
            if (tarea.getFechaTermino().equalsIgnoreCase(fechaTermino)) {
                resultadoFechaTermino.add(tarea);
            }
        }
        if (resultadoFechaTermino.isEmpty()) {
            System.out.println("No hay concidencias para esa fecha.");
        }
        return resultadoFechaTermino;
    }

}
