/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Multis.*;
import Objetos.Caso;
import Objetos.Historial_Caso;
import Objetos.Juez;
import Objetos.Querellante;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author Becky
 */
public class Gestor_Caso {
    
    
    public void ingresarCaso(String numeroCaso, String descripcionCaso, Querellante querellante_aCargo) throws Exception{
        
        // pendiente hacer lo de mandar el juez aleatoriamente, dentro del ciclo for
        try{
            LocalDate fecha = LocalDate.now();
            Juez juezNombrado = new Juez();
            String estado;
            estado= "recibido";
            
            ArrayList<Juez> listaJueces;
            listaJueces = new Multi_Juez().listarJueces();
            
            for (int i = 0; i < listaJueces.size(); i++) {
                
                // Aqui hay q hacer la asignación aleatoria del juez.
                juezNombrado = listaJueces.get(i);
            }
            
            new Multi_Caso().ingresarCasoBD(numeroCaso, descripcionCaso, querellante_aCargo, juezNombrado, estado, fecha);
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    public void registrarHistorial(String numeroCaso, String estado) throws Exception{
        
        try{
            LocalDate fecha = LocalDate.now();
            Caso casoCorrespondiente;
            casoCorrespondiente = buscarObjCaso(numeroCaso);
            String nuevoEstado = estado;
            
            new Multi_Caso().registrarNuevoEstado(casoCorrespondiente.getNumeroCaso(), nuevoEstado, fecha);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    public Caso buscarObjCaso(String pID) throws Exception{
        
        Caso casoBuscado;
        casoBuscado =  new Multi_Caso().casoxID(pID);
        
        return casoBuscado;
    }
    
    public void modificarEstado(String pIDCaso, String pEstadoNuevo) throws Exception{
       
        LocalDate fechaCambio = LocalDate.now();
        new Multi_Caso().cambiarEstadoCaso(pIDCaso, fechaCambio, pEstadoNuevo); 
    }
    
    public ArrayList<Caso> listarCasosJuez(String pIDJuez) throws Exception{
        
        ArrayList<Caso> listaCasos;
        listaCasos = new Multi_Caso().listarCasosJuez(pIDJuez);
        return listaCasos;
    }
    
    public ArrayList<Caso> listarCasosQuerellante(String pIDQuerellante) throws Exception{
        
        ArrayList<Caso> listaCasos;
        listaCasos = new Multi_Caso().listarCasosQuerellante(pIDQuerellante);
        return listaCasos;
    }
     
     public ArrayList<Historial_Caso> listarHistoralCaso(String pIDCaso) throws Exception{
        
        ArrayList<Historial_Caso> Historial;
        Historial =  new Multi_Caso().listarHistorial(pIDCaso);
        return Historial;
    }
    
}
