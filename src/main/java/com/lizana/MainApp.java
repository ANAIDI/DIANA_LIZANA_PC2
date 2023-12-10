package com.lizana;
import com.lizana.enums.CategoriaEvento;
import com.lizana.model.Evento;
import com.lizana.storage.GestorEventosMemoria;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        IGestorEventos gestorEventos = new GestorEventosMemoria();

        // Crear y agregar eventos
        Evento evento1 = new Evento(1, "Evento 1", LocalDate.now(), "Dirección 1", 100, CategoriaEvento.PLATINUM, 500.0);
        Evento evento2 = new Evento(2, "Evento 2", LocalDate.now().plusDays(1), "Dirección 2", 150, CategoriaEvento.GOLD, 350.0);

        gestorEventos.crearEvento(evento1);
        gestorEventos.crearEvento(evento2);

        List<Evento> eventos = gestorEventos.obtenerTodosEventos();

        List<Evento> eventosOrdenadosAscendente = eventos.stream()
                .sorted(Comparator.comparing(Evento::getFecha))
                .collect(Collectors.toList());

        // Mostrar lista de eventos ordenados por fecha descendente
        List<Evento> eventosOrdenadosDescendente = eventos.stream()
                .sorted(Comparator.comparing(Evento::getFecha).reversed())
                .collect(Collectors.toList());

        // Lista de eventos filtrados por fechas con rango (fecha inicial y fecha final)
        LocalDate fechaInicial = LocalDate.now();
        LocalDate fechaFinal = LocalDate.now().plusDays(7);
        List<Evento> eventosEnRango = eventos.stream()
                .filter(evento -> evento.getFecha().isAfter(fechaInicial) && evento.getFecha().isBefore(fechaFinal))
                .collect(Collectors.toList());

        // Mostrar el nombre, mes, día, día de la semana del evento con capacidad máxima
        Evento eventoCapacidadMaxima = eventos.stream()
                .max(Comparator.comparing(Evento::getCapacidad))
                .orElse(null);
        if (eventoCapacidadMaxima != null) {
            System.out.println("Evento con capacidad máxima:");
            mostrarDetallesEvento(eventoCapacidadMaxima);
        }

        // Mostrar el nombre, mes, día, día de la semana del evento con capacidad mínima
        Evento eventoCapacidadMinima = eventos.stream()
                .min(Comparator.comparing(Evento::getCapacidad))
                .orElse(null);
        if (eventoCapacidadMinima != null) {
            System.out.println("Evento con capacidad mínima:");
            mostrarDetallesEvento(eventoCapacidadMinima);
        }

        // Obtener el día de la semana y el mes en el que se hacen más eventos
        Map<DayOfWeek, Long> eventosPorDiaSemana = eventos.stream()
                .collect(Collectors.groupingBy(evento -> evento.getFecha().getDayOfWeek(), Collectors.counting()));

        Map<Month, Long> eventosPorMes = eventos.stream()
                .collect(Collectors.groupingBy(evento -> evento.getFecha().getMonth(), Collectors.counting()));

        DayOfWeek diaSemanaMasEventos = obtenerMaximo(eventosPorDiaSemana);
        Month mesMasEventos = obtenerMaximo(eventosPorMes);

        System.out.println("Día de la semana con más eventos: " + diaSemanaMasEventos);
        System.out.println("Mes con más eventos: " + mesMasEventos);
    }

    private static <T> T obtenerMaximo(Map<T, Long> conteo) {
        return conteo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private static void mostrarDetallesEvento(Evento evento) {
        System.out.println("Nombre: " + evento.getNombre());
        System.out.println("Mes: " + evento.getFecha().getMonth());
        System.out.println("Día: " + evento.getFecha().getDayOfMonth());
        System.out.println("Día de la semana: " + evento.getFecha().getDayOfWeek());
        System.out.println("Capacidad: " + evento.getCapacidad());
        System.out.println("Categoría: " + evento.getCategoria());
        System.out.println("Costo: " + evento.getCosto());
        System.out.println("------------");
    }
}
