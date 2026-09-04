<%-- 
    Document   : index
    Created on : Sep 1, 2026, 8:52:32 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.write("Hello World desde JSP!");             %></h1>
        <a href="get/index-get.jsp?texto=id1&valor2=25&nombre=jose granados">Ir a index GET</a>
    </body>
    
    
    <h2>Formulario GET</h2> 
    <form method="GET" action="get/index-get.jsp">
        <label>texto</label>
        <br>
        <input name="texto"/>
        <br>
        <label>valor</label>
        <br>
        <input type="number" name="valor2"/>
        <button type="submit">Guardar</button>
    </form>
    
    <h2>Formulario POST</h2> 
    <form method="POST" action="get/index-get.jsp">
        <label>texto</label>
        <br>
        <input name="texto"/>
        <br>
        <label>valor</label>
        <br>
        <input type="number" name="valor2"/>
        <button type="submit">Guardar</button>
    </form>
</html>
