<%-- 
    Document   : panelEquipos
    Created on : 13-07-2020, 18:25:58
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
            <form id="detalles">
                
                Nombre: <input type="text" name="estadio" value="Nombre Estadio" /> 
                Ciudad: <select name="transporte">
                        <option>Coche</option>
                        <option>Avión</option>
                        <option>Tren</option>
                </select>
                Capacidad: <input type="number" name="capacidad" value="250" />
                <input type="submit" value="Cambiar" />
                
            </form>
            <span id="detalles"><a href="panelEstadios.jsp">Borrar</a></span>
            <a href="index.jsp" style="text-decoration: none; color:white"><div style='position:fixed; z-index: 2; margin-top: 90px; right: 20px; background-color: black;color: white;padding:10px'>Cerrar Sesion</div></a>
        </nav>
        
        <table id="customers">
            <tr>
              <th>Codigo</th>
              <th>Nombre</th>
              <th>Division</th>
              <th>Cant. Jugadores</th>
            </tr>
            
            <tr onclick='jugador(1200)'>
              <td>00001</td>
              <td>Barcelona</td>
              <td>Primera</td>
              <td>20</td>
            </tr>
        </table>
        
        <script>
            function jugador(num){
                window.location.href = "panelJugadores.jsp";
            }
        </script>
    </body>
</html>
