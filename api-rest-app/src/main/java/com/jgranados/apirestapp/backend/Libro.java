/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.apirestapp.backend;

/**
 *
 * @author jose
 */
public class Libro {
    private String nombre;
    private String autor;
    private int cantidadCopias;

    public Libro(String nombre, String autor, int cantidadCopias) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadCopias = cantidadCopias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }
    
    
}
