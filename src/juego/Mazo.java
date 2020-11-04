package juego;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import pocima.Pocima;

public class Mazo {
	
	protected ArrayList<Carta> mazo = new ArrayList<Carta> ();
	
	// Devuelve un número al azar con respecto a los índices disponibles en el mazo
	public int posicionAzar() {
		return (int) (Math.random()*this.mazo.size());
	}
	
	public int getTamanioMazo() {
		return mazo.size();
	}
	
	public void crearMazo(String jsonFile)
    {
        //AQUI SE HACE LA CARGA POR ARCHIVO
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
               //Crear carta
                Carta cartaNueva = new Carta (nombreCarta);
                for (String nombreAtributo:atributos.keySet())
                { //Agregar atributos a la carta
                    Atributo nuevoAtributo = new Atributo (nombreAtributo, atributos.getInt(nombreAtributo));
                    cartaNueva.agregarAtributo(nuevoAtributo);
                }
            //Agregar carta al mazo
                if (this.mazo.size() == 0)
                     this.agregarCartaAlMazo(cartaNueva);
                else
                    {
                    if (cartaNueva.validarCarta(this.mazo.get(0)))
                        this.agregarCartaAlMazo(cartaNueva);
                    }
            }

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	// Muestra todas las cartas por pantalla
	public void imprimirMazo() {
		for(Carta carta:this.mazo)
			System.out.println(carta);
		System.out.println("----------------");
	}
	
	// Agrega una carta al mazo
	public void agregarCartaAlMazo(Carta carta) {
		mazo.add(carta);
	}
	
	// Saca una carta del mazo como se sacaría en la vida real
	// (sacándola en vez de copiarla)
	public Carta sacarCartaDelMazo() {
		Carta aux = mazo.get(0);
		mazo.remove(0);
		return (aux);
	}
	
	// Se buscan dos índices al azar y se intercambian las cartas entre esas dos posiciones,
	// tantas veces como cartas haya en el mazo
	public void mezclarMazo() {
		Collections.shuffle(this.mazo);
	}

	// Agrega una por una todas las cartas de un mazo a este mazo
	public void agregarMazo(Mazo mazoAgregar) {		
		for (Carta carta : mazoAgregar.mazo) {
			this.agregarCartaAlMazo(carta);
		}
	}

	public void borrarMazo() {
		this.mazo.clear();
	}
	
}
