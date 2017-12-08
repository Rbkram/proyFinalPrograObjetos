/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Objetos.Juez;
import Multis.*;
import java.util.ArrayList;

/**
 *
 * @author Becky
 */
public class Gestor_Juez {
    
    public Juez buscarObjJuez(String pID) throws Exception{
        
        Juez juezEncontrado;
        juezEncontrado = new Multi_Juez().juezxID(pID);
        
        return juezEncontrado;
    }
    
    
    public ArrayList<Juez> listarJueces() throws Exception{
        
        ArrayList<Juez> listaJueces;
        listaJueces = new Multi_Juez().listarJueces();
        return listaJueces;
    }
}
