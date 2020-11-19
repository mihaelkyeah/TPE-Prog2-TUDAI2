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
	
	public void setEstrategia(Estrategia e) {
		this.estrategia = e;
	}

	public String elegirAtributoJugada(Carta carta) {
		return this.estrategia.elegirAtributo(carta);
	}
	
	public Carta cartaEnMano() {
		return this.mazoJugador.sacarCartaDelMazo();
	}
	
	public void recibirCarta(Carta carta) {
		this.mazoJugador.agregarCartaAlMazo(carta);
	}
	
	public String getAtributoJuego() {
		return this.elegirAtributoJugada(this.mazoJugador.topeMazo());
	}
	
	public int getCantidadCartas() {
		return (this.mazoJugador.getTamanioMazo());
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
}