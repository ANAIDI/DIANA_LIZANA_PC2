package com.lizana.model;
import com.lizana.enums.CategoriaEvento;
import java.time.LocalDate;


import com.lizana.enums.CategoriaEvento;
import java.time.LocalDate;

public class Evento {
    private final int id;
    private final String nombre;
    private final LocalDate fecha;
    private final String direccion;
    private final int capacidad;
    private final CategoriaEvento categoria;
    private final double costo;

    public Evento(int id, String nombre, LocalDate fecha, String direccion, int capacidad, CategoriaEvento categoria, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.costo = costo;
    }

    // Métodos getter para los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public CategoriaEvento getCategoria() {
        return categoria;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return String.format(
                "Evento #%d: %s\nFecha: %s\nDirección: %s\nCapacidad: %d\nCategoría: %s\nCosto: %.2f",
                id, nombre, fecha, direccion, capacidad, categoria, costo
        );
    }
}
