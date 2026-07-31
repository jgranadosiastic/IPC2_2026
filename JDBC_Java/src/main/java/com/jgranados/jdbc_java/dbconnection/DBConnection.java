/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class DBConnection {
    private static final String IP = "localhost";
    private static final int PUERTO = 3306;
    private static final String SCHEMA = "biblioteca";
    public static final String USER_NAME = "admindba";
    public static final String PASSWORD = "12345";

    // jdbc:mysql://localhost:3306/biblioteca
    public static final String URL = "jdbc:mysql://"
            + IP + ":" + PUERTO + "/" + SCHEMA;
    
    public static final String URL_FATAL = "jdbc:mysql://"
            + IP + ":" + PUERTO + "/" + SCHEMA + "?serverTimezone=UTC";
    
    public void connect() {
        System.out.println("URL de conexion: " + URL);
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Esquema: " + connection.getSchema());
            System.out.println("Catalogo: " + connection.getCatalog());

        } catch (SQLException e) {
            // manejamos la exception
            System.out.println("Error al conectarse");
            e.printStackTrace();
        }

    }
}
