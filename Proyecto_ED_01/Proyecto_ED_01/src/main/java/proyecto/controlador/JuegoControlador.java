package proyecto.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import static javax.swing.JOptionPane.showMessageDialog;
import static proyecto.controlador.Aplicacion.PATH_VIEW_INICIO;
import proyecto.modelo.Juego;
import proyecto.modelo.Tablero;


/**
 * FXML Controller class
 *
 * @author Lea
 */
public class JuegoControlador  implements Initializable{
    
    
    @FXML
    private Label lbl_turno;
    @FXML
    private Label lbl_jugador;
    @FXML
    private Button A1;
    @FXML
    private Button A2;
    @FXML
    private Button A3;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button C1;
    @FXML
    private Button C2;
    @FXML
    private Button C3;
    
    Button[][] botones;
    JuegoControlador juego;
    private Juego nuevo;
    private String primero;
    private String jugador;
    private String marcaCompu;
    private String marcaJugador;
    private boolean isOver;
    Tablero tablero;
    @FXML
    private Line lnD2;
    @FXML
    private Line lnD1;
    @FXML
    private Line lnF1;
    @FXML
    private Line lnF2;
    @FXML
    private Line lnF3;
    @FXML
    private Line lnC1;
    @FXML
    private Line lnC2;
    @FXML
    private Line lnC3;
    /**
     * Initializes the controller class.
     * @param url Recibe una url implícita de FXML para construir la clase.
     * @param rb Recibe un ResourseBundle de parte de FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        juego = this;
        Button[][] bt = {{A1,B1,C1},{A2,B2,C2},{A3,B3,C3}};
        botones = bt;
        if(primero.equalsIgnoreCase("Computadora"))
            tablero = new Tablero(marcaCompu);
        else
            tablero = new Tablero(marcaJugador);
        isOver = false;
    }  
    
    public void recibeParametros(String jugador,String marca,String primero){
        if(primero.equalsIgnoreCase("Computadora"))
            lbl_jugador.setText("Computadora");
        else
            lbl_jugador.setText(jugador);
        this.jugador = jugador;
        this.marcaCompu = marca.equals("X")?"O":"X";
        this.marcaJugador = marca.equals("X")?"X":"O";
        
    }
    
    /*public void cargarJuego(){
        lbl_turno.setText(String.valueOf(nuevo.getTurnos()));
        if ((nuevo.getTurnos() % 2) == 0){
            if(nuevo.isPrimero()){
                lbl_jugador.setText(nuevo.getJugador2());
            } else {
                lbl_jugador.setText(nuevo.getJugador1());
            }
        } else {
            if(nuevo.isPrimero()){
                lbl_jugador.setText(nuevo.getJugador1());
            } else {
                lbl_jugador.setText(nuevo.getJugador2());
            }
        }
        ArrayList<String> lista = nuevo.getFila1();
        A1.setText(lista.get(0));
        B1.setText(lista.get(1));
        C1.setText(lista.get(2));
        lista = nuevo.getFila2();
        A2.setText(lista.get(0));
        B2.setText(lista.get(1));
        C2.setText(lista.get(2));
        lista = nuevo.getFila3();
        A3.setText(lista.get(0));
        B3.setText(lista.get(1));
        C3.setText(lista.get(2));
        A1.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            A1.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            A1.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        B1.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            B1.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            B1.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        C1.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            C1.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            C1.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        A2.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            A2.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            A2.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        B2.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            B2.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            B2.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        C2.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            C2.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            C2.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        A3.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            A3.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            A3.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        B3.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            B3.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            B3.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        C3.setOnAction(e -> {
            Juego game = new Juego();
            game.reemplazarJuego(nuevo);
            ArrayList<String> fila = game.getFila1();
            String boton = "";
            if (((nuevo.getTurnos()) % 2) == 0){
                if(nuevo.isPrimero()){
                    boton = "X";
                } else {
                    boton = "O";
                }
            } else {
                if(nuevo.isPrimero()){
                    boton = "O";
                } else {
                    boton = "X";
                }
            }
            C3.setText(boton);
            fila.set(0, boton);
            game.setFila1(fila);
            nuevo.reemplazarJuego(game);
            C3.setDisable(true);
            nuevo.aumentarTurnos();
            cargarJuego();
        });
        if(nuevo.consultarGano()){
            if (((nuevo.getTurnos()-1) % 2) == 0){
                if(nuevo.isPrimero()){
                    showMessageDialog(null, nuevo.getJugador2() + " ha ganado.");
                } else {
                    showMessageDialog(null, nuevo.getJugador1() + " ha ganado.");
                }
            } else {
                if(nuevo.isPrimero()){
                    showMessageDialog(null, nuevo.getJugador1() + " ha ganado.");
                } else {
                    showMessageDialog(null, nuevo.getJugador2() + " ha ganado.");
                }
            }
            A1.setDisable(true);
            B1.setDisable(true);
            C1.setDisable(true);
            A2.setDisable(true);
            B2.setDisable(true);
            C2.setDisable(true);
            A3.setDisable(true);
            B3.setDisable(true);
            C3.setDisable(true);
            btn_rendirse.setText("volver al inicio");
            btn_rendirse.setOnAction(e -> {
                try {
                    Aplicacion.setRoot(PATH_VIEW_INICIO);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            
        }
    }*/
    
    private void rendirse(ActionEvent event) throws IOException , IndexOutOfBoundsException {
        showMessageDialog(null, "This is so sad, Alexa, play Despacito. Qué pena que te rindas...");
        Aplicacion.setRoot(PATH_VIEW_INICIO);
    }
    
    private void comprobarJuego(){
        for (int i = 0; i < 3; i++) {
            if(this.botones[i][0].getText().equals(this.botones[i][2].getText()) && this.botones[i][0].getText().equals(this.botones[i][2].getText())){
                this.isOver = true;
                switch (i) {
                    case 0:
                        this.lnF1.setVisible(isOver);
                        break;
                    case 1:
                        this.lnF2.setVisible(isOver);
                        break;
                    case 2:
                        this.lnF3.setVisible(isOver);
                        break;
                    default:
                        break;
                }
            }
            else if(this.botones[0][i].getText().equals(this.botones[2][i].getText()) && this.botones[0][i].getText().equals(this.botones[2][i].getText())){
                this.isOver = true;
                switch (i) {
                    case 0:
                        this.lnC1.setVisible(isOver);
                        break;
                    case 1:
                        this.lnC2.setVisible(isOver);
                        break;
                    case 2:
                        this.lnC3.setVisible(isOver);
                        break;
                    default:
                        break;
                }
                
            }                
        }
        if(this.botones[0][0].getText().equals(this.botones[1][1].getText()) && this.botones[0][0].getText().equals(this.botones[2][2].getText())){
            this.isOver = true;
            this.lnD1.setVisible(isOver);
        }else if(this.botones[0][2].getText().equals(this.botones[1][1].getText()) && this.botones[0][2].getText().equals(this.botones[2][0].getText())){
            this.isOver = true;
            this.lnD2.setVisible(isOver);
        }
    }
    
    class juegoComputadora implements Runnable{
        @Override
        public void run() {
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
