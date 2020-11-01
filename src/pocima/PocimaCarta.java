package pocima;

import juego.Carta;

public class PocimaCarta extends Pocima {

	private double valor;
	public PocimaCarta(String nombre, double valor) {
		super(nombre);
		this.valor=valor;
		// TODO Auto-generated constructor stub
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}
	@Override
	public void alterarCarta(Carta carta) {
		// TODO Auto-generated method stub	
		
		for (int i=0; i < carta.cantidadAtributos(); i++)
		{//A cada atributo le inserto el valor;
			carta.getAtributo(i).setValor((int)(this.valor *carta.getAtributo(i).getValor()));
		}
	}

}
