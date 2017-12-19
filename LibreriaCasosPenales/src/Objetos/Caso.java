/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Becky
 */
public class Caso {
    
    private String numeroCaso;
    private String descripcionCaso;
    private Querellante querellante_aCargo;
    private String querellante_aCargo_Id;
    private Juez juez_nombrado;
    private String estado;
    private Date fecha;

    public Caso() {
        this.numeroCaso = "";
        this.descripcionCaso = "";
        this.estado = "";
    }

    public Caso(String numeroCaso, String descripcionCaso, Querellante querellante_aCargo, Juez juez_nombrado, String estado, Date fecha) {
        this.numeroCaso = numeroCaso;
        this.descripcionCaso = descripcionCaso;
        this.querellante_aCargo = querellante_aCargo;
        this.juez_nombrado = juez_nombrado;
        this.estado = estado;
        this.fecha = fecha;
    }
    
    public Caso(String numeroCaso, String descripcionCaso, String querellante_aCargo, String estado) {
        this.numeroCaso = numeroCaso;
        this.descripcionCaso = descripcionCaso;
        this.querellante_aCargo_Id = querellante_aCargo;
        this.estado = estado;
    }

    public Caso(String numeroCaso, String descripcionCaso, String estado) {
        this.numeroCaso = numeroCaso;
        this.descripcionCaso = descripcionCaso;
        this.estado = estado;
    }     

    public String getQuerellante_aCargo_Id() {
        return querellante_aCargo_Id;
    }

    public void setQuerellante_aCargo_Id(String querellante_aCargo_Id) {
        this.querellante_aCargo_Id = querellante_aCargo_Id;
    }

    
    public String getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(String numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public String getDescripcionCaso() {
        return descripcionCaso;
    }

    public void setDescripcionCaso(String descripcionCaso) {
        this.descripcionCaso = descripcionCaso;
    }

    public Querellante getQuerellante_aCargo() {
        return querellante_aCargo;
    }

    public void setQuerellante_aCargo(Querellante querellante_aCargo) {
        this.querellante_aCargo = querellante_aCargo;
    }

    public Juez getJuez_nombrado() {
        return juez_nombrado;
    }

    public void setJuez_nombrado(Juez juez_nombrado) {
        this.juez_nombrado = juez_nombrado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Caso{" + "numeroCaso=" + numeroCaso + ", descripcionCaso=" + descripcionCaso + ", querellante_aCargo=" + querellante_aCargo + ", juez_nombrado=" + juez_nombrado + ", estado=" + estado + ", fecha=" + fecha + '}';
    }
 
}
