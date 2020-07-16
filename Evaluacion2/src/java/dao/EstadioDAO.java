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
import modelos.Estadio;
import modelos.Jugador;

/**
 *
 * @author mfaun
 */
public class EstadioDAO extends Conexion {
        public int registrar(Estadio es) throws SQLException{
        try{
            String sentencia ="Insert into estadio (nombre, id_ciudad, capacidad) values (?,?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, es.getNombre());
            ps.setInt(2, es.getCiudad().getId());
            ps.setInt(3, es.getCapacidad());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificar(Estadio es) throws SQLException{
        try{
            String sentencia ="update estadio set nombre = ?, id_ciudad = ? , capacidad=?  where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, es.getNombre());
            ps.setInt(2, es.getCiudad().getId());
            ps.setInt(3, es.getCapacidad());
            ps.setInt(4, es.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int eliminar(Estadio es) throws SQLException{
        try{
            String sentencia ="delete from estadio where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, es.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    
        public Estadio obtenerEstadio(int id) throws SQLException{
        try{
            String sentencia = "select * from v_estadios where codigo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Estadio es = null;
            if(rs.next()){
                Ciudad c = new Ciudad(rs.getInt("id_ciudad"),rs.getString("nombre_ciudad"));
                es = new Estadio(rs.getInt("id"),rs.getString("nombre"),c,rs.getInt("capacidad"));
            }
            return es;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }

    public ArrayList<Estadio> obtenerEstadios() throws SQLException{
        try{
            String sentencia = "select * from v_estadios";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Estadio> estadios = new ArrayList();
            while(rs.next()){
                Ciudad c = new Ciudad(rs.getInt("id_ciudad"),rs.getString("nombre_ciudad"));
                estadios.add(new Estadio(rs.getInt("id"),rs.getString("nombre"),c,rs.getInt("capacidad")));
            }
            return estadios;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
            public boolean existeEstadio(Estadio estadio) throws SQLException{
        try{
            String sentencia = "select * from estadio where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, estadio.getId());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception e){
            return false;
        }finally{
            desconectar();
        }
    
            }
            
            public boolean existeCiudad(Ciudad ciudad) throws SQLException{
        try{
            String sentencia = "select * from estadio where id_ciudad = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, ciudad.getId());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception e){
            return false;
        }finally{
            desconectar();
        }
    
            }
            
    
}
