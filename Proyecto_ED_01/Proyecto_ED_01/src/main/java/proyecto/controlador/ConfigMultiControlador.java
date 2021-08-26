/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static javax.swing.JOptionPane.showMessageDialog;
import static proyecto.controlador.Aplicacion.PATH_ARCHIVO;
import static proyecto.controlador.Aplicacion.PATH_VIEW_INICIO;
import static proyecto.controlador.Aplicacion.PATH_VIEW_JUEGO;

/**
 *
 * @author Joyce
 */
public class ConfigMultiControlador implements Initializable{
    
    @FXML
    private TextField txtfld_jugador1;
    @FXML
    private TextField txtfld_jugador2;
    @FXML
    private ComboBox cb_inicio;
    @FXML
    private Button btn_start;
    @FXML
    private Button btn_return;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_inicio.getItems().clear();
        cb_inicio.setDisable(true);
        txtfld_jugador2.setDisable(true);
        btn_start.setDisable(true);
    } 
    @FXML
    private void readJugador1(ActionEvent event) throws IOException {
        if (!txtfld_jugador1.getText().equals("")){    
            btn_start.setDisable(true);
            txtfld_jugador2.setDisable(false);
            cb_inicio.setDisable(true);
        } else {
            showMessageDialog(null,"Ingrese un nombre");
        }
    }
    @FXML
    private void readJugador2(ActionEvent event) throws IOException {
        if (!txtfld_jugador2.getText().equals("")){
            btn_start.setDisable(true);
            cb_inicio.getItems().clear();
            cb_inicio.getItems().add(txtfld_jugador1.getText());
            cb_inicio.getItems().add(txtfld_jugador2.getText());
            cb_inicio.setDisable(false);
        } else {
            showMessageDialog(null,"Ingrese un nombre");
        }
    }
    @FXML
    private void readInicio(ActionEvent event) throws IOException {
        btn_start.setDisable(false);
        try{
            FileWriter archivo = new FileWriter(PATH_ARCHIVO + "juego.txt");
            PrintWriter nuevo = new PrintWriter (archivo);
            String boleano = "false";
            if (txtfld_jugador1.getText().equals((String)cb_inicio.getValue())){
                boleano = "true";
            }
            nuevo.println(txtfld_jugador1.getText()+","+ txtfld_jugador2.getText()+","+boleano);
            nuevo.close();
            btn_start.setDisable(false);
        } catch (NumberFormatException nge){
            nge.printStackTrace();
        }
    }
    @FXML
    private void switchToJuego(ActionEvent event) throws IOException {
        Aplicacion.setRoot(PATH_VIEW_JUEGO);
    }
    @FXML
    private void switchToInicio(ActionEvent event) throws IOException {
        Aplicacion.setRoot(PATH_VIEW_INICIO);
    }
}
