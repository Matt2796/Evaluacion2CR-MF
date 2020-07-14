/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Calendar;
import modelos.Jugador;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author mfaun
 */
public class JugadorDAO extends Conexion {
        public int registrarJugador(Jugador j) throws ClassNotFoundException, SQLException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(j.getFecha_nacimiento());
        java.sql.Date sqlDate = new java.sql.Date(j.getFecha_nacimiento().getTime());        
                
                
        String sentencia = "insert into jugador (nombre,apellido,fecha_nacimiento,id_posicion,sueldo,id_equipo) values (?,?,?,?,?,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, j.getNombre());
        ps.setString(2, j.getApellido());
        ps.setDate(3, sqlDate); 
        ps.setInt(4, j.getPosicion().getId());
        ps.setInt(5, j.getSueldo());
        ps.setInt(6, j.getPosicion().getId());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificar(Jugador j) throws SQLException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(j.getFecha_nacimiento());
        java.sql.Date sqlDate = new java.sql.Date(j.getFecha_nacimiento().getTime());
      
        try{
            String sentencia ="update jugador set nombre = ?, apellido = ? , "
                    + "fecha_nacimiento = ?, id_posicion = ?, sueldo = ?, id_equipo = ?  where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getApellido());
            ps.setDate(3, sqlDate); 
            ps.setInt(4, j.getPosicion().getId());
            ps.setInt(5, j.getSueldo());
            ps.setInt(6, j.getEquipo().getId());
            ps.setInt(7, j.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int eliminar(Jugador j) throws SQLException{
        try{
            String sentencia ="delete from jugador where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, j.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    
        public Jugador obtenerJugador(int id) throws SQLException{
        try{
            String sentencia = "select * from jugador where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Jugador j = null;
            PosicionDAO pd = new PosicionDAO();
            EquipoDAO eqd = new EquipoDAO();           
            if(rs.next()){
                j = new Jugador(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        pd.obtenerPosicion(rs.getInt("id")),
                        rs.getInt("sueldo"),
                        eqd.obtenerEquipo(rs.getInt("id")));
            }
            return j;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }

    public ArrayList<Jugador> obtenerJugadores() throws SQLException{
        try{
            String sentencia = "select * from jugador";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Jugador> lista = new ArrayList();
            Jugador j = null;
            PosicionDAO pd = new PosicionDAO();
            EquipoDAO eqd = new EquipoDAO();    
            while(rs.next()){
                lista.add(new Jugador(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        pd.obtenerPosicion(rs.getInt("id")),
                        rs.getInt("sueldo"),
                        eqd.obtenerEquipo(rs.getInt("id"))));
            }
            return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public int obtenerEdad(Date Fecha){

        Calendar cal = Calendar.getInstance();
        cal.setTime(Fecha);
        int year = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DATE);
        
        Calendar c = Calendar.getInstance();
	   
        int diaActual = c.get(Calendar.DATE);
        int mesActual = c.get(Calendar.MONTH);
        int yearActual = c.get(Calendar.YEAR);

        int edad = yearActual-year;
        
        if(mes>mesActual){
            edad = edad-1;
        }
        return edad;
    }
                
}
