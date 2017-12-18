/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Multis.*;
import Objetos.Caso;
import Objetos.Historial_Caso;
import Objetos.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
/**
 *
 * @author Becky
 */
public class Gestor_Caso {
    
    
    public boolean ingresarCaso(String numeroCaso, String descripcionCaso, String idQuerellante) throws Exception{
        boolean registrado = false;
        Gestor_Querellante gestorQuerellante = new Gestor_Querellante(); 
        Querellante querellante_aCargo = new Querellante(); 
        Random randomGenerator;
        randomGenerator = new Random();
        // pendiente hacer lo de mandar el juez aleatoriamente, dentro del ciclo for
        try{
            LocalDate fecha = LocalDate.now();
            String estado;
            estado = "Recibido";
            
            querellante_aCargo = gestorQuerellante.buscarObjQuerellante(idQuerellante);
            
            ArrayList<Juez> listaJueces;
            listaJueces = new Multi_Juez().listarJueces();
            
            int index = randomGenerator.nextInt(listaJueces.size());
            Juez juezAleatorio = listaJueces.get(index);
            
            new Multi_Caso().ingresarCasoBD(numeroCaso, descripcionCaso, querellante_aCargo, juezAleatorio, estado, fecha);
            registrado = true;
            registrarHistorial(numeroCaso, estado);
        }
        catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
            registrado = false;
        }
        return registrado;
    }

    public void registrarHistorial(String numeroCaso, String estado) throws Exception{
        
        try{
            LocalDate fecha = LocalDate.now();
            Caso casoCorrespondiente;
            casoCorrespondiente = buscarObjCaso(numeroCaso);
            String nuevoEstado = estado;
            
            new Multi_Caso().registrarNuevoEstadoHistorial(casoCorrespondiente.getNumeroCaso(), nuevoEstado, fecha);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    public ArrayList<Caso> buscarCasosDeJuez(String cedulaJuez) throws Exception{
        
        ArrayList<Caso> listaCasosJuez;
        listaCasosJuez = new Multi_Caso().listarCasosJuez(cedulaJuez);
        return listaCasosJuez;
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
