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
	public Jugador cambiarEstrategia(Jugador jugador) {
		// TODO Auto-generated method stub
		Timbero nuevaEstrategia = new Timbero(jugador);
		return (nuevaEstrategia);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		// TODO Auto-generated method stub
		int opcion = (int) (Math.random()* carta.cantidadAtributos());
		return (carta.getAtributo(opcion).getNombre());
			
	}

}