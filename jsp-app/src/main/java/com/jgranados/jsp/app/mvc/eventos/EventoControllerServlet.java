/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jgranados.jsp.app.mvc.eventos;

import com.jgranados.jsp.app.backend.database.entidades.Evento;
import com.jgranados.jsp.app.backend.exceptions.UserDataInvalidException;
import com.jgranados.jsp.app.backend.eventos.ConsultaEventos;
import com.jgranados.jsp.app.backend.eventos.CreadorEventos;
import com.jgranados.jsp.app.backend.exceptions.EntityAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jose
 */
@WebServlet(name = "EventoControllerServlet", urlPatterns = {"/mvc/eventos/eventos-servlet"})
public class EventoControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response.sendRedirect(request.getContextPath() + "/crear-eventos-post/evento-creado.jsp?codigo="+evento.getCodigo());

        /*request.getSession().setAttribute("eventoCreado", evento);
        response.sendRedirect(request.getContextPath() + "/crear-eventos-post/evento-creado.jsp");
         */
        // BE hace algo y devuelve el evento creado
        CreadorEventos creadorEventos = new CreadorEventos();
        try {
            Evento eventoCreado = creadorEventos.crearEvento(request);

            request.setAttribute("eventoCreado", eventoCreado);
        } catch (UserDataInvalidException | EntityAlreadyExistsException e) {
            request.setAttribute("error", e.getMessage());
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/mvc/eventos/evento-creado.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultaEventos consultaEventos = new ConsultaEventos();
        List<Evento> eventosList = consultaEventos.obtenerTodosLosEventos();

        request.setAttribute("eventos", eventosList);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/mvc/eventos/listado.jsp");
        dispatcher.forward(request, response);
    }

}
