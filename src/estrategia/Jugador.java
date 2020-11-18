package estrategia;

import juego.Carta;

import juego.Mazo;


public class Jugador {

	private String nombre;
	// private Mazo mazoJugador;
	private Estrategia estrategia;
	
	public Jugador(String nombre, Estrategia estrategia) {
		this.nombre = nombre;
		this.estrategia = estrategia;
	}

	public String elegirAtributoJugada(Carta carta) {
		return this.estrategia.elegirAtributo(carta);
	}
	
}