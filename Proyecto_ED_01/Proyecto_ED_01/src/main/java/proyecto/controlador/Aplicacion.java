/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.controlador;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proyecto.modelo.Tablero;
import tree.Tree;
/**
 * 
 * @author Lea
 */
public class Aplicacion extends Application {
    public static final String PATH_ARCHIVO = "src/main/resources/archivos/";
    public static final String PATH_VIEW_INICIO ="/vista/menu_principal";
    public static final String PATH_VIEW_JUEGO ="/vista/juego";
    
    private static Scene scene;
    
    @Override
    public void start(Stage primaryStage){
        try{
            scene = new Scene(loadFXML("/vista/menu_principal"));
            primaryStage.setScene(scene);
            primaryStage.show();     
        }catch(IOException e){
            e.getLocalizedMessage();

        }
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
      public static void setSize(int x, int y) throws IOException {
        ((Stage)scene.getWindow()).setHeight(y);
        ((Stage)scene.getWindow()).setWidth(x);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();       
        fxmlLoader.setLocation(Aplicacion.class.getResource(fxml+".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        Tree<String> prueba = new Tree<>("1");        
        prueba.agregar("3", "1");
        prueba.agregar("10", "3");
        prueba.agregar("4", "1");
        prueba.agregar("5", "1");
        prueba.agregar("5", "4");
        prueba.agregar("6", "4");
        prueba.mostrarArbol();
        
        
        Tablero t = new Tablero("X");
        t.getTablero()[0][1] = "O";
        t.getTablero()[1][1] = "X";
        System.out.println("Utilidad "+t.calcularUtilidad());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(t.getTablero()[i][j]+" ");
            }
            System.out.println("");
        }
        launch();
    }
    
  
}