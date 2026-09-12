/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.backend.eventos;


import com.jgranados.jsp.app.backend.database.EventosDB;
import com.jgranados.jsp.app.backend.database.entidades.Evento;
import java.util.List;

/**
 *
 * @author jose
 */
public class ConsultaEventos {

    public List<Evento> obtenerTodosLosEventos() {
        EventosDB eventosDb = new EventosDB();

        return eventosDb.obtenerTodosLosEventos();
    }
    
}
