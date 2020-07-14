<%-- 
    Document   : equipos
    Created on : 14/07/2020, 08:44:53 AM
    Author     : mfaun
--%>


<%@page import="modelos.Jugador"%>
<%@page import="dao.JugadorDAO"%>
<%@page import="modelos.Equipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EquipoDAO"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos registrados</title>
    </head>
    <body>
    <center>
        <h1>Equipos</h1>
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
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

        <h3>Equipos Registrados</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Ciudad</td>
                <td>Division</td>
                <td>Estadio</td>
                <td>Jugadores</td>
            </tr>
            <%  EquipoDAO eqd = new EquipoDAO();
                ArrayList<Equipo> equipo = eqd.obtenerEquipos();
            for(Equipo eq:equipo){
            %>
            <tr>
                <td><%= eq.getId() %></td>
                <td><%= eq.getNombre() %></td>
                <td><%= eq.getCiudad() %></td>
                <td><%= eq.getEstadio() %></td>
                <td><%= eq.getDivision() %></td>
                <td></td>
                <td><a href="modequipo.jsp?id=<%= eq.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="delequipo.jsp?id=<%= eq.getId() %>">
                        <input type="button" value="Eliminar"/>
                    </a></td>
                    <td></td>
            </tr>
            <% } %>
        </table>
                
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
    </center>
    </body>
</html>
