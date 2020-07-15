<%-- 
    Document   : divisiones
    Created on : 14/07/2020, 08:45:47 AM
    Author     : mfaun
--%>

<%@page import="modelos.Division"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DivisionDAO"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Divisiones registradas</title>
    </head>
    <body>
    <center>
        <h1>Divisiones</h1>
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
        
        <h2>Registrar divisiones</h2>                       
        <form action="ControladorDivision" method="post">
            
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
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>        
        </form>
        <br>
        <br>
       <h3>Divisiones registradas</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
            </tr>
            <%  DivisionDAO dd = new DivisionDAO();
                ArrayList<Division> division = dd.obtenerDivisiones();
            for(Division d:division){
            %>
            <tr>
                <td><%= d.getId() %></td>
                <td><%= d.getNombre() %></td>
                <td><a href="moddivision.jsp?id=<%= d.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="deldivision.jsp?id=<%= d.getId() %>">
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
