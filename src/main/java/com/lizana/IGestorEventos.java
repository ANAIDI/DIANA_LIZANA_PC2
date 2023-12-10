package com.lizana;

import com.lizana.model.Evento;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;
import java.util.Map;

public interface IGestorEventos {
    // Operaciones CRUD
    void crearEvento(Evento evento);
    Evento obtenerEvento(int id);
    List<Evento> obtenerTodosEventos();
    void actualizarEvento(Evento evento);
    void eliminarEvento(int id);


    double obtenerCostoPromedio();
    double obtenerCostoMinimo();
    double obtenerCostoMaximo();
    int contarEventosSuperioresAlPromedio();
    // Operaciones de análisis de eventos
    Map<DayOfWeek, Long> obtenerEventosPorDiaSemana();
    Map<Month, Long> obtenerEventosPorMes();
    DayOfWeek obtenerDiaSemanaMasEventos();
    Month obtenerMesMasEventos();
}
