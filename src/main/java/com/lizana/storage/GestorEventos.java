package com.lizana.storage;

import com.lizana.model.Evento;

import java.util.List;

public class GestorEventos {
    protected List<Evento> eventos;

    public GestorEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void crearEvento(Evento evento) {
        eventos.add(evento);
    }

    public Evento obtenerEvento(int id) {
        return eventos.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Evento> obtenerTodosEventos() {
        return eventos;
    }

    public void actualizarEvento(Evento evento) {
        eliminarEvento(evento.getId());
        crearEvento(evento);
    }

    public void eliminarEvento(int id) {
        eventos.removeIf(e -> e.getId() == id);
    }
}
