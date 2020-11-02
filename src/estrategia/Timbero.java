package estrategia;

import juego.Carta;

public class Timbero extends Jugador {

	public Timbero(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public Timbero (Jugador jugador)
	{
		super(jugador);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		int opcion = (int) (Math.random()* carta.cantidadAtributos());
		return (carta.getAtributo(opcion).getNombre());
	}

}
