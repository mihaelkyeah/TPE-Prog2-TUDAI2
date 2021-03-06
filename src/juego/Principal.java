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

// TPE Programaci�n 2 - TUDAI Lober�a 2020 (A�o 2 Cuatrimestre 1)

// Integrantes:
//	Selene Rodrigo (selene.rodrigo@alumnos.exa.unicen.edu.ar)
//	Francisco Hern�ndez (fh.franhernandez.92@gmail.com)

// Repositorio del proyecto:
//	https://github.com/mihaelkyeah/TPE-Prog2-TUDAI2

public class Principal {

    public static void main(String[] args) {
    	
        String mazoPath = "./autos.json";
        Mazo mazoAux = Principal.crearMazo(mazoPath);
        
        List<Pocima> listaPocimas = new ArrayList<>();
        Jugador jugador1 = new Jugador("Ricardo Montaner");
        Jugador jugador2 = new Jugador("Sergio Denis");
        
        jugador1.setEstrategia(new EstrategiaTimbero());
        jugador2.setEstrategia(new EstrategiaTimbero());
        
        Juego juego = new Juego(jugador1,jugador2,mazoAux);
		
		Pocima pocima1 = new PocimaPorcentaje("Pocion Reductora",0.50);
		Pocima pocima2 = new PocimaSeteo("Numero M�gico",23);
		Pocima pocima3 = new PocimaPorcentaje("Pocion Aumentadora",1.25);
		Pocima pocima4 = new PocimaPorcentaje("Pocion Aumentadora m�s polenta",2.25);
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
       	
       	juego.ronda(6);
       	
    	for(String s:juego.getLog())
    		System.out.println(s);
    }
    
    //Crea un mazo a partir de la direccion a un archivo Json
    public static Mazo crearMazo(String jsonFile) {
      
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
                // Crea una carta
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
