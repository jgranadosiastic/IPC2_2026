<%-- 
    Document   : manejar-post
    Created on : Sep 4, 2026, 5:15:38 PM
    Author     : jose
--%>
<%@page import="com.jgranados.jsp.app.articulos.Articulo"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>
            <div class="container">
                <%
                    //simulacion de backend, esto debe estar en otras clases
                    List<Articulo> articulos = (ArrayList<Articulo>) session.getAttribute("articuloList");
                    if (articulos == null) {
                        articulos = new ArrayList<>();
                        session.setAttribute("articuloList", articulos);
                    }

                    boolean dataValida = true;

                    // captura de datos del articulo
                    String titulo = request.getParameter("titulo");
                    String fechaCreacionStr = request.getParameter("fecha-creacion");

                    if (titulo == null && fechaCreacionStr == null) {
                        dataValida = false;
                    } else {
                        Articulo newArticulo = new Articulo(titulo, LocalDate.parse(fechaCreacionStr));
                        articulos.add(newArticulo);
                    }
                %>
                <h1>Articulos</h1>
                <%
                    if (dataValida) {
                %>
                
                 <div class="alert alert-success" role="alert">
                    articulo creado!! articulos en base de datos: <%=articulos.size()%>
                </div>
               

                <%
                } else {
                %>
                <div class="alert alert-danger" role="alert">
                    Error con los datos del articulo!!
                </div>
                
                <%
                    }

                %>
            </div>
        </main>


    </body>
</html>
