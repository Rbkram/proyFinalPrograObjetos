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
        query = "insert into TCASO (NUMERO, DESCRIPCION, QUERELLANTE, JUEZ_NOMBRADO, ESTADO, FECHA) values('" + tmpCaso.getNumeroCaso() + "' ,'" + tmpCaso.getDescripcionCaso()+ "' ,'" + tmpCaso.getQuerellante_aCargo().getCedula()+ "' ,'" + tmpCaso.getJuez_nombrado().getCedula() + "' ,'" + tmpCaso.getEstado() + "' ,'" + fechaSql +"')";
        try{
            registrarNuevoEstadoHistorial(numeroCaso, estado, fecha);
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
    }

    public void registrarNuevoEstadoHistorial(String casoCorrespondiente, String nuevoEstado, LocalDate fecha) throws Exception{
        
        Date fechaSql = java.sql.Date.valueOf(fecha);
        
        String query;
        query = "insert into THISTORIAL (NUMERO_CASO,FECHA_CAMBIO,ESTADO) values('" + casoCorrespondiente + "' ,'" + fechaSql + "' ,'" + nuevoEstado  + "')";
        try{
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
    }
    
    //Pendiente ver para los String con la BD
    public ArrayList<Caso> listarCasosJuez(String pIDJuez){
       
        ArrayList<Caso> casos =  new ArrayList<>();
        
        String select = "SELECT NUMERO,DESCRIPCION,QUERELLANTE,JUEZ_NOMBRADO,ESTADO FROM TCASO WHERE JUEZ_NOMBRADO =" + "'" + pIDJuez + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {
            //String numeroCaso, String descripcionCaso, Querellante querellante_aCargo, Juez juez_nombrado, String estado, Date fecha
            while (rs.next()) {
                casos.add(new Caso(rs.getString("NUMERO"),rs.getString("DESCRIPCION"),rs.getString("QUERELLANTE"), rs.getString("ESTADO")));
            }

            rs.close();
            return casos;

        }catch(Exception err){
                
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
        
        return casos;
    }
    
    //Pendiente ver para los holaaa hola prueba con la BD
    public ArrayList<Caso> listarCasosQuerellante(String pIDQuerellante){
       
        ArrayList<Caso> casos =  new ArrayList<>();
        
        String select = "SELECT NUMERO,DESCRIPCION,JUEZ_NOMBRADO,ESTADO FROM TCASO WHERE QUERELLANTE =" + "'" + pIDQuerellante + "'";

        try (ResultSet rs = Conector.getConector().getDatosSQL(select)) {

            while (rs.next()) {
                casos.add(new Caso(rs.getString("NUMERO"),rs.getString("DESCRIPCION"), rs.getString("ESTADO")));
            }

            rs.close();
            return casos;

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
        
        Date fechaSql = java.sql.Date.valueOf(fechaCambio);
        
        String query;// UPDATE TCASO SET ESTADO = 'Recibido', FECHA = '1/16/2007' WHERE NUMERO = '123'
        query = "UPDATE TCASO SET ESTADO =" + "'" + EstadoCambio + "'" + ", FECHA =" + "'" + fechaSql + "'" + "WHERE NUMERO =" + "'" + idCaso + "'";
        try{
            AccesoBD accesoDatos;
            accesoDatos = Conector.getConector();
            registrarNuevoEstadoHistorial(idCaso, EstadoCambio, fechaCambio);
            accesoDatos.ejecutarSQL(query);
        }catch(Exception err){
            System.out.println(err);
            System.out.println(err.getMessage());
        }
        
    }
    
    public ArrayList<Historial_Caso> listarHistorial(String pIDCaso) throws Exception, SQLException{
        
        ArrayList<Historial_Caso> HistCasos = new ArrayList<>();
        
        // pendiente mandar a traer la lista del historial del caso!!!!!!!!!!
        return HistCasos;
    }
    
}
