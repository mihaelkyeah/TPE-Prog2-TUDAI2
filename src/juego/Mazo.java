package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
	
	protected List<Carta> mazo;
	
	public Mazo() {
		mazo = new ArrayList<>();
	}
	
	// Devuelve un número al azar con respecto a los índices disponibles en el mazo
	public int posicionAzar() {
		return (int) (Math.random()*this.mazo.size());
	}
	
	public int getTamanioMazo() {
		return mazo.size();
	}
	
	// Muestra todas las cartas por pantalla
	public void imprimirMazo() {
		for(Carta carta:this.mazo)
			System.out.println(carta);
		System.out.println("----------------");
	}
	
	// Agrega una carta al mazo
	public void agregarCartaAlMazo(Carta carta) {
		if(this.getTamanioMazo() == 0 || carta.validarCarta(mazo.get(0)))
			mazo.add(carta);
	}
	
	// Saca una carta del mazo como se sacaría en la vida real
	// (sacándola en vez de copiarla)
	public Carta sacarCartaDelMazo() {
		Carta aux = mazo.get(0);
		mazo.remove(0);
		return (aux);
	}
	
	public Carta topeMazo() {
		if(mazo.size()>0)
			return mazo.get(0);
		return null;
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
