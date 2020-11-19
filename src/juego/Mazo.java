package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
	
	protected List<Carta> mazo;
	
	public Mazo() {
		this.mazo = new ArrayList<>();
	}
	
	public int getTamanioMazo() {
		return this.mazo.size();
	}
	
	// Agrega una carta valida al mazo
	// Si es la primera carta en agregarse se la considera valida automaticamente
	public void agregarCartaAlMazo(Carta carta) {
		if(this.getTamanioMazo() == 0 || carta.validarCarta(this.topeMazo()) )
			this.mazo.add(carta);
	}
	
	//Mira la primera carta del mazo sin sacarla
	public Carta topeMazo() {
		if(this.getTamanioMazo() > 0)
			return this.mazo.get(0);
		return null;
	}
	
	// Saca y devuelve la primera carta del mazo
	public Carta sacarCartaDelMazo() {
		if(this.getTamanioMazo() > 0) {	
			Carta aux =this.mazo.get(0);
			this.mazo.remove(0);
			return (aux);
		}
		else
			return (null);
	}
	
	// Mezcla las cartas del mazo
	public void mezclarMazo() {
		Collections.shuffle(this.mazo);
	}
	
}
