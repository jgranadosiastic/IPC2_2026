/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java.dbconnection;

/**
 *
 * @author jose
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        DBConnection connection = new DBConnection();
        connection.connect();
        //connection.crearTabla();
        //connection.insertarAutor();
        connection.consultarTodosAutores();
    }
}
