<%-- 
    Document   : panel
    Created on : 12-07-2020, 14:34:34
    Author     : Matias Faundez - Cristian Riffo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Equipos</title>
        
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
            
            #ContainerEquipo{
                margin-top: 85px;
                max-width: 1600px;
                height: 100%;    
            }
            
            #equipos{
                border-style: solid;
                border-radius: 5px;
                border-width: 2px;
                border-color: gray;
                width: 380px;
                height: 220px;
                margin-left: 15px;
                margin-top: 15px;
                float: left;
            }
            
            .Boton{
                padding:10px;
                border-style: solid;
                border-width: 2px;
                border-radius: 5px;
                margin-top: 17px;
                float: right;
                margin-right: 15px;
            }
            
            span{line-height: 80px; margin-left: 20px }
            .options{margin-right: 20px; float: right;}
        </style>
    </head>
    <body>
        <nav id="ContainerPanel">
            <span>Iniciar Sesion</span>
            <div class="Boton">Agregar Jugadores</div>
            <div class="Boton">Agregar Equipo</div>
        </nav>
    <center>
        <div id="ContainerEquipo">
            <div id="equipos">
                <p>Nombre Equipo</p>
                <p>Nombre Equipo</p>
                <p>Nombre Equipo</p>
            </div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
            <div id="equipos"></div>
        </div>
    </center>
    </body>
</html>
