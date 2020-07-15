<%-- 
    Document   : estadios
    Created on : 14/07/2020, 08:46:06 AM
    Author     : mfaun
--%>

<%@page import="dao.CiudadDAO"%>
<%@page import="modelos.Ciudad"%>
<%@page import="modelos.Estadio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EstadioDAO"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estadios registrados</title>
    </head>
    <body>
    <center>
        <h1>Estadios</h1>
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
        <%}else{response.sendRedirect("index.jsp?msj=acceso denegado");}%>
        
        <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
        <h2>Menu de navegacion</h2>
        <menu>
            <a href="intranet.jsp">
            <menuitem>Inicio</menuitem>
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
        <h2>Registrar estadios</h2>
        <form action="ControladorEstadio" method="post">                    
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Ciudad</td>
                    <td>
                        <select name="ciudad">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Ciudad> ciudads = new CiudadDAO().obtenerCiudades(); 
                            for(Ciudad c:ciudads){%>
                            <option value="<%= c.getId() %>"><%= c.getNombre()  %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Capacidad</td>
                    <td><input type="number" name="capacidad"/></td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="2"/>
                </tr>
            </table>
   
        </form>
                        
        <br>
                <% if(request.getParameter("msj")!= null){%> 
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        <br>
                <h3>Estadios Registrados</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Ciudad</td>
                <td>Capacidad</td>
            </tr>
            <%  ArrayList<Estadio> estadio = new EstadioDAO().obtenerEstadios();
            for(Estadio e:estadio){
            %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getNombre() %></td>
                <td><%= e.getCiudad() %></td>
                <td><%= e.getCapacidad() %></td>
                <td><a href="modestadio.jsp?id=<%= e.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="delestadio.jsp?id=<%= e.getId() %>">
                        <input type="button" value="Eliminar"/>
                    </a></td>
            </tr>
            <% } %>
        </table>
            </center>
    </body>
</html>
