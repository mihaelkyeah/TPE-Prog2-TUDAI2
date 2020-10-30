package pocima;

import juego.Atributo;
import juego.Carta;

public abstract class Pocima extends Atributo{
	
	public Pocima(String nombre, Object valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	public abstract void alterarCarta (Carta carta);
	
}
