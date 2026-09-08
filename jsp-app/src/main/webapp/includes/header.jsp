<%-- 
    Document   : header
    Created on : Sep 4, 2026, 5:15:38 PM
    Author     : jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container"> 
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom"> 
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"> 
            <i class="bi bi-bootstrap" style="font-size: 2rem;"></i>
            <span class="fs-4">Simple header</span> 
        </a>
        <ul class="nav nav-pills"> 
            <li class="nav-item">
                <a href="${pageContext.servletContext.contextPath}/index.jsp" class="nav-link active" aria-current="page">Home</a>
            </li> 
            <!-- 
            <li class="nav-item"><a href="#" class="nav-link">Usuarios</a></li> 
            <li class="nav-item"><a href="#" class="nav-link">Eventos</a></li> 
            <li class="nav-item"><a href="#" class="nav-link">Eventos Ajax</a></li> 
            <li class="nav-item"><a href="#" class="nav-link">Files</a></li>
            <li class="nav-item"><a href="#" class="nav-link">About</a></li>
            -->
        </ul> 
    </header>
</div>

