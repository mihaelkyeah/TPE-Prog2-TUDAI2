package estrategia;

import juego.Atributo;
import juego.Carta;
import java.util.ArrayList;

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
		
		ArrayList<String> nombres = carta.getNombresAtributos();
		String nombre = "";
		int aux = -1;
		for (String nombreAtributo: nombres)
			if (carta.getValor(nombreAtributo) > aux) {
				nombre = nombreAtributo;
				aux = carta.getValor(nombreAtributo);
			}
		return nombre;
		
		// return (carta.getAtributoMayor());
		
	}

}
