<%-- 
    Document   : posiciones
    Created on : 14/07/2020, 08:45:17 AM
    Author     : mfaun
--%>

<%@page import="modelos.Posicion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PosicionDAO"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posiciones registradas</title>
    </head>
    <body>
    <center>
        <h1>Posiciones</h1>
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
 
        <h2>Registrar posiciones</h2>
        <form action="ControladorPosicion" method="post">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="2"/>
                </tr>
            </table>
            
        </form>
        <br>
        <br>       
        <h3>Posiciones registradas</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
            </tr>
            <%  PosicionDAO pd = new PosicionDAO();
                ArrayList<Posicion> posicion = pd.obtenerPosiciones();
            for(Posicion p:posicion){
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNombre() %></td>
                <td><a href="modposicion.jsp?id=<%= p.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="delposicion.jsp?id=<%= p.getId() %>">
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
