/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.sql.Date;

/**
 *
 * @author Becky
 */
public class Historial_Caso {
    
    private Date fecha_cambioEstado;
    private String estado;

    public Historial_Caso() {
        this.estado = "";
    }
    
    public Historial_Caso(Date fecha_cambioEstado, String estado) {
        this.fecha_cambioEstado = fecha_cambioEstado;
        this.estado = estado;
    }

    public Date getFecha_cambioEstado() {
        return fecha_cambioEstado;
    }

    public void setFecha_cambioEstado(Date fecha_cambioEstado) {
        this.fecha_cambioEstado = fecha_cambioEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Historial_Caso{" + "fecha_cambioEstado=" + fecha_cambioEstado + ", estado=" + estado + '}';
    }
    
    
}
