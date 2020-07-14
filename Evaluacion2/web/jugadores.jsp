<%-- 
    Document   : jugadores
    Created on : 14/07/2020, 08:44:06 AM
    Author     : mfaun
--%>


<%@page import="modelos.Usuario"%>
<%@page import="modelos.Jugador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.JugadorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jugadores registrados</title>
    </head>
    <body>
    <center>
        <h1>Jugadores</h1>
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
         
        <h3>Jugadores Registrados</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Edad</td>
                <td>Posicion</td>
                <td>Sueldo</td>
                <td>Equipo</td>
            </tr>
            <%  JugadorDAO jd = new JugadorDAO();
                ArrayList<Jugador> jugador = jd.obtenerJugadores();
            for(Jugador j:jugador){
            %>
            <tr>
                <td><%= j.getId() %></td>
                <td><%= j.getNombre() %></td>
                <td><%= j.getApellido() %></td>
                <td></td>
                <td><%= j.getPosicion() %></td>
                <td><%= j.getSueldo() %></td>
                <td><%= j.getEquipo() %></td>
                <td><a href="modjugador.jsp?id=<%= j.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="deljugador.jsp?id=<%= j.getId() %>">
                        <input type="button" value="Eliminar"/>
                    </a></td>
            </tr>
            <% } %>
        </table>
             
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>

           </center>
    </body>
    
</html>
