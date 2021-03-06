/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multis;

import Objetos.Querellante;
import java.sql.SQLException;
import com.cenfotec.AccesoDatos.*;
import java.sql.ResultSet;

/**
 *
 * @author Becky
 */
public class Multi_Querellante {
    
    
    public void registrarQuerellanteBD(String direccion, String nombre, String apellido, String telefono, String cedula) throws Exception{
        
        Querellante tmpQuerellante = new Querellante(direccion, nombre, apellido, telefono, cedula);
        String query;
        query = "insert into TPERSONA(NOMBRE, APELLIDO, TELEFONO, CEDULA, DIRECCION) values('" + tmpQuerellante.getNombre()+ "' ,'"+ tmpQuerellante.getApellido()+ "' ,'"+ tmpQuerellante.getTelefono()+ "' ,'"+ tmpQuerellante.getCedula() + "' ,'"+ tmpQuerellante.getDireccion()+"')";
       
        try{
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
    }
  
    public Querellante querellantexID(String pID) throws Exception{
        
        Querellante querellanteEncontrado = new Querellante();
        String select = "SELECT NOMBRE,APELLIDO,TELEFONO,CEDULA,DIRECCION FROM TPERSONA WHERE CEDULA =" + "'" + pID + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {
                                      
            while (rs.next()) {
                querellanteEncontrado = new Querellante( rs.getString("DIRECCION"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("TELEFONO"), rs.getString("CEDULA"));
            }

            rs.close();
            return querellanteEncontrado;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return querellanteEncontrado;
    }
    
}
