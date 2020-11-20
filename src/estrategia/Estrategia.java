package estrategia;

import juego.Carta;

public abstract class Estrategia {
	
	private String nombre;
	
	public Estrategia(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devuelve el atributo por el cual va a jugar el jugador,
	 * dependiendo de cuál sea su tipo concreto de estrategia
	 * @param carta
	 * @return String
	 */
	public abstract String elegirAtributo(Carta carta);
	
	@Override
	public String toString() {
		return ("Estrategia: "+this.nombre);
	}

}
