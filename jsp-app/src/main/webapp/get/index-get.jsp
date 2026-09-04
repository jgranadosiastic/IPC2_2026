<%-- 
    Document   : index-get
    Created on : Sep 2, 2026, 8:37:50 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index GET</title>
    </head>
    <body>
        <form method="GET">
            <label>texto</label>
            <br>
            <input name="texto"/>
            <br>
            <button type="submit">Guardar</button>
        </form>
        <%! int valor = 50;%>
        <h1>Hola mundo!!</h1>
        scriptlet
        <p id="p1" class="parrafo-rojo">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse imperdiet eleifend turpis vitae aliquam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus finibus malesuada orci eget tincidunt. Phasellus at est aliquam, molestie sem a, tincidunt arcu. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin tincidunt lacus non arcu tempor dignissim. Ut accumsan faucibus magna, et ullamcorper quam rutrum ut. Nam lorem nisl, suscipit a tempus eget, pellentesque id nulla.</p>
        <%
            String textoVal = request.getParameter("texto");
            if (textoVal != null && textoVal.equalsIgnoreCase("id2")) {
        %>
        <p id="id2" class="clase-dinamica-<%=valor%>">
            Maecenas non ultrices est. Sed ultricies metus varius nunc auctor, et tincidunt nibh convallis. Curabitur pharetra pharetra nibh, a placerat diam tristique vitae. Aenean at diam purus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla vitae tincidunt lacus, sed accumsan turpis. Aenean commodo eros leo, vehicula mattis ipsum volutpat ac. Quisque at varius ipsum.
        </p>
        <%
            }
        %>
        <%
            String valor2 = request.getParameter("valor2");
            
            Integer valor2Int = valor2 != null ? Integer.valueOf(valor2) : 0;
        %>
        <h1><%= suma(valor, valor2Int)%></h1>
    </body>
</html>

<%!

    int suma(int num1, int num2) {
        return num1 + num2;
    }
%>

