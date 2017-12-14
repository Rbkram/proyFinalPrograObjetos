/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multis;

import Objetos.Secretario;
import java.sql.SQLException;
import com.cenfotec.AccesoDatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Becky
 */
public class Multi_Secretario {
    
    public Secretario secretarioxID(String pIDUsuario){
        Secretario secreEncontrado = new Secretario();
        
        String select = "SELECT * FROM Secretario WHERE usuario =" + "'" + pIDUsuario + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                secreEncontrado = new Secretario(rs.getString("clave"), rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("cedula"));
            }

            rs.close();
            return secreEncontrado;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return secreEncontrado;
    }
    
    public ArrayList<Secretario> listarSecre() throws Exception{
       
        ArrayList<Secretario> listaSecre =  new ArrayList<>();
        
        String select = "SELECT * FROM Secretario";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                listaSecre.add(new Secretario(rs.getString("clave"), rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("cedula")));
            }

            rs.close();
            return listaSecre;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return listaSecre;
    }
}
