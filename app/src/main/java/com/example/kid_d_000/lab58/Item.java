package com.example.kid_d_000.lab58;

public class Item {
    String nombre,telefono,duracion,tipo,fecha;

    public Item(String nombre, String telefono, String duracion, String tipo, String fecha) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.duracion = duracion;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }
}
