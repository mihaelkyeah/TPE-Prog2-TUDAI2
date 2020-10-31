package pocima;

import juego.Atributo;
import juego.Carta;

//Esta clase solo debe invocarse en caso que este jugando con un atributo especifico
public class PocimaAtributo extends Pocima {
	private double valor;
	public PocimaAtributo(String nombre, double valor) {
		super(nombre);
		this.valor = valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}
	
	@Override
	public void alterarCarta(Carta carta) {
		// TODO Auto-generated method stub
		Atributo aux = carta.getAtributo(this.getNombre());
		aux.setValor((int) this.valor);
		carta.agregarAtributo(aux);
	}

}
