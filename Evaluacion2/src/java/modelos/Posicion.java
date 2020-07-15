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
public class Posicion {
    private int id;
    private String nombre;

    public Posicion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Posicion(String nombre) {
        this.nombre = nombre;
    }
    
    public Posicion(){
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
