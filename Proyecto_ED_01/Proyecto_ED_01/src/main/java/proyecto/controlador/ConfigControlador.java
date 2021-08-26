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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javax.swing.JOptionPane.showMessageDialog;
import static proyecto.controlador.Aplicacion.PATH_ARCHIVO;
import static proyecto.controlador.Aplicacion.PATH_VIEW_INICIO;
import static proyecto.controlador.Aplicacion.PATH_VIEW_JUEGO;

/**
 * FXML Controller class
 *
 * 
 */
public class ConfigControlador implements Initializable {

    @FXML
    private TextField txtfld_apuesta;
    @FXML
    private Label lbl_apuesta;
    @FXML
    private Button btn_start;
    @FXML
    private ComboBox cb_ruleta;
    @FXML
    private ComboBox cb_numeros;
    

    /**
     * Initializes the controller class.
     * @param url Recibe una url implícita de FXML para construir la clase.
     * @param rb Recibe un ResourseBundle de parte de FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_ruleta.getItems().clear();
        cb_ruleta.getItems().addAll("2","3","4","5");
        cb_numeros.getItems().clear();
        cb_numeros.getItems().addAll("1","2","3","4","5","6","7","8","9");
        cb_numeros.setDisable(true);
        btn_start.setDisable(true);
        txtfld_apuesta.setDisable(true);
    }    
    @FXML
    private void switchToInicio(ActionEvent event) throws IOException {
        Aplicacion.setRoot(PATH_VIEW_INICIO);
    }
    
    @FXML
    private void ruletaEscogida(ActionEvent event) throws IOException {
        cb_numeros.setDisable(false);
        btn_start.setDisable(true);
        txtfld_apuesta.setDisable(true);
    }
    @FXML
    private void readBox(ActionEvent event) throws IOException {
        btn_start.setDisable(true);
        int total = Integer.parseInt((String)cb_ruleta.getValue());
        int ingresado = Integer.parseInt((String)cb_numeros.getValue());
        lbl_apuesta.setText(String.valueOf(ingresado*9*total));
        txtfld_apuesta.setDisable(false);
    }
    @FXML // Falta la comprobación que no sea otra cosa excepto integer
    private void enterText(ActionEvent event) throws IOException ,  NumberFormatException{
        int total = Integer.parseInt((String)cb_ruleta.getValue());
        int ingresado = Integer.parseInt((String)cb_numeros.getValue());
        try{
            int apuesta = Integer.parseInt(txtfld_apuesta.getText());
            if (!((apuesta > 0) && (apuesta < (ingresado*9*total)))){
                showMessageDialog(null,"Su número debe ser menor o igual que: " + ingresado*9*total);
            } else{
                FileWriter archivo = new FileWriter(PATH_ARCHIVO + "juego.txt");
                PrintWriter nuevo = new PrintWriter (archivo);
                nuevo.println(total+","+ apuesta+","+ingresado);
                nuevo.close();
                btn_start.setDisable(false);
            }
        } catch (NumberFormatException nge){
            nge.printStackTrace();
            showMessageDialog(null,"Su número debe ser menor o igual que: " + ingresado*9*total);
            txtfld_apuesta.clear();
        }
        
        
    }
    @FXML
    private void switchToJuego(ActionEvent event) throws IOException {
        Aplicacion.setRoot(PATH_VIEW_JUEGO);
        Aplicacion.setSize(616, 860);
    }
    
    
  

}
