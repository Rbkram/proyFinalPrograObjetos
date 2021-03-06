/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazproyectofinal;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Olman
 */
public class FXMLDocumentController implements Initializable {
    
    private InterfazProyectoFinal ProgramaPrincipal;
    
    @FXML 
    private Label txtConfirmacion;

    @FXML 
    private TextField txtNombreUsuario; 
    
    @FXML 
    PasswordField txtContrasenna = new PasswordField ();     
    

    @FXML
    private void mostrarLogin(ActionEvent event) {
        ProgramaPrincipal.vistaLogin();
    }   
    
    
    @FXML
    private void mostrarRegistrarCasos(ActionEvent event) {
        ProgramaPrincipal.mostrarRegistrarCasos();
    }
    
    private void mostrarRegistrarCasosSinParametro() {
        ProgramaPrincipal.mostrarRegistrarCasos();
    }    
    
    @FXML
    private void mostrarVistaQuerellante(ActionEvent event) {
        ProgramaPrincipal.vistaQuerellante();
    }    

    @FXML
    private void mostrarVistaJuez(ActionEvent event) {
        ProgramaPrincipal.vistaJuez();
    } 
    
    private void mostrarVistaJuezSinParametro() {
        ProgramaPrincipal.vistaJuez();
    }    
    
    public void setProgramaPrincipal(InterfazProyectoFinal ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML private void redireccionar () {
       String userName = txtNombreUsuario.getText();
       int password = 1910;
        switch(userName) {

        case "oldMan":
            if (password == 1910){
                txtNombreUsuario.setText("");
                txtContrasenna.clear();
                mostrarVistaJuezSinParametro();
            }else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;

        case "JoMan":
            if (password == 1910){
                txtNombreUsuario.setText("");
                txtContrasenna.clear();
                mostrarVistaJuezSinParametro();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;
        
        case "edSan":
            if (password == 1910){
                txtNombreUsuario.setText("");
                txtContrasenna.clear();
                mostrarVistaJuezSinParametro();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;
        
        case "jav34":
            if (password == 1910){
                txtNombreUsuario.setText("");
                txtContrasenna.clear();
                mostrarVistaJuezSinParametro();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;

        case "Esteb":
            if (password == 1910){
                txtNombreUsuario.setText("");
                txtContrasenna.clear();
                mostrarRegistrarCasosSinParametro();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;
        default:
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
        break;

     }

    }    
    
    
    
    
    
    
    
    
    
}
