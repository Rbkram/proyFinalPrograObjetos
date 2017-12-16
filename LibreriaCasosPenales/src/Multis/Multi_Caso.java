/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multis;

import Objetos.Caso;
import Objetos.Historial_Caso;
import java.util.ArrayList;
import java.sql.SQLException;
import java.time.LocalDate;
import com.cenfotec.AccesoDatos.*; 
import Objetos.Juez;
import Objetos.Querellante;
import java.sql.Date;
import java.sql.ResultSet;


/**
 *
 * @author Becky
 */
public class Multi_Caso {
    
    public void ingresarCasoBD(String numeroCaso, String descripcionCaso, Querellante querellante_aCargo, Juez juez_nombrado, String estado, LocalDate fecha) throws Exception{
        
        Date fechaSql = java.sql.Date.valueOf(fecha);
        
        Caso tmpCaso = new Caso(numeroCaso, descripcionCaso, querellante_aCargo, juez_nombrado, estado, fechaSql);
        String query;
        query = "insert into TCASO (NUMERO, DESCRIPCION, QUERELLANTE, JUEZ_NOMBRADO, ESTADO, FECHA) values('" + tmpCaso.getNumeroCaso() + "' ,'" + tmpCaso.getDescripcionCaso()+ "' ,'" + tmpCaso.getQuerellante_aCargo()+ "' ,'" + tmpCaso.getJuez_nombrado() + "' ,'" + tmpCaso.getEstado() + "' ,'" + tmpCaso.getFecha()+"')";
        try{
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            throw err;
        }
    }

    public void registrarNuevoEstado(String casoCorrespondiente, String nuevoEstado, LocalDate fecha) throws Exception{
        
        Date fechaSql = java.sql.Date.valueOf(fecha);
        
        String query;
        query = "insert into THISTORIAL (NUMERO_CASO,FECHA_CAMBIO,ESTADO) values('" + casoCorrespondiente + "' ,'" + nuevoEstado+ "' ,'" + fechaSql + "')";
        try{
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            throw err;
        }
    }
    
    //Pendiente ver para los String con la BD
    public ArrayList<Caso> listarCasosJuez(String pIDJuez){
       
        ArrayList<Caso> casos =  new ArrayList<>();
        
        String select = "SELECT * FROM Caso WHERE juez_nombrado =" + "'" + pIDJuez + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                // casos.add(new Caso(rs.getString("numeroCaso"), rs.getString("descripcionCaso"), rs.getString("querellante_aCargo"), rs.getString("juez_nombrado"), rs.getString("estado"), rs.getDate("fechaSql")));
            }

            rs.close();
            // return Caso;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        
        return casos;
    }
    
    //Pendiente ver para los holaaa hola prueba con la BD
    public ArrayList<Caso> listarCasosQuerellante(String pIDQuerellante){
       
        ArrayList<Caso> casos =  new ArrayList<>();
        
        String select = "SELECT * FROM Caso WHERE querellante_aCargo =" + "'" + pIDQuerellante + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                // casos.add(new Caso(rs.getString("numeroCaso"), rs.getString("descripcionCaso"), rs.getString("querellante_aCargo"), rs.getString("juez_nombrado"), rs.getString("estado"), rs.getDate("fechaSql")));
            }

            rs.close();
            // return Caso;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return casos;
    }
    
    //Pendiente ver para los String con la BD
    public Caso casoxID(String pIDCaso) throws Exception, SQLException{
        Caso casoEncontrado = new Caso();
        String select = "SELECT * FROM Caso WHERE numeroCaso =" + "'" + pIDCaso + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                // casoEncontrado = new Caso(rs.getString("numeroCaso"), rs.getString("descripcionCaso"), rs.getString("querellante_aCargo"), rs.getString("juez_nombrado"), rs.getString("estado"), rs.getDate("fechaSql"));
            }

            rs.close();
            return casoEncontrado;

        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        return casoEncontrado;
    }
    
    public void cambiarEstadoCaso(String idCaso, LocalDate fechaCambio, String EstadoCambio) throws Exception{
        
        Caso casoxMod;
        Date fechaSql = java.sql.Date.valueOf(fechaCambio);
        casoxMod = casoxID(idCaso);
        casoxMod.setEstado(EstadoCambio);
        ArrayList<Historial_Caso> historialActualizado;
        //Aqui hay que ver como se va a hacer el cmabio en el historial del estado
        
    }
    
    public ArrayList<Historial_Caso> listarHistorial(String pIDCaso) throws Exception, SQLException{
        
        ArrayList<Historial_Caso> HistCasos = new ArrayList<>();
        
        // pendiente mandar a traer la lista del historial del caso!!!!!!!!!!
        return HistCasos;
    }
    
}
