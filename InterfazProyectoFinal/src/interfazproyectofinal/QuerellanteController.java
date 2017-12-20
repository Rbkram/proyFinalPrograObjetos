/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazproyectofinal;

import Gestores.Gestor_Caso;
import Gestores.Gestor_Querellante;
import Objetos.Caso;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Olman
 */
public class QuerellanteController implements Initializable {
    private Stage stagePrincipal;
    Gestor_Caso gestorCaso = new Gestor_Caso();
    Gestor_Querellante gestorQuerellante = new Gestor_Querellante();
    ObservableList<Caso> data;
    
    @FXML
    //private TableView<String> table = new TableView<String>();
    private  TableView<Caso> table = new TableView<>();
    
    @FXML
    private TextField txtCedulaQuerellante;
    
    /**
     * Initializes the controller class.
     */
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    } 
    
    
    @FXML private void mostrarCasoQuerellante() throws Exception
    {
        ArrayList<Caso> listaCasos;
        listaCasos = gestorCaso.listarCasosQuerellante(txtCedulaQuerellante.getText());

        data = FXCollections.observableArrayList(listaCasos); 
        TableColumn primeraColumna = new TableColumn("Número Caso");
        primeraColumna.setMinWidth(100);
        primeraColumna.setCellValueFactory(
                new PropertyValueFactory<>("numeroCaso"));
 
        TableColumn segundaColumna = new TableColumn("Estado del Caso");
        segundaColumna.setMinWidth(100);
        segundaColumna.setCellValueFactory(
                new PropertyValueFactory<>("estado"));
        
        TableColumn terceraColumna = new TableColumn("Descripción del Caso");
        terceraColumna.setMinWidth(300);
        terceraColumna.setCellValueFactory(
                new PropertyValueFactory<>("descripcionCaso"));
        
        table.setItems(data);
        table.getColumns().addAll(primeraColumna, segundaColumna, terceraColumna);            
    }    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
