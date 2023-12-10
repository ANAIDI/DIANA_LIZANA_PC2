package com.lizana.model;

public class Asistente {
    private final int codigo;
    private final String nombre;
    private final String apellidos;
    private final String correo;
    private final String telefono;
    private final String direccion;
    // Otros atributos y métodos necesarios

    public Asistente(int codigo, String nombre, String apellidos, String correo, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Métodos getter para los atributos

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
}
