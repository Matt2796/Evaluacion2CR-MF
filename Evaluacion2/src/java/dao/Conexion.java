/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mfaun
 */
public class Conexion {
    Connection conexion;
    String url = "jdbc:mysql://localhost:3306/"; 
    String bd = "evaluacion2"; 
    String driver = "com.mysql.jdbc.Driver"; 
    String usuario = "root"; 
    String password = "";
    
    public Conexion(){
        
    }
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url+bd,usuario,password);
    }

    public void desconectar() throws SQLException{
        if(!conexion.isClosed()){
            conexion.close();
        }
    }
    
    public Statement obtenerStatement() throws SQLException{
        return conexion.createStatement();
    }

    public PreparedStatement obtenerPS(String sentencia) throws SQLException{
        return conexion.prepareStatement(sentencia);
    }
}
