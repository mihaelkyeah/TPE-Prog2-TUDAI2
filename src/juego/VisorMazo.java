package juego;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import estrategia.Jugador;
import estrategia.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;


public class VisorMazo { //futuro Main TT.TT


    public static void main(String[] args) {
        String mazoPath = "./superheroes.json";
        Mazo mazoAux = new Mazo();
        mazoAux.crearMazo(mazoPath);
        Jugador jugador1 = new Timbero ("jugador 1");
        Jugador jugador2 = new Ambicioso("jugador 2");
        
        Juego juego = new Juego(mazoPath);
        juego.agregarJugador(jugador1);
       juego.agregarJugador(jugador2);
       /*   juego.imprimirMazo();
        try {
        	System.out.println("Presione una tecla para continuar...");
        	System.in.read();
        }
        catch(Exception e) {
        	System.out.println(e);
        }*/
        // jugador1 = new Ambicioso(jugador1);
        juego.repartirCartas();
        juego.Ronda();

    }

}
