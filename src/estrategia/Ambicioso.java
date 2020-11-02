package estrategia;

import juego.Carta;

public class Ambicioso extends Jugador  {


	public Ambicioso(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	
	public Ambicioso (Jugador jugador)
	{
		super(jugador);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		
		return (carta.getAtributoMayor());
		
	}

}
