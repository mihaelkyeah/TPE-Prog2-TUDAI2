package estrategia;

import juego.Carta;

public class Obstinado extends Jugador  {

	private String atributoJugando;
	
	public Obstinado(String nombre, String atributoJugando) {
		super(nombre);
		this.atributoJugando = atributoJugando;
	}
	
	public Obstinado (Jugador jugador, String atributoJugando)
	{
		super(jugador);
		this.atributoJugando = atributoJugando;
	}

	@Override
	public String elegirAtributo(Carta carta) {
		// TODO Auto-generated method stub
		return this.atributoJugando;
	}

}
