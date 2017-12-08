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
    
    private String cedula;
    private String direccion;

    public Querellante() {
        super();
        this.cedula = "";
        this.direccion = "";
    }

    public Querellante(String cedula, String direccion, String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono);
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Querellante{" + "cedula=" + cedula + ", direccion=" + direccion + '}';
    }
    
}
