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
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String password;

    public Usuario(int id, String nombre, String apellido, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }
    
    public Usuario(){
        
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

    public void setPassword(String password) {
        this.password = password;
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

    public String getPassword() {
        return password;
    }
}
