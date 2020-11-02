package pocima;

import juego.Atributo;
import juego.Carta;

public class PocimaPorcentaje extends Pocima{

	private double porcentaje;
	public PocimaPorcentaje(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje=porcentaje;
		// TODO Auto-generated constructor stub
	}

	public PocimaPorcentaje(String nombre, double porcentaje, String restriccion) {
		super(nombre, restriccion);
		this.porcentaje=porcentaje;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int alterarCarta(Carta carta, String atributoAfectado) {
		// TODO Auto-generated method stub
		
		if (this.getRestriccion().equals(SIN_RESTRICCION))
			return  (int)(this.porcentaje * carta.getAtributo(atributoAfectado).getValor());
		else
		{
			if (this.getRestriccion().equals(atributoAfectado))
				return  (int)(this.porcentaje * carta.getAtributo(atributoAfectado).getValor());
			else
				return (carta.getAtributo(atributoAfectado).getValor());
		}
	}

}
