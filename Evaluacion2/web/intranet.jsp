<%-- 
    Document   : intranet
    Created on : 13/07/2020, 09:52:51 PM
    Author     : mfaun
--%>

<%@page import="dao.DivisionDAO"%>
<%@page import="modelos.Division"%>
<%@page import="dao.EstadioDAO"%>
<%@page import="modelos.Estadio"%>
<%@page import="dao.CiudadDAO"%>
<%@page import="modelos.Ciudad"%>
<%@page import="modelos.Usuario"%>
<%@page import="dao.EquipoDAO"%>
<%@page import="modelos.Equipo"%>
<%@page import="dao.PosicionDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Posicion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de información</title>
    </head>
    <body>
    <center>
        <h1>Bienvenido</h1>
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
        <h3><%= u.getNombre()+" "+u.getApellido() %></h3>
        <%}else{response.sendRedirect("index.jsp?msj=acceso denegado");}%>
        
        <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
        <h2>Menu de navegacion</h2>
        <menu>
            <a href="intranet.jsp">
            <menuitem >Inicio</menuitem>
            </a> |
            <a href="jugadores.jsp">
            <menuitem >Jugadores</menuitem>
            </a> | 
            <a href="equipos.jsp">
            <menuitem >Equipos</menuitem>
            </a> | 
            <a href="estadios.jsp">
            <menuitem >Estadios</menuitem>
            </a> | 
            <a href="divisiones.jsp">
            <menuitem >Divisiones</menuitem>
            </a> | 
            <a href="posiciones.jsp">
            <menuitem >Posiciones</menuitem>
            </a> | 
            <a href="ciudades.jsp">
            <menuitem >Ciudades</menuitem>
            </a>
        </menu>   
        <br>
        <h1> Selecciones que desea ingresar o visualizar </h1>
                <% if(request.getParameter("msj")!= null){%> 
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>  
       
        
 </center>
</html>
