<%-- 
    Document   : modestadio
    Created on : 14/07/2020, 12:39:48 PM
    Author     : mfaun
--%>

<%@page import="dao.CiudadDAO"%>
<%@page import="modelos.Ciudad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Usuario"%>
<%@page import="dao.EstadioDAO"%>
<%@page import="modelos.Estadio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar estadio</title>
    </head>
    <body>
            <center>
        <h1>Modificar estadio</h1>
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
        
                        <% if(request.getParameter("id")!=null){
            Estadio es = new EstadioDAO().obtenerEstadio(Integer.parseInt(request.getParameter("id")));
            %>
        <form action="ControladorEstadio" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="number" name="id" value="<%= es.getId() %>" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= es.getNombre() %>"/></td>
                </tr><tr>
                    <td>Ciudad</td>
                    <td>
                        <select name="ciudad">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Ciudad> ciudad = new CiudadDAO().obtenerCiudades(); 
                            for(Ciudad c:ciudad){%>
                            <option value="<%= c.getId() %>" 
                                  <% if(c.getId()== es.getCiudad().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= c %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Capacidad</td>
                    <td><input type="number" name="capacidad" value="<%= es.getCapacidad() %>"</td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Modificar"/></td>
                <input type="hidden" name="accion" value="3"/>
                </tr>
            </table>
        </form>
                        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
            </center>
    </body>
</html>