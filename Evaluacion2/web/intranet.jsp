<%-- 
    Document   : intranet
    Created on : 13/07/2020, 09:52:51 PM
    Author     : mfaun
--%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="util.UsuarioUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet</title>
    </head>
    <body>
    <center>
        <h1>Bienvenido
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
        <h3><%= u.getNombre()+" "+u.getApellido() %></h3>
        <%}else{response.sendRedirect("index.jsp?msj=acceso denegado");}%>
        </h1>
        <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
        <menu >
            <a href="crudProductos.jsp">
            <menuitem >Productos</menuitem>
            </a>
        </menu>
        <h1>Registro de Usuarios</h1>
        <form action="ControladorUsuario" method="post">
            <table>
            <tr>
               <td>ID</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre"/></td>
            </tr>
            <tr>
                <td>Apellido</td>
                <td><input type="text" name="apellido"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Registrar"/></td>
                <td><a href="index.jsp">
                    <input type="button" value="Volver"/>
                    </a>
                </td>
            </tr>
            
        </table>
            <input type="hidden" name="accion" value="2"/>
        </form>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        <h3>Usuarios Registrados</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Password</td>
                <td>Modificar</td>
                <td>Eliminar</td>
            </tr>
            <%  UsuarioDAO ud = new UsuarioDAO();
                ArrayList<Usuario> usuarios = ud.obtenerUsuarios(); 
            for(Usuario u:usuarios){
            %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getNombre() %></td>
                <td><%= u.getApellido() %></td>
                <td><%= UsuarioUtil.createPassword() %></td>
                <td><a href="modificaUsuario.jsp?id=<%= u.getId() %>">
                        <input type="button" value="Modificar"/>
                    </a>
                </td>
                <td><a href="eliminarUsuario.jsp?id=<%= u.getId() %>">
                        <input type="button" value="Eliminar"/>
                    </a></td>
            </tr>
            <% } %>
        </table>
        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
      </center>
</html>
