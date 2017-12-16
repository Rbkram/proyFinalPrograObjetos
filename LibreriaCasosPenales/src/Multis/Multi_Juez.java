/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multis;

import Objetos.Juez;
import com.cenfotec.AccesoDatos.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Becky
 */
public class Multi_Juez {
    
    // prueba commit
    public Juez juezxID(String pID) throws Exception{
        Juez juezEncontrado = new Juez();
        
        String select = "SELECT * FROM Juez WHERE cedula =" + "'" + pID + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                juezEncontrado = new Juez(rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("sala_pertenece"), rs.getString("cedula"), rs.getString("clave"), rs.getString("usuario"));
            }

            rs.close();
            return juezEncontrado;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return juezEncontrado;
    }
    
    public ArrayList<Juez> listarJueces() throws Exception{
       
        ArrayList<Juez> listaJueces =  new ArrayList<>();
        
        String select = "SELECT NOMBRE,APELLIDO,TELEFONO,SALA,CEDULA,CLAVE,NOMBRE_USUARIO FROM TPERSONA WHERE TIPO_USUARIO = 'Juez'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                listaJueces.add(new Juez(rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getString("TELEFONO"), rs.getString("SALA"), rs.getString("CEDULA"), rs.getString("CLAVE"), rs.getString("NOMBRE_USUARIO")));
            }

            rs.close();
            return listaJueces;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return listaJueces;
    } 
}
