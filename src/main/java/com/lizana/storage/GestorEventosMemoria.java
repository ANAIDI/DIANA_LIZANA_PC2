package com.lizana.storage;

import com.lizana.IGestorEventos;
import com.lizana.model.Evento;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorEventosMemoria implements IGestorEventos {
    private List<Evento> eventos;

    public GestorEventosMemoria() {
        this.eventos = new ArrayList<>();
    }

    @Override
    public void crearEvento(Evento evento) {
        eventos.add(evento);
    }

    @Override
    public Evento obtenerEvento(int id) {
        return eventos.stream()
                .filter(evento -> evento.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Evento> obtenerTodosEventos() {
        return eventos;
    }

    @Override
    public void actualizarEvento(Evento evento) {
        // Implementa la actualización según tus necesidades
    }

    @Override
    public void eliminarEvento(int id) {
        eventos.removeIf(evento -> evento.getId() == id);
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

    // Implementa otros métodos según sea necesario

    // Implementación de operaciones de análisis de eventos
    @Override
    public Map<DayOfWeek, Long> obtenerEventosPorDiaSemana() {
        return eventos.stream()
                .collect(Collectors.groupingBy(evento -> evento.getFecha().getDayOfWeek(), Collectors.counting()));
    }

    @Override
    public Map<Month, Long> obtenerEventosPorMes() {
        return eventos.stream()
                .collect(Collectors.groupingBy(evento -> evento.getFecha().getMonth(), Collectors.counting()));
    }

    @Override
    public DayOfWeek obtenerDiaSemanaMasEventos() {
        return obtenerMaximo(obtenerEventosPorDiaSemana());
    }

    @Override
    public Month obtenerMesMasEventos() {
        return obtenerMaximo(obtenerEventosPorMes());
    }

    private <T> T obtenerMaximo(Map<T, Long> conteo) {
        return conteo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
