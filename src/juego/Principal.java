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

// TODO: Separar estrategias de jugador (que la estrategia sea un atributo del jugador)
		// HECHO :D
// TODO: Pócimas: alterarCarta -> cambiar a alterarAtributo y recibir int valor, String nombreAtributo
		// HECHO :D 
// TODO: Sacar de la clase Carta el getAtributoMayor() <- cambiarlo por un getAtributo con criterio?
		//
// TODO: Agregar a Carta un getNombresAtributos que devuelva un ArrayList<String> con todos los nombres de los atributos de la carta

// TODO: Cambiar estrategias acorde a la utilización del getNombresAtributos

// TODO: Probar Collections.shuffle(mazo) en el mazo
		// 

public class Principal {


    public static void main(String[] args) {
    	
    	//TODO: JUGADOR AMBICIOSO (opcional): si tiene una pócima que disminuye el valor del atributo, no la usa
    	
        String mazoPath = "./superheroes.json";
        Mazo mazoAux = new Mazo();
        mazoAux.crearMazo(mazoPath);
        
        ArrayList <Pocima> listaPocimas = new ArrayList <Pocima>();
        Jugador jugador1 = new Jugador("jugador 1");
        Jugador jugador2 = new Jugador("jugador 2");
        Jugador jugador3 = new Jugador("jugador 3");
        Jugador jugador4 = new Jugador("jugador 4");
        Jugador jugador5 = new Jugador("jugador 5");
        
        jugador1.setEstrategia(new EstrategiaObstinado("fuerza"));
        jugador2.setEstrategia(new EstrategiaObstinado("velocidad"));
        jugador3.setEstrategia(new EstrategiaObstinado("altura"));
        jugador4.setEstrategia(new EstrategiaTimbero());
        jugador5.setEstrategia(new EstrategiaAmbicioso());
        
        Juego juego = new Juego(mazoPath);
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
		juego.agregarJugador(jugador3);
		juego.agregarJugador(jugador4);
		juego.agregarJugador(jugador5);
		
		juego.imprimirMazo();
		try {
        	System.out.println("Presione una tecla para continuar...");
        	System.in.read();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
       
		Pocima pocima1 = new PocimaPorcentaje("Pocion Reductora",0.50,"fuerza");
		Pocima pocima2 = new PocimaSeteo("Numero Mágico",23);
		Pocima pocima3 = new PocimaPorcentaje("Pocion Aumentadora",1.25);
		Pocima pocima4 = new PocimaPorcentaje("Pocion Aumentadora más polenta",2.25);
		Pocima pocimaCocktail = new PocimaCocktail("VamoAVerQueSale",pocima1,pocima3);
		Pocima pocimaCocktail2 = new PocimaCocktail("sasarasa",pocima4,pocima1);
		Pocima pocimaCocktailLoco = new PocimaCocktail("Cocktail Loco",pocimaCocktail,pocimaCocktail2);
       
		listaPocimas.add(pocima1);
		listaPocimas.add(pocima2);
		listaPocimas.add(pocima3);
		listaPocimas.add(pocimaCocktail);
		listaPocimas.add(pocimaCocktail2);
		listaPocimas.add(pocimaCocktailLoco);
       
       	juego.repartirCartas(listaPocimas);
       
       
       /*
       	Carta carta1 = mazoAux.sacarCartaDelMazo();
       	System.out.println(carta1+" "+carta1.getValor("fuerza"));
       	int resultado = pocimaCocktail.alterarCarta(carta1, "fuerza");
       	System.out.println(carta1+" "+carta1.getValor("fuerza"));
       	System.out.println(resultado);
       	resultado = pocimaCocktail2.alterarCarta(carta1, "fuerza");
       	System.out.println(resultado);
       	resultado = pocimaCocktailLoco.alterarCarta(carta1, "fuerza");
       	System.out.println(resultado);
       	try {
       		System.in.read();
       	}
       	catch(Exception e) {
       		System.out.println(e);
       	}
       	*/
       
       	juego.Ronda(8);

    }
    	
}
