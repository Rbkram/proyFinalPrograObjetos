/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Objetos.Querellante;
import com.cenfotec.AccesoDatos.*;
import Multis.*;
/**
 *
 * @author Becky
 */
public class Gestor_Querellante {
    
    public void registrarQuerellante(String cedula, String direccion, String nombre, String apellido, String telefono) throws Exception{
        
        try{
            new Multi_Querellante().registrarQuerellanteBD(cedula, direccion, nombre, apellido, telefono);
        }
        catch(Exception e){
            e.getMessage();
        }
    }
    
    public Querellante buscarObjQuerellante(String pID) throws Exception{
        
        Querellante querellantEncontrado;
        querellantEncontrado = new Multi_Querellante().querellantexID(pID);
        
        return querellantEncontrado;
    }
}
