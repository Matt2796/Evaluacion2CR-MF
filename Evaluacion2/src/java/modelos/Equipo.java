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
public class Equipo {
    private int id;
    private String nombre;
    private Ciudad ciudad;
    private Estadio estadio;
    private Division division;

    public Equipo(int id, String nombre, Ciudad ciudad, Estadio estadio, Division division) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.division = division;
    }
    
    public Equipo(){
        
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

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void setDivision(Division division) {
        this.division = division;
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

    public Estadio getEstadio() {
        return estadio;
    }

    public Division getDivision() {
        return division;
    }
}
