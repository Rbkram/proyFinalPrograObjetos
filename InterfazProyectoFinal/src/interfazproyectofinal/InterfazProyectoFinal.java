/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazproyectofinal;

import java.io.IOException;
import static java.lang.System.out;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Objetos.*;
import static java.lang.System.out;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 *
 * @author Olman
 */
public class InterfazProyectoFinal extends Application {
    
    private Stage stagePrincipal;
    private AnchorPane rootPane;    
    
        // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));    
    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();
 
    }
    
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(InterfazProyectoFinal.class.getResource("FXMLDocument.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Ventana Principal");
            stagePrincipal.setScene(scene);
            FXMLDocumentController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }
    

    public void vistaJuez() {
        try {
            FXMLLoader loader = new FXMLLoader(InterfazProyectoFinal.class.getResource("juez.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            JuezController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();

        } catch (Exception e) {
            out.println(e.getMessage());
        }   
    }    
    
     public void vistaQuerellante() {
        try {
            FXMLLoader loader = new FXMLLoader(InterfazProyectoFinal.class.getResource("querellante.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            QuerellanteController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();

        } catch (Exception e) {
            out.println(e.getMessage());
        }   
    }     
    
    public void mostrarRegistrarCasos() {
        try {
            FXMLLoader loader = new FXMLLoader(InterfazProyectoFinal.class.getResource("RegistroCasos.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            RegistroCasosController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();

        } catch (Exception e) {
        }   
    }
    
    public void vistaLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(InterfazProyectoFinal.class.getResource("inicioSesion.fxml"));
            AnchorPane ventanaTres = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Tres");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaTres);
            ventana.setScene(scene);
            InicioSesionController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();

        } catch (Exception e) {
        }   
    }    
     
    public static void main(String[] args) {
        launch(args);
    }    

    
}
