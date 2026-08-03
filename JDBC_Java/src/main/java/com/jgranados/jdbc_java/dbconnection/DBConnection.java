/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jdbc_java.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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

    public static final String CREAR_TABLE = """
                                             CREATE TABLE cv_autor (
                                             codigo_autor VARCHAR(7) NOT NULL,
                                             cantidad_publicaciones int,
                                             anios_laborales int,
                                             ultimo_trabajo VARCHAR(50),
                                             PRIMARY KEY(codigo_autor),
                                             CONSTRAINT fk_codigo_autor FOREIGN KEY (codigo_autor) REFERENCES autor(codigo)
                                             
                                             );
                                             """;

    public static final String INSERTAR_AUTOR = "INSERT INTO autor (codigo, nombre, nacionalidad) values ('abc-123', 'autor 1', 'guatemalteco')";
    public static final String INSERTAR_AUTOR_DINAMICO = """
                                                         INSERT INTO autor (codigo, nombre, nacionalidad) 
                                                         values ('%s', '%s', '%s')
                                                         """;

    public static final String CONSULTAR_TODOS_AUTORES = "SELECT * FROM autor";

    private Connection connection;

    public void connect() {
        System.out.println("URL de conexion: " + URL);
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Esquema: " + connection.getSchema());
            System.out.println("Catalogo: " + connection.getCatalog());

        } catch (SQLException e) {
            // manejamos la exception
            System.out.println("Error al conectarse");
            e.printStackTrace();
        }

    }

    public void crearTabla() {
        try {

            Statement creatTableStatement = connection.createStatement();
            creatTableStatement.execute(CREAR_TABLE);
        } catch (SQLException e) {
            // manejar correctamente
            e.printStackTrace();
        }
    }

    public void insertarAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INgrese codigo de autor:");
        String codigo = scanner.nextLine();
        System.out.println("INgrese nombre de autor:");
        String nombre = scanner.nextLine();
        System.out.println("INgrese nacionalidad de autor:");
        String nacionalidad = scanner.nextLine();
        Autor autor = new Autor(codigo, nombre, nacionalidad);

        String insert = String.format(INSERTAR_AUTOR_DINAMICO, codigo, nombre, nacionalidad);
        try {

            Statement insertStatement = connection.createStatement();
            int filas = insertStatement.executeUpdate(insert);
            System.out.println("Filas insertdas: " + filas);
        } catch (SQLException e) {
            // manejar correctamente
            e.printStackTrace();
        }
    }

    public void consultarTodosAutores() {
        try {

            Statement queryStatement = connection.createStatement();
            ResultSet resultSet = queryStatement.executeQuery(CONSULTAR_TODOS_AUTORES);
            System.out.println("Autores: ");
            while (resultSet.next()) {

                String codigo = resultSet.getString("codigo");
                System.out.println("Codigo: " + codigo);

                String nombre = resultSet.getString("nombre");
                System.out.println("nombre: " + nombre);

                String nacionalidad = resultSet.getString("nacionalidad");
                System.out.println("nacionalidad: " + nacionalidad);
            }
        } catch (SQLException e) {
            // manejar correctamente
            e.printStackTrace();
        }
    }
}
