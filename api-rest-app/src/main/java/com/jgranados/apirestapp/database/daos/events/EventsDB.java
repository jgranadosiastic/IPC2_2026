/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.apirestapp.database.daos.events;

import com.jgranados.apirestapp.database.DBConnectionSingleton;
import com.jgranados.apirestapp.database.entities.events.Event;
import com.jgranados.apirestapp.database.entities.events.EventTypeEnum;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jose
 */
public class EventsDB {

    private static final String CREAR_EVENTO_QUERY = "insert into evento (codigo, nombre, tipo, limite, fecha_inicio, precio) values (?,?,?,?,?,?)";
    private static final String ENCONTRAR_EVENTO_POR_CODIGO_QUERY = "select * from evento where codigo = ?";
    private static final String TODOS_LOS_EVENTOS_QUERY = "select * from evento";
    private static final String ACTUALIZAR_EVENTO_QUERY = "update evento set nombre = ?, tipo = ?, limite = ?, fecha_inicio = ?, precio = ? where codigo = ?";
    private static final String ELIMINAR_EVENTO_POR_CODIGO_QUERY = "delete from evento where codigo = ?";

    public Event createEvent(Event newEvent) {
        try (Connection connection = DBConnectionSingleton.getInstance().getConnection();
                PreparedStatement insert = connection.prepareStatement(CREAR_EVENTO_QUERY);) {
            insert.setString(1, newEvent.getCode());
            insert.setString(2, newEvent.getName());
            insert.setString(3, newEvent.getEventType().toString());
            insert.setInt(4, newEvent.getLimit());
            insert.setDate(5, Date.valueOf(newEvent.getStartDate()));
            insert.setDouble(6, newEvent.getPrice());
            insert.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return newEvent;
    }

    public boolean existsEvent(String codigo) {
        try (Connection connection = DBConnectionSingleton.getInstance().getConnection();
                PreparedStatement query = connection.prepareStatement(ENCONTRAR_EVENTO_POR_CODIGO_QUERY);) {
            query.setString(1, codigo);
            ResultSet result = query.executeQuery();
            return result.next();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return false;
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try (Connection connection = DBConnectionSingleton.getInstance().getConnection();
                PreparedStatement query = connection.prepareStatement(TODOS_LOS_EVENTOS_QUERY);) {
            ResultSet resultSet = query.executeQuery();

            while (resultSet.next()) {
                Event event = new Event(resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        EventTypeEnum.valueOf(resultSet.getString("tipo")),
                        resultSet.getInt("limite"),
                        resultSet.getDate("fecha_inicio").toLocalDate(),
                        resultSet.getDouble("precio")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return events;
    }

    public Optional<Event> getByCode(String code) {
        try (Connection connection = DBConnectionSingleton.getInstance().getConnection();
                PreparedStatement query = connection.prepareStatement(ENCONTRAR_EVENTO_POR_CODIGO_QUERY);) {
            query.setString(1, code);
            ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
                Event event = new Event(resultSet.getString("codigo"),
                        resultSet.getString("nombre"),
                        EventTypeEnum.valueOf(resultSet.getString("tipo")),
                        resultSet.getInt("limite"),
                        resultSet.getDate("fecha_inicio").toLocalDate(),
                        resultSet.getDouble("precio")
                );

                return Optional.of(event);
            }
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Event updateEvent(String code, Event eventToUpdate) {
        try (Connection connection = DBConnectionSingleton.getInstance().getConnection();
                PreparedStatement insert = connection.prepareStatement(ACTUALIZAR_EVENTO_QUERY);) {

            insert.setString(1, eventToUpdate.getName());
            insert.setString(2, eventToUpdate.getEventType().toString());
            insert.setInt(3, eventToUpdate.getLimit());
            insert.setDate(4, Date.valueOf(eventToUpdate.getStartDate()));
            insert.setDouble(5, eventToUpdate.getPrice());
            insert.setString(6, code);
            insert.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
        return eventToUpdate;
    }

    public void deleteByCode(String code) {
        try (Connection connection = DBConnectionSingleton.getInstance().getConnection();
                PreparedStatement deleteStatement = connection.prepareStatement(ELIMINAR_EVENTO_POR_CODIGO_QUERY);) {

            deleteStatement.setString(1, code);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            // manejar o propagar la exception
            e.printStackTrace();
        }
    }
}
