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
               this.agregarCartaAlMazo(cartaNueva);
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
	}
	
	// Verifica que todas las cartas a agregar al mazo tengan los mismos atributos que la primera
	public void validarCartas() {
		Carta primeraCarta = this.mazo.get(0); //Desde la primera carta se valida los atributos
		
		// Guarda una lista de índices para buscar las cartas del mazo para borrar
		ArrayList<Integer> cartasExtranias = new ArrayList<>();
		
		for(int i = 1; i < this.mazo.size(); i++) { // itera por todas las cartas del mazo
			Carta cartaActual = this.mazo.get(i);
			if(cartaActual.cantidadAtributos() == primeraCarta.cantidadAtributos()) { //primero se fija que coincida la cantidad de atributos, de no hacerlo ya es rechazada
				int j = 0;
				Atributo aux = cartaActual.getAtributo(j);
				while((j < cartaActual.cantidadAtributos()) && (primeraCarta.getAtributo(aux.getNombre()) != null)) { //Verifica que todos los atributos de la carta esten en la primera carta
					aux = cartaActual.getAtributo(j);
					j++;
				}
				if(j < cartaActual.cantidadAtributos()) { //Si no los encontro a todos es rechazada
					cartasExtranias.add(i);
				}
			}
			else
				cartasExtranias.add(i);
		}
		
		for(int i = 0; i < cartasExtranias.size(); i++) {
			this.mazo.remove((int)cartasExtranias.get(i));
		}
			
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
		/*
		for (int i = 0; i < mazo.size() ; i++)
		{
			int posOrigen = posicionAzar();
			int posDestino = posicionAzar();
			Carta aux = mazo.get(posDestino);
			mazo.set(posDestino, mazo.get(posOrigen));
			mazo.set(posOrigen, aux);
		}
		*/
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

	// Reparte las pócimas entre las cartas del mazo
	public void repartirPocimas(ArrayList<Pocima> listaPocimas) {
		while (listaPocimas.size() > this.getTamanioMazo())
			listaPocimas.remove(0);	//Verifico que la cantidad de pocimas no supere la cantidad de cartas, si supera comienzo a eliminar desde la primera pocima
		
		while (listaPocimas.size() > 0)   //Mientras tenga pocimas por repartir
		{
			int pos = posicionAzar();
			while (this.mazo.get(pos).getPocima() != null)   //Me aseguro de llegar a una posicion donde se pueda colocar la posima
				pos = posicionAzar();
			this.mazo.get(pos).setPocima(listaPocimas.get(0));		//Pongo la pocima
			listaPocimas.remove(0);								//Borro la pocima que ya coloque
		}
	}
	
	
	
}
