/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Joyce
 */
public class InicioControlador implements Initializable {


    /**
     * Initializes the controller class.
     * @param url Recibe una url implícita de FXML para construir la clase.
     * @param rb Recibe un ResourseBundle de parte de FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void switchToJugador(ActionEvent event) throws IOException {
        Aplicacion.setRoot("/vista/opciones");
    }
    
    @FXML
    private void switchToMultijugador(ActionEvent event) throws IOException {
        Aplicacion.setRoot("/vista/multijugador");
    }
    
    @FXML
    private void cerrarJuego(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
}
