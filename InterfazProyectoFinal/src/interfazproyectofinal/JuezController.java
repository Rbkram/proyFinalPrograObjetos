/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazproyectofinal;
import javafx.scene.control.TableCell;
import Gestores.Gestor_Caso;
import Gestores.Gestor_Querellante;
import Objetos.Caso;
import Objetos.Querellante;
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Olman
 */
public class JuezController implements Initializable {
    private Stage stagePrincipal;
    Gestor_Caso gestorCaso = new Gestor_Caso();
    Gestor_Querellante gestorQuerellante = new Gestor_Querellante();
    ObservableList<Caso> data;
    
    
    @FXML
    private  TableView<Caso> table = new TableView<>();
    
    
    @FXML 
    private TextField txtCedulaJuez;
    
    @FXML 
    private Label txtCasoPorModificar;
    
    @FXML 
    private Label idEstadoActual;
    
    @FXML 
    private ComboBox cbEstadosPorAsignar;
    
    @FXML 
    private Label txtEstadoModificacion;
    
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    } 
    
    private void asignarValoresAlCombo(Caso casoACambiar){
       String idCasoACambiar = casoACambiar.getNumeroCaso();
       String estadoActualDelCaso = casoACambiar.getEstado();
               
       txtCasoPorModificar.setText(idCasoACambiar);
       idEstadoActual.setText(estadoActualDelCaso);
       
            switch(estadoActualDelCaso) {
            
            case "Recibido":
                cbEstadosPorAsignar.getItems().addAll("Aceptado","Consulta","Rechazado");
            break;
            
            case "Consulta":
                cbEstadosPorAsignar.getItems().addAll("Aceptado","Rechazado");
            break;
            
            case "Aceptado":
                cbEstadosPorAsignar.getItems().addAll("Redactado", "Consulta");
            break;
            
            case "Redactado":
                cbEstadosPorAsignar.getItems().addAll("Resuelto", "Revision");
            break;
            
            case "Revision":
                cbEstadosPorAsignar.getItems().addAll("Redactado");
            break;
            default:
                
            break;
            
        }
       
       
    } 

    @FXML private void guardarNuevoEstado() throws Exception
    {

        try{
            Object value = cbEstadosPorAsignar.getValue();
            gestorCaso.modificarEstado(txtCasoPorModificar.getText(),value.toString());
            txtEstadoModificacion.setText("Modificación realizada"); 
            clear();

        }catch (Exception e){
            out.println(e.getMessage());
        }
    }  
    
    public void clear() throws Exception{
       txtCasoPorModificar.setText("");
       idEstadoActual.setText("");
       cbEstadosPorAsignar.getItems().clear();
       mostrarCasosJuez();
    }
    
    
    @FXML private void mostrarCasosJuez() throws Exception
    { 
        ArrayList<Caso> listaCasos;
        listaCasos = gestorCaso.listarCasosJuez(txtCedulaJuez.getText());
        
        for (int i = 0; i < listaCasos.size(); i++) {
            String idQuerellante;
            Querellante querellanteEncontrado = new Querellante();
            idQuerellante = listaCasos.get(i).getQuerellante_aCargo_Id();
            querellanteEncontrado = gestorQuerellante.buscarObjQuerellante(idQuerellante);
            listaCasos.get(i).setQuerellante_aCargo_Id(querellanteEncontrado.getNombre());
        }

        data = FXCollections.observableArrayList(listaCasos); 
        TableColumn primeraColumna = new TableColumn("Número Caso");
        primeraColumna.setMinWidth(100);
        primeraColumna.setCellValueFactory(
                new PropertyValueFactory<>("numeroCaso"));
 
        TableColumn segundaColumna = new TableColumn("Estado del Caso");
        segundaColumna.setMinWidth(100);
        segundaColumna.setCellValueFactory(
                new PropertyValueFactory<>("estado"));
        
        TableColumn terceraColumna = new TableColumn("Querellante");
        terceraColumna.setMinWidth(140);
        terceraColumna.setCellValueFactory(
                new PropertyValueFactory<>("querellante_aCargo_Id"));
        
        
        table.setItems(data);
        table.getColumns().addAll(primeraColumna, segundaColumna, terceraColumna);  
        addButtonToTable();
    }  
    
    public void addButtonToTable () {
        TableColumn<Caso, Void> colBtn = new TableColumn("Cambiar Estado");

        Callback<TableColumn<Caso, Void>, TableCell<Caso, Void>> cellFactory = new Callback<TableColumn<Caso, Void>, TableCell<Caso, Void>>() {
            @Override
            public TableCell<Caso, Void> call(final TableColumn<Caso, Void> param) {
                final TableCell<Caso, Void> cell = new TableCell<Caso, Void>() {

                    private  Button btn = new Button("Cambiar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Caso data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                            asignarValoresAlCombo(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
