/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Ciudad;
/**
 *
 * @author mfaun
 */
public class CiudadDAO extends Conexion {
        
    public int registrar(Ciudad c) throws SQLException{
        try{
            String sentencia ="Insert into ciudad (nombre) values (?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, c.getNombre());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificar(Ciudad c) throws SQLException{
        try{
            String sentencia ="update ciudad set nombre = ? where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int eliminar(Ciudad c) throws SQLException{
        try{
            String sentencia ="delete from ciudad where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, c.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    
        public Ciudad obtenerCiudad(int id) throws SQLException{
        String sentencia = "select * from ciudad where id=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Ciudad(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }

    public ArrayList<Ciudad> obtenerCiudades() throws SQLException{
        String sentencia = "select * from ciudad";
        try{      
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Ciudad> lista = new ArrayList();
            while(rs.next()){
                lista.add(new Ciudad(rs.getInt("id"),rs.getString("nombre")));
            }
            return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
}
