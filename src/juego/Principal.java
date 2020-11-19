package juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import estrategia.*;
import pocima.*;

// TPE Programación 2 - TUDAI Lobería 2020 (Año 2 Cuatrimestre 1)

// Integrantes:
//	Selene Rodrigo (selenerodrigo@alumnos.unicen.edu.ar)
//	Francisco Hernández (fh.franhernandez.92@gmail.com)

// Repositorio del proyecto:
//	https://github.com/mihaelkyeah/TPE-Prog2-TUDAI2

public class Principal {

    public static void main(String[] args) {
    	
        String mazoPath = "./autos.json";
        Mazo mazoAux = Principal.crearMazo(mazoPath);
        
        ArrayList <Pocima> listaPocimas = new ArrayList <Pocima>();
        Jugador jugador1 = new Jugador("Ricardo Montaner");
        Jugador jugador2 = new Jugador("Sergio Denis");
        
        /*
        jugador1.setEstrategia(new EstrategiaObstinado("Km/h"));
        jugador2.setEstrategia(new EstrategiaObstinado("HP"));
        jugador3.setEstrategia(new EstrategiaObstinado("Cilindros"));
        jugador4.setEstrategia(new EstrategiaTimbero());
        */
        jugador1.setEstrategia(new EstrategiaObstinado("HP"));
        jugador2.setEstrategia(new EstrategiaAmbicioso());
        
        Juego juego = new Juego(jugador1,jugador2,mazoAux);
		
		Pocima pocima1 = new PocimaPorcentaje("Pocion Reductora",0.50,"Km/h");
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
       	
       	juego.ronda();
       	
       	List<String> registro = juego.getLog();
    	for(String s:registro)
    		System.out.println(s);
    }
    
    public static Mazo crearMazo(String jsonFile) {
        //AQUI SE HACE LA CARGA POR ARCHIVO
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        Mazo mazoNuevo = new Mazo();
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                // Crear carta
                Carta cartaNueva = new Carta (nombreCarta);
                // Agregar atributos a la carta
                for (String nombreAtributo:atributos.keySet()) {
                    cartaNueva.agregarAtributo(nombreAtributo, atributos.getInt(nombreAtributo));
                }
                // Agregar carta al mazo
                mazoNuevo.agregarCartaAlMazo(cartaNueva);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mazoNuevo;
    }
    
}
