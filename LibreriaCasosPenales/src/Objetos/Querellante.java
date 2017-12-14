/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Becky
 */
public class Querellante extends Persona{
    
    private String direccion;

    public Querellante() {
        super();
        this.direccion = "";
    }

    public Querellante(String direccion, String nombre, String apellido, String telefono, String cedula) {
        super(nombre, apellido, telefono, cedula);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Querellante{" + "direccion=" + direccion + '}';
    }

}
