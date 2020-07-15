<%-- 
    Document   : jugadores
    Created on : 14/07/2020, 08:44:06 AM
    Author     : mfaun
--%>


<%@page import="dao.EquipoDAO"%>
<%@page import="modelos.Equipo"%>
<%@page import="modelos.Equipo"%>
<%@page import="modelos.Posicion"%>
<%@page import="dao.PosicionDAO"%>
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
                 <h2>Registrar jugadores</h2>   
        <form action="ControladorJugador" method="post">
            <table>
                        
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellido"/></td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento</td>
                    <td><input type="date" name="fecha_nacimiento"/></td>
                </tr>
                <tr>
                    <td>Posicion</td>
                    <td>
                        <select name="posicion">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Posicion> posiciones = new PosicionDAO().obtenerPosiciones(); 
                            for(Posicion p:posiciones){%>
                            <option value="<%= p.getId() %>"><%= p.getNombre()  %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Sueldo</td>
                    <td><input type="number" name="sueldo" value="0"/></td>
                </tr>
                <tr>
                    <td>Equipo</td>
                    <td>
                        <select name="equipo">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Equipo> equipos = new EquipoDAO().obtenerEquipos(); 
                            for(Equipo eq:equipos){%>
                            <option value="<%= eq.getId() %>"><%= eq.getNombre()  %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="2"/>
                </tr>
            </table>
        </form>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        <br>
        <br>
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

           </center>
    </body>
    
</html>
