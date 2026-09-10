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
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>
            <div class="container">
                <h1><% out.write("Hello World desde JSP!");%></h1>
                <a href="get/index-get.jsp?texto=id1&valor2=25&nombre=jose granados">Ir a index GET</a>
                <h2>Formulario GET</h2> 
                <form method="GET" action="get/index-get.jsp">
                    <label>texto</label>
                    <br>
                    <input name="texto"/>
                    <br>
                    <label>valor</label>
                    <br>
                    <input type="number" name="valor2"/>
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </form>

                <h2>Formulario POST</h2> 
                <form method="POST" action="post/manejar-post.jsp">
                    <label>titulo</label>
                    <br>
                    <input name="titulo"/>
                    <br>
                    <label>fecha creacion</label>
                    <br>
                    <input type="date" name="fecha-creacion"/>
                    <button type="submit">Guardar</button>
                </form>
            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>



</html>
