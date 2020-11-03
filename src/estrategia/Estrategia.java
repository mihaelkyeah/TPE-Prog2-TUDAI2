package estrategia;

import juego.Carta;

public abstract class Estrategia {
	
	private String nombre;
	
	public Estrategia(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String elegirAtributo(Carta carta);
	
	@Override
	public String toString() {
		return ("Estrategia: "+this.nombre);
	}

}
