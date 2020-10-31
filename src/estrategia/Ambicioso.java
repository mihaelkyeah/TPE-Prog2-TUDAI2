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
	public Jugador cambiarEstrategia(Jugador jugador) {
		// TODO Auto-generated method stub
		Ambicioso nuevaEstrategia = new Ambicioso(jugador);
		return (nuevaEstrategia);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		
		return (carta.getAtributoMayor());
		
	}

}
