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
public class Division {
    private int id;
    private int nombre;

    public Division(int id, int nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Division(){
        
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getNombre() {
        return nombre;
    }
}
