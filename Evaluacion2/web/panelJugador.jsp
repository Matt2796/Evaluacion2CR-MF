<%-- 
    Document   : panelJugador
    Created on : 13-07-2020, 18:26:38
    Author     : Matias Faundez - Cristian Riffo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel Equipos</title>
        
        <style>
            body{margin:0 auto; justify-content: center; display: flex;}
            #ContainerPanel{
                width: 100%;
                height: 80px;
                background-color: gray;
                position: fixed;
                top: 0px;
                z-index: 2;
                padding-left: 20px;
                padding-right: 20px;
            }
            #detalles{line-height: 80px; float: left; margin-left: 20px }
            #customers {
                border-collapse: collapse;
                width: 95%;
                position: fixed;
                margin-top: 140px;
            }
            #customers td, #customers th {
              border: 1px solid #ddd;
              padding: 8px;
            }
            #customers tr:hover {background-color: #ddd;}
            #customers th {
              padding-top: 12px;
              padding-bottom: 12px;
              text-align: left;
              background-color: black;
              color: white;
            }
        </style>
    </head>
    <body>
        
        <nav id="ContainerPanel">
            <span id="detalles"><a href="panelEstadios.jsp">Inicio</a></span>
            <span id="detalles"><a href="panelEstadios.jsp">Borrar</a></span>
            <a href="index.jsp" style="text-decoration: none; color:white"><div style='position:fixed; z-index: 2; margin-top: 90px; right: 20px; background-color: black;color: white;padding:10px'>Cerrar Sesion</div></a>
        </nav>
        
        <form style="margin-top:120px">
            Nombre: <input type="text" name="nombre"><br>
            Nombre: <input type="text" name="nombre"><br>
            Nombre: <input type="text" name="nombre"><br>
            Nombre: <input type="text" name="nombre"><br>
            <input type="submit" name="Guardar Cambios">
            
            
        </form>
    </body>
</html>

