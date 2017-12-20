/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazproyectofinal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import Gestores.*;
import Objetos.*;
import static java.lang.System.out;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Olman
 */
public class RegistroCasosController implements Initializable {

    private Stage stagePrincipal;
    Gestor_Caso gestorCaso = new Gestor_Caso();
    Gestor_Querellante gestorQuerellante = new Gestor_Querellante();
    

    @FXML
    private TextField txtNumeroCaso;
    
    @FXML
    private javafx.scene.control.TextField txtDescripcion;
    
    @FXML
    private javafx.scene.control.TextField txtCedulaQuerellante;
    
    @FXML private Label lbConfiQuerellante, lbVerificacion, txtConfirmacion;
    
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }
    
    @FXML private void buscarQuerellantexId(ActionEvent evento) throws Exception {
        Gestor_Caso gestorCaso = new Gestor_Caso();
        Gestor_Querellante gestorQuerellante = new Gestor_Querellante();
            
        Querellante querellanteEncontrado = new Querellante();
          querellanteEncontrado = gestorQuerellante.buscarObjQuerellante(txtCedulaQuerellante.getText());
        
        if (querellanteEncontrado == null) {
          lbConfiQuerellante.setText("El querellante no está registrado, por favor proceda realizar el registro");
        } else {
          lbConfiQuerellante.setText(querellanteEncontrado.getNombre());
        }
    } 
    
    @FXML private void registrarCaso() throws Exception{
        
        Querellante quere;
        boolean registrado = false;
        
        try{

           registrado = gestorCaso.ingresarCaso(txtNumeroCaso.getText(), txtDescripcion.getText(), txtCedulaQuerellante.getText());
            if (registrado) {
              txtConfirmacion.setText("Caso registrado correctamente");  
            } else {
             txtConfirmacion.setText("Datos incorrectos, por favor ingréselos nuevamente"); 
            }
        }catch (Exception e){
            out.println(e.getMessage());
        }
    }     
    
    @FXML
    private void salirVentana(ActionEvent event) {
        stagePrincipal.close();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
