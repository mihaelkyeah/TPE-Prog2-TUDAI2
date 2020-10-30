package estrategia;

import juego.Carta;

public class Obstinado extends Jugador  {

	private String atributoJugando;
	
	public Obstinado(String nombre, String atributoJugando) {
		super(nombre);
		this.atributoJugando = atributoJugando;
	}
	
	public Obstinado (Jugador jugador)
	{
		super(jugador);
	}

	@Override
	public void jugarCarta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jugador cambiarEstrategia(Jugador jugador) {
		// TODO Auto-generated method stub
		Obstinado nuevaEstrategia = new Obstinado(jugador);
		return (nuevaEstrategia);
	}


	@Override
	public String elegirAtributo(Carta carta) {
		// TODO Auto-generated method stub
		return this.atributoJugando;
	}

}
