/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author mfaun
 */
public class Estadio {
    private int id;
    private String nombre;
    private Ciudad ciudad;
    private int capacidad;

    public Estadio(int id, String nombre, Ciudad ciudad, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }
    
    public Estadio(){
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
