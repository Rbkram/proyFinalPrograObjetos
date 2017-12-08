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
public class Secretario extends Persona{
    
    private String clave;
    private String usuario;

    public Secretario() {
        super();
        this.clave = "";
        this.usuario = "";
    }

    public Secretario(String clave, String usuario, String nombre, String apellido, String telefono) {
        super(nombre, apellido, telefono);
        this.clave = clave;
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Secretario{" + "clave=" + clave + ", usuario=" + usuario + '}';
    }
    
}
