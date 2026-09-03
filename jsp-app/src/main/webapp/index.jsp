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
</html>
