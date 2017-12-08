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
    
    
    public void registrarQuerellanteBD(String cedula, String direccion, String nombre, String apellido, String telefono) throws Exception{
        
        Querellante tmpQuerellante = new Querellante(cedula, direccion, nombre, apellido, telefono);
        String query;
        query = "insert into Querellante(cedula, direccion, nombre, apellido, telefono) values('" + tmpQuerellante.getCedula()+ "' ,'"+ tmpQuerellante.getDireccion()+ "' ,'"+ tmpQuerellante.getNombre()+ "' ,'"+ tmpQuerellante.getApellido() + "' ,'"+ tmpQuerellante.getTelefono()+"')";
        try{
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            throw err;
        }
    }
  
    public Querellante querellantexID(String pID) throws Exception{
        
        Querellante querellanteEncontrado = new Querellante();
        String select = "SELECT * FROM Querellante WHERE cedula =" + "'" + pID + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                querellanteEncontrado = new Querellante(rs.getString("cedula"), rs.getString("direccion"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"));
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
