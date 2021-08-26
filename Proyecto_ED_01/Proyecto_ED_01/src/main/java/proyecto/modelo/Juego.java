/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.modelo;

import Listas.ArrayList;

/**
 *
 * @author Lea
 */
public class Juego {
    
    private String jugador1;
    private String jugador2;
    private boolean primero;
    private int turnos;
    
    public Juego() {
    }

    
    public Juego(String jugador1, String jugador2, String primero) {
        
        turnos = 1;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.primero = primero.equals("true");
    }


    
    public int getTurnos() {
        return turnos;
    }
    public void aumentarTurnos(){
        turnos += 1;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public boolean isPrimero() {
        return primero;
    }

    public void setPrimero(boolean primero) {
        this.primero = primero;
    }
    public void reemplazarJuego(Juego game){
        this.jugador1 = game.getJugador1();
        this.jugador2 = game.getJugador2();
        this.primero = game.isPrimero();
        this.turnos = game.getTurnos();
    }
    
    
    
    
    public boolean consultarGano(){
        return false;
    }
    
}
