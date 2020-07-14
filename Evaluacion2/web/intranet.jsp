<%-- 
    Document   : intranet
    Created on : 13/07/2020, 09:52:51 PM
    Author     : mfaun
--%>
<%@page import="modelos.Jugador"%>
<%@page import="dao.JugadorDAO"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="util.UsuarioUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet</title>
    </head>
    <body>
    <center>
        <h1>Bienvenido</h1>
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
        <h3><%= u.getNombre()+" "+u.getApellido() %></h3>
        <%}else{response.sendRedirect("index.jsp?msj=acceso denegado");}%>
        </h1>
        <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
            
  
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
                <td><%= jd.obtenerEdad(j.getFecha_nacimiento()) %></td>
                <td><%= j.getSueldo() %></td>
                <td><
                <td><a href="modificaJugador.jsp?id=<%= j.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="eliminarJugador.jsp?id=<%= j.getId() %>">
                        <input type="button" value="Eliminar"/>
                    </a></td>
            </tr>
            <% } %>
        </table>
                </table>
            <input type="hidden" name="accion" value=""/>
        </form>
 </center>
</html>
