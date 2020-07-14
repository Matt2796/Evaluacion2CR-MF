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

/**
 *
 * @author mfaun
 */
public class EstadioDAO extends Conexion {
        public int registrar(Estadio es) throws SQLException{
        try{
            String sentencia ="Insert into estadio (nombre, id_ciudad, capacidad) values (?.?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, es.getNombre());
            ps.setInt(2, es.getCiudad().getId());
            ps.setInt(4, es.getCapacidad());
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
            String sentencia = "select * from estadio where codigo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Estadio es = null;
            CiudadDAO cd = new CiudadDAO();
            if(rs.next()){
                es = new Estadio(rs.getInt("id"),rs.getString("nombre"),cd.obtenerCiudad(rs.getInt("id")),rs.getInt("capacidad"));
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
            String sentencia = "select * from estadio";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Estadio> lista = new ArrayList();
            CiudadDAO cd = new CiudadDAO();
            while(rs.next()){
                lista.add(new Estadio(rs.getInt("id"),rs.getString("nombre"),cd.obtenerCiudad(rs.getInt("id")),rs.getInt("capacidad")));
            }
            return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
}
