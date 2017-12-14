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
public class Juez extends Persona {
    
    private String sala_pertenece;
    private String clave;
    private String usuario;

    public Juez() {
        super();
        this.sala_pertenece = "";
        this.clave = "";
        this.usuario = "";
    }

    public Juez(String sala_pertenece, String clave, String usuario, String nombre, String apellido, String telefono, String cedula) {
        super(nombre, apellido, telefono, cedula);
        this.sala_pertenece = sala_pertenece;
        this.clave = clave;
        this.usuario = usuario;
    }

    public String getSala_pertenece() {
        return sala_pertenece;
    }

    public void setSala_pertenece(String sala_pertenece) {
        this.sala_pertenece = sala_pertenece;
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
        return "Juez{" + "sala_pertenece=" + sala_pertenece + ", clave=" + clave + ", usuario=" + usuario + '}';
    }

}
