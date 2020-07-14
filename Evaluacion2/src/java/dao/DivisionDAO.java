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

/**
 *
 * @author mfaun
 */
public class DivisionDAO extends Conexion {
    
        public int registrar(Division d) throws SQLException{
        try{
            String sentencia ="Insert into division (nombre) values (?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, d.getNombre());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificar(Division d) throws SQLException{
        try{
            String sentencia ="update division set nombre = ? where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, d.getNombre());
            ps.setInt(2, d.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int eliminar(Division d) throws SQLException{
        try{
            String sentencia ="delete from division where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, d.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public Division obtenerDivision(int id) throws SQLException{
        String sentencia = "select * from division where id=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Division(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Division> obtenerDivisiones() throws SQLException{
        try{
            String sentencia = "select * from division";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Division> lista = new ArrayList();
            while(rs.next()){
                lista.add(new Division(rs.getInt("id"),rs.getString("nombre")));
            }
            return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
}
