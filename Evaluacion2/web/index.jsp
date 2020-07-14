<%-- 
    Document   : index.jsp
    Created on : 11-07-2020, 3:38:18
    Author     : Matias Faundez - Cristian Riffo 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
String registro = request.getParameter("codeReg");
if(registro == null){
    registro="1";
}
%>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        <style>
            #Contenedor
            {
                width: 70%;
                max-width: 520px;
                align-items: center;
                text-align: center;
                margin-top: 250px;
                
            }
        </style>
        
    </head>
    <body>
    <center>
        <% if(registro == "1"){ %> 
         
        
        <div id="Contenedor">
            <h2>Iniciar Sesion</h2>
            <form action="UsuarioControlador" method="get">
                <input name="run" placeholder="Run: 20.353.543-0" style="width:100%; height: 30px;" required><br><br>
                <input name="pass" placeholder="Contraseña" style="width:100%; height: 30px;" required><br><br>
                <input type='hidden' value="2" name="code">
                <input type="submit" value="Iniciar Sesion" style="width: 101%; height: 50px;"/>
            </form><br>
            <p><a href="index.jsp?codeReg=2">Registrarse</a></p>
        </div>
        
        <%}else{%>
        
        
        <div id="Contenedor">
            <h2>Registrarse</h2> 
            <form action="UsuarioControlador" method="get">
                <input name="run" placeholder="Run: 20.353.543-0" style="width:100%; height: 30px;" required><br><br>
                <input name="nombre" placeholder="Nombre" style="width:100%; height: 30px;" required><br><br>
                <input name="apellido" placeholder="Apellido" style="width:100%; height: 30px;" required><br><br>
                <input name="pass" placeholder="Contraseña" style="width:100%; height: 30px;" required><br><br>
                <input type='hidden' value="3" name="code">
                <input type="submit" value="Registrarse" style="width: 101%; height: 50px;"/>
            </form><br>
            
                
            <p><a href="index.jsp">Iniciar Sesion</a></p>
        </div>
        
        
        <%}
        
        String msg = request.getParameter("msg");
        if(msg!=null){%>
            <script>
            alert("<%= request.getParameter("msg") %>");
        </script>
        <%}
        %>
        <a href="panelEstadios.jsp">Test</a>
    </center>
    </body>
</html>
