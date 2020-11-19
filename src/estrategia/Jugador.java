package estrategia;

import juego.Carta;

import juego.Mazo;


public class Jugador {

	private String nombre;
	private Mazo mazoJugador;
	private Estrategia estrategia;
	
	public Jugador(String nombre, Estrategia estrategia) {
		this.nombre = nombre;
		this.estrategia = estrategia;
		this.mazoJugador = new Mazo();
	}
	
	// Asigna la estrategia ambicioso por defecto
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.estrategia = new EstrategiaAmbicioso();
		this.mazoJugador = new Mazo();
	}

	//Devuelve el nombre del atributo que el jugador elige para competir segun su estrategia
	public String getAtributoJuego() {
		return (this.estrategia.elegirAtributo(this.mazoJugador.topeMazo()) );
	}
	
	//Devuelve cuantas cartas quedan en el mazo del jugador
	public int getCantidadCartas() {
		return (this.mazoJugador.getTamanioMazo());
	}
	
	public void setEstrategia(Estrategia e) {
		this.estrategia = e;
	}
	
	//Devuelve la carta que el jugador saca de su mazo para jugar
	public Carta cartaEnMano() {
		return this.mazoJugador.sacarCartaDelMazo();
	}
	
	//Agrega una carta al mazo del jugador
	public void recibirCarta(Carta carta) {
		this.mazoJugador.agregarCartaAlMazo(carta);
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
}