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
import javafx.stage.Stage;

/**
 *
 * @author Olman
 */
public class FXMLDocumentController implements Initializable {
    
    private InterfazProyectoFinal ProgramaPrincipal;
 
    @FXML
    private void nuevaVentana(ActionEvent event) {
        ProgramaPrincipal.mostrarVentanaSecundaria();
    }
 
    public void setProgramaPrincipal(InterfazProyectoFinal ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
