<%-- 
    Document   : intranet
    Created on : 13/07/2020, 09:52:51 PM
    Author     : mfaun
--%>

<%@page import="dao.DivisionDAO"%>
<%@page import="modelos.Division"%>
<%@page import="dao.EstadioDAO"%>
<%@page import="modelos.Estadio"%>
<%@page import="dao.CiudadDAO"%>
<%@page import="modelos.Ciudad"%>
<%@page import="modelos.Usuario"%>
<%@page import="dao.EquipoDAO"%>
<%@page import="modelos.Equipo"%>
<%@page import="dao.PosicionDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Posicion"%>
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
        <br>
        <br>
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
                            <option value="<%= p.getId() %>"><%= p %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Sueldo</td>
                    <td><input type="number" name="sueldo"/></td>
                </tr>
                <tr>
                    <td>Equipo</td>
                    <td>
                        <select name="equipo">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Equipo> equipos = new EquipoDAO().obtenerEquipos(); 
                            for(Equipo eq:equipos){%>
                            <option value="<%= eq.getId() %>"><%= eq %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        </form>
        <br>
        <br>
        <h2>Registrar equipos</h2>            
        <form action="ControladorEquipo" method="post">                    
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
                            <% ArrayList<Ciudad> ciudades = new CiudadDAO().obtenerCiudades(); 
                            for(Ciudad c:ciudades){%>
                            <option value="<%= c.getId() %>"><%= c %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Estadio</td>
                    <td>
                        <select name="estadio">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Estadio> estadios = new EstadioDAO().obtenerEstadios(); 
                            for(Estadio e:estadios){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Division</td>
                    <td>
                        <select name="division">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Division> divisiones = new DivisionDAO().obtenerDivisiones(); 
                            for(Division d:divisiones){%>
                            <option value="<%= d.getId() %>"><%= d %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
   
        </form>
        <br>
        <br>
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
                            <option value="<%= c.getId() %>"><%= c %></option>
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
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
   
        </form>
        <br>
        <br>
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
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>        
        </form>
        <br>
        <br>
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
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
        </form>
        <br>
        <br>
        <h2>Registrar ciudades</h2>
         <form action="ControladorCiudad" method="post">
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Registrar"/></td>
                <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
        </form>

       
        
 </center>
</html>
