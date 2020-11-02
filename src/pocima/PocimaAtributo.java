package pocima;

import juego.Atributo;
import juego.Carta;

//Esta clase solo debe invocarse en caso que este jugando con un atributo especifico
public class PocimaAtributo extends Pocima {
	
	private double valor;
	private String atributo;
	public PocimaAtributo(String nombre, double valor, String atributo) {
		super(nombre);
		this.valor = valor;
		this.atributo = atributo;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}
	
	@Override
	public int alterarCarta(Carta carta) {
		// TODO Auto-generated method stub
		/*Atributo aux = carta.getAtributo(this.getNombre());
		if (aux != null)
		{	aux.setValor((int)(this.valor *aux.getValor()));
			carta.agregarAtributo(aux);
		}
	
	*/
		Atributo aux = carta.getAtributo(this.getNombre());
		return (int)(this.valor*= aux.getValor());
		// carta.getAtributo(this.getNombre()).setValor((int)this.valor);
	
	}

}
