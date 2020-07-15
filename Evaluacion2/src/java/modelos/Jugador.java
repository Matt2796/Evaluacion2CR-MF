/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Criss
 */

import java.util.Date;

public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private Posicion posicion;
    private int sueldo;
    private Equipo equipo;

    public Jugador(int id, String nombre, String apellido, Date fecha_nacimiento, Posicion posicion, int sueldo, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.equipo = equipo;
    }

    public Jugador(String nombre, String apellido, Posicion posicion, int sueldo, Equipo equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.posicion = posicion;
        this.sueldo = sueldo;
        this.equipo = equipo;
    }
    
    
    public Jugador(){
        
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
}
