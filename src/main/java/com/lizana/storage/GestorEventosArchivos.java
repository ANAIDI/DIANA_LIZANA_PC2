package com.lizana.storage;

import com.lizana.IGestorEventos;
import com.lizana.model.Evento;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorEventosArchivos implements IGestorEventos {
    private List<Evento> eventos;

    public GestorEventosArchivos() {
        this.eventos = new ArrayList<>();
    }

    // Resto de los métodos de la interfaz

    @Override
    public void crearEvento(Evento evento) {

    }

    @Override
    public Evento obtenerEvento(int id) {
        return null;
    }

    @Override
    public List<Evento> obtenerTodosEventos() {
        return null;
    }

    @Override
    public void actualizarEvento(Evento evento) {

    }

    @Override
    public void eliminarEvento(int id) {

    }

    @Override
    public double obtenerCostoPromedio() {
        return 0;
    }

    @Override
    public double obtenerCostoMinimo() {
        return 0;
    }

    @Override
    public double obtenerCostoMaximo() {
        return 0;
    }

    @Override
    public int contarEventosSuperioresAlPromedio() {
        return 0;
    }

    @Override
    public Map<DayOfWeek, Long> obtenerEventosPorDiaSemana() {
        return null;
    }

    @Override
    public Map<Month, Long> obtenerEventosPorMes() {
        return null;
    }

    @Override
    public DayOfWeek obtenerDiaSemanaMasEventos() {
        return null;
    }

    @Override
    public Month obtenerMesMasEventos() {
        // Implementa lógica para obtener el mes con más eventos
        return null;
    }

    // Resto de los métodos de la clase
}
