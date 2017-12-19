/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.proyectoRegCaso;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Olman
 */
public class RegistrarCasoController implements Initializable {

    @FXML
    private TextField txtNombreCaso;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField idPrueba;
    @FXML
    private TextField txtCedulaQuerellante;
    @FXML
    private Button btnBuscarQuerellante;
    @FXML
    private Button btnRegistrarCaso;
    @FXML
    private Label lbConfiQuerellante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscarQuerellantexId(ActionEvent event) {
        idPrueba.setText("Holaaaa!");
    }

    @FXML
    private void registrarCaso(ActionEvent event) {
    }
    
}
