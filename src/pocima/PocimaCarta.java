package pocima;

import juego.Carta;

public class PocimaCarta extends Pocima {

	private double valor;
	private String criterio;
	
	public PocimaCarta(String nombre, double valor, String criterio) {
		super(nombre);
		this.valor=valor;
		this.criterio = criterio;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}
	@Override
	public int alterarCarta(Carta carta) {
		// TODO Auto-generated method stub	
		
		for (int i=0; i < carta.cantidadAtributos(); i++)
		{//A cada atributo le inserto el valor;
			/*
			if(this.criterio.equalsIgnoreCase("porcentaje"))
				return this.alterarPorcentaje(carta,i);
			return this.alterarValorArbitrario(carta,i);
			*/
		}
		// TODO reimplementar
		return 0;
	}
	
	private int alterarPorcentaje(Carta carta, int i) {
		return (int)(this.valor * carta.getAtributo(i).getValor());
	}
	
	private int alterarValorArbitrario(Carta carta, int i) {
		return (int)(this.valor + carta.getAtributo(i).getValor());
	}

}
