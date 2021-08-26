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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Joyce
 */
public class OpcionesControlador implements Initializable {


    @FXML
    private ComboBox<String> cbPrimero;
    @FXML
    private ComboBox<String> cbMarca;
    @FXML
    private TextField txtJugador;
    @FXML
    private Button btnEmpezar;
    @FXML
    private Button btnRegresar;
    
    OpcionesControlador opc;
    @FXML
    private Label lblNo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbPrimero.getItems().addAll("Jugador","Computadora");
        cbMarca.getItems().addAll("X","O");
        opc = this;
    }    
    
    @FXML
    private void quienEmpieza(ActionEvent event) {
        
    }

    @FXML
    private void elegirMarca(ActionEvent event) {
    }

    @FXML
    private void empezar(ActionEvent event) {
        if(this.txtJugador.getText().trim().isEmpty()){
            this.lblNo.setVisible(true);
            this.lblNo.setText("Falta el nombre del jugador");
        }else if(cbPrimero.getValue() == null){
            this.lblNo.setVisible(true);
            this.lblNo.setText("Debe elegir quien empieza");
        }else if(cbMarca.getValue()  == null){
            this.lblNo.setVisible(true);
            this.lblNo.setText("Debe elegir la marca");
        }else{
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/juego.fxml"));
                Parent root = loader.load();
                JuegoControlador controlador = loader.getController();
                controlador.recibeParametros(this.txtJugador.getText(), cbMarca.getValue(), cbPrimero.getValue());
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                scene.getWindow().setX(0);
                stage.show();
                Stage myStage = (Stage) this.btnEmpezar.getScene().getWindow();
                myStage.close();
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }   
        }
            
    }

    @FXML
    private void regresar(ActionEvent event) {
    }

}
