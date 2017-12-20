/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazproyectofinal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author Olman
 */
public class InicioSesionController implements Initializable {
    private Stage stagePrincipal;
    FXMLDocumentController rooter = new FXMLDocumentController(); 
    /**
     * Initializes the controller class.
     */
    @FXML 
    private Label txtConfirmacion;

    @FXML 
    private TextField txtNombreUsuario; 
    
    @FXML 
    PasswordField txtContrasenna = new PasswordField (); 
   
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }
    
    /*@FXML private void redireccionar () {
       String userName = txtNombreUsuario.getText();
       int password = 1910;
        switch(userName) {

        case "oldMan":
            if (password == 1910){
                rooter.showVistaJuez();
            }else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;

        case "JoMan":
            if (password == 1910){
                rooter.showVistaJuez();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;
        
        case "edSan":
            if (password == 1910){
                rooter.showVistaJuez();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;
        
        case "jav34":
            if (password == 1910){
                rooter.showVistaJuez();
            } else {
               txtConfirmacion.setText("Datos incorrectos, inténtelo nuevamente");
               txtNombreUsuario.setText("");
               txtContrasenna.clear();
            }
        break;

        case "Esteb":
            if (password == 1910){
                rooter.showVistaJuez();
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

    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
