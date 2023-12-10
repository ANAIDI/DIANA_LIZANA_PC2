package com.lizana.model;
public class Expositor {
    private final int codigo;
    private final String nombre;
    private final String apellidos;
    private final double sueldo;
    private final String correo;
    // Otros atributos y métodos necesarios

    public Expositor(int codigo, String nombre, String apellidos, double sueldo, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
        this.correo = correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getCorreo() {
        return correo;
    }
// Métodos getter para los atributos
}
