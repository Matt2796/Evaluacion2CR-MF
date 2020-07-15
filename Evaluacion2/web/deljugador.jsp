<%-- 
    Document   : deljugador
    Created on : 14/07/2020, 12:40:04 PM
    Author     : mfaun
--%>

<%@page import="dao.EquipoDAO"%>
<%@page import="modelos.Equipo"%>
<%@page import="dao.PosicionDAO"%>
<%@page import="modelos.Posicion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.JugadorDAO"%>
<%@page import="modelos.Jugador"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar jugador</title>
    </head>
    <body>
            <center>
        <h1>Eliminar jugador</h1>
<% if(session.getAttribute("usuario")==null){
            response.sendRedirect("index.jsp?msj=No te pases");
        }else{if(request.getParameter("id")!=null){
            Jugador j = new JugadorDAO().obtenerJugador(Integer.parseInt(request.getParameter("id")));
            %>
        
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
        
        <form action="ControladorJugador" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="number" name="id" readonly="true" value="<%= j.getId() %>" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" readonly="true" value="<%= j.getNombre() %>"/></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido" readonly="true" value="<%= j.getApellido() %>"</td>
                </tr>
                <tr>
                    <td>Fecha de nacimientp</td>
                    <td><input type="date" name="fecha_nacimiento" readonly="true" value="<%= j.getFecha_nacimiento() %>"/></td>
                </tr><tr>
                    <td>Posicion</td>
                    <td>
                        <select name="posicion" readonly="true">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Posicion> posicion = new PosicionDAO().obtenerPosiciones(); 
                            for(Posicion p:posicion){%>
                            <option value="<%= p.getId() %>" 
                                  <% if(p.getId()== j.getPosicion().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= p %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Sueldo</td>
                    <td><input type="number" name="sueldo" value="<%= j.getSueldo() %>"</td>
                </tr>
                <tr>
                    <td>Equipo</td>
                    <td>
                        <select name="equipo" readonly="true">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Equipo> equipo = new EquipoDAO().obtenerEquipos(); 
                            for(Equipo e:equipo){%>
                            <option value="<%= e.getId() %>" 
                                  <% if(e.getId()== j.getEquipo().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= e %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Eliminar"/></td>
                <input type="hidden" name="accion" value="4"/>
                </tr>
            </table>
        </form>
                        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
            </center>
    </body>
     <%}%>
</html>
