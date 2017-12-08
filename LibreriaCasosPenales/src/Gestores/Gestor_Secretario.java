/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Objetos.Secretario;
import java.util.ArrayList;
import Multis.*;

/**
 *
 * @author Becky
 */
public class Gestor_Secretario {
    
    public Secretario buscarObjSecretario(String pID){
        
        Secretario secreEncontrado;
        secreEncontrado = new Multi_Secretario().secretarioxID(pID);
        return secreEncontrado;
    }
    
    public ArrayList<Secretario> listarSecretarios() throws Exception{
        
        ArrayList<Secretario> listaSecretarios;
        listaSecretarios = new Multi_Secretario().listarSecre();
        return listaSecretarios;
    }
}
