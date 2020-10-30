package pocima;

import juego.Atributo;
import juego.Carta;

public class PocimaCarta extends Pocima  {

	public PocimaCarta(String nombre, Object valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alterarCarta(Carta carta) {
		// TODO Auto-generated method stub	
		for (Atributo atributo : carta.getAtributos())
		{
			atributo.setValor(this.getValor());
			carta.agregarAtributo(atributo);
		}
	}

}
