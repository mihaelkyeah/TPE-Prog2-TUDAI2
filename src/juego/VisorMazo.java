package juego;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

// import com.sun.tools.sjavac.server.SysInfo;

import estrategia.Jugador;
import pocima.*;
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
        
        ArrayList <Pocima> listaPocimas = new ArrayList <Pocima>();
        Jugador jugador1 = new Timbero ("jugador 1");
        Jugador jugador2 = new Timbero("jugador 2");
        Jugador jugador3 = new Timbero("jugador 3");
        Jugador jugador4 = new Timbero("jugador 4");
        Jugador jugador5 = new Timbero("jugador 5");
        
        Juego juego = new Juego(mazoPath);
        juego.agregarJugador(jugador1);
       juego.agregarJugador(jugador2);
       juego.agregarJugador(jugador3);
       juego.agregarJugador(jugador4);
       juego.agregarJugador(jugador5);
       /*   juego.imprimirMazo();
        try {
        	System.out.println("Presione una tecla para continuar...");
        	System.in.read();
        }
        catch(Exception e) {
        	System.out.println(e);
        }*/
        // jugador1 = new Ambicioso(jugador1);
       
       Pocima pocima1 = new PocimaPorcentaje("pocionmagica",0.50);
       Pocima pocima2 = new PocimaSeteo("Numero Magico",23);
       Pocima pocima3 = new PocimaPorcentaje("pocionmagica",1.25);
       Pocima pocimaCocktail = new PocimaCocktail("VamoAVerQueSale",pocima1,pocima3); 
       
       listaPocimas.add(pocima1);
       listaPocimas.add(pocima2);
       listaPocimas.add(pocima3);
       listaPocimas.add(pocimaCocktail);
       
       juego.repartirCartas(listaPocimas);
       	Carta carta1 = mazoAux.sacarCartaDelMazo();
       	System.out.println(carta1+" "+carta1.getValor("fuerza"));
       	int resultado = pocimaCocktail.alterarCarta(carta1, "fuerza");
       	System.out.println(carta1+" "+carta1.getValor("fuerza"));
       	System.out.println(resultado);
       	try {
       		System.in.read();
       	}
       	catch(Exception e) {
       		System.out.println(e);
       	}
        // juego.Ronda();

    }
    	
}
