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
import modelos.Division;
import modelos.Equipo;
import modelos.Estadio;

/**
 *
 * @author mfaun
 */
public class EquipoDAO extends Conexion {
          
    public int registrar(Equipo eq) throws SQLException{
        try{
            String sentencia ="Insert into equipo (nombre, id_ciudad, id_estadio, id_division) values (?,?,?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, eq.getNombre());
            ps.setInt(2, eq.getCiudad().getId());
            ps.setInt(3, eq.getEstadio().getId());
            ps.setInt(4, eq.getDivision().getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificar(Equipo eq) throws SQLException{
        try{
            String sentencia ="update equipo set nombre = ?, id_ciudad = ?, id_estadio = ?, id_division = ? where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, eq.getNombre());
            ps.setInt(2, eq.getCiudad().getId());
            ps.setInt(3, eq.getEstadio().getId());
            ps.setInt(4, eq.getDivision().getId());
            ps.setInt(5, eq.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int eliminar(Equipo eq) throws SQLException{
        try{
            String sentencia ="delete from equipo where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, eq.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    
        public Equipo obtenerEquipo (int id) throws SQLException{
        String sentencia = "select * from equipo where id=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Equipo eq = null;
            CiudadDAO cd = new CiudadDAO();
            EstadioDAO es = new EstadioDAO();
            DivisionDAO d = new DivisionDAO();
            if(rs.next()){
                eq = new Equipo ( rs.getInt("id"), 
                        rs.getString("nombre"), 
                        cd.obtenerCiudad(rs.getInt("id")), 
                        es.obtenerEstadio(rs.getInt("id")), 
                        d.obtenerDivision(rs.getInt("id")));
            } 
            return eq;
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }

    public ArrayList<Equipo> obtenerEquipos() throws SQLException{
        try{
            String sentencia = "select * from equipo";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Equipo> lista = new ArrayList();
            CiudadDAO cd = new CiudadDAO();
            EstadioDAO es = new EstadioDAO();
            DivisionDAO d = new DivisionDAO();
            while(rs.next()){
                lista.add(new Equipo(rs.getInt("id"), 
                        rs.getString("nombre"), 
                        cd.obtenerCiudad(rs.getInt("id")), 
                        es.obtenerEstadio(rs.getInt("id")), 
                        d.obtenerDivision(rs.getInt("id"))));
            }
            return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    } 
        public boolean existeEquipo(Equipo equipo) throws SQLException{
        try{
            String sentencia = "select * from equipo where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, equipo.getId());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception e){
            return false;
        }finally{
            desconectar();
        }
    }
        
        public boolean existeDivision(Division division) throws SQLException{
        try{
            String sentencia = "select * from equipo where id_division = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, division.getId());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception e){
            return false;
        }finally{
            desconectar();
        }
    }
        
        public boolean existeEstadio(Estadio estadio) throws SQLException{
        try{
            String sentencia = "select * from equipo where id_estadio = ?";
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
}
