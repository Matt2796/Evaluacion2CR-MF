<%-- 
    Document   : delequipo
    Created on : 14/07/2020, 12:40:19 PM
    Author     : mfaun
--%>

<%@page import="dao.DivisionDAO"%>
<%@page import="modelos.Division"%>
<%@page import="dao.EstadioDAO"%>
<%@page import="modelos.Estadio"%>
<%@page import="dao.CiudadDAO"%>
<%@page import="modelos.Ciudad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.EquipoDAO"%>
<%@page import="modelos.Equipo"%>
<%@page import="modelos.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar equipo</title>
    </head>
    <body>
            <center>
        <h1>Eliminar equipo</h1>
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
            Equipo eq = new EquipoDAO().obtenerEquipo(Integer.parseInt(request.getParameter("id")));
            %>
        <form action="ControladorEquipo" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="number" name="id" readonly="true" value="<%= eq.getId() %>" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" readonly="true" value="<%= eq.getNombre() %>"/></td>
                </tr><tr>
                    <td>Ciudad</td>
                    <td>
                        <select name="ciudad" readonly="true">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Ciudad> ciudad = new CiudadDAO().obtenerCiudades(); 
                            for(Ciudad c:ciudad){%>
                            <option value="<%= c.getId() %>" 
                                  <% if(c.getId()== eq.getCiudad().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= c %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Estadio</td>
                    <td>
                        <select name="estadio" readonly="true">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Estadio> estadio = new EstadioDAO().obtenerEstadios(); 
                            for(Estadio es:estadio){%>
                            <option value="<%= es.getId() %>" 
                                  <% if(es.getId()== eq.getEstadio().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= es %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Division</td>
                    <td>
                        <select name="division">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Division> division = new DivisionDAO().obtenerDivisiones(); 
                            for(Division d:division){%>
                            <option value="<%= d.getId() %>" 
                                  <% if(d.getId()== eq.getDivision().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= d %></option>
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
