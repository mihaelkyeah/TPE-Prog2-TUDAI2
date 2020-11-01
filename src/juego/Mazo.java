package juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Mazo {
	
	protected ArrayList<Carta> mazo = new ArrayList<Carta> ();
	
	public int posicionAzar()
	{
		return (int) (Math.random()*mazo.size());
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
               this.agregarCartaAlMazo(cartaNueva);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void agregarCartaAlMazo(Carta carta)
	{
		mazo.add(carta);
		
		//agregar al azar?
		/*
		 * if (mazo.size() > 2)
				mezclarMazo();
		*/

	}
	
	public Carta sacarCartaDelMazo()
	{
		Carta aux = mazo.get(0);
		mazo.remove(0);
		return (aux);
	}
	
	public void mezclarMazo()
	{
		for (int i = 0; i < mazo.size() ; i++)
		{
			int posOrigen = posicionAzar();
			int posDestino = posicionAzar();
			Carta aux = mazo.get(posDestino);
			mazo.set(posDestino, mazo.get(posOrigen));
			mazo.set(posOrigen, aux);
		}
	}

	

	
	
	
	
}
