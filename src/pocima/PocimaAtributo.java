package pocima;

import juego.Atributo;
import juego.Carta;

public class PocimaAtributo extends Pocima {

	public PocimaAtributo(String nombre, Object valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alterarCarta(Carta carta) {
		// TODO Auto-generated method stub
		Atributo aux = carta.getAtributo(this.getNombre());
		aux.setValor(this.valor);
		carta.agregarAtributo(aux);
	}

}
