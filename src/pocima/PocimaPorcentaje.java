package pocima;

import juego.Carta;

public class PocimaPorcentaje extends Pocima{

	private double porcentaje;
	public PocimaPorcentaje(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje=porcentaje;
	}

	public PocimaPorcentaje(String nombre, double porcentaje, String restriccion) {
		super(nombre, restriccion);
		this.porcentaje=porcentaje;
	}

	// Altera el valor del atributo aplicable multiplicándolo por un porcentaje
	@Override
	public int alterarCarta(Carta carta, String atributoAfectado) {		
		if ((this.getRestriccion().equals(SIN_RESTRICCION)) || (this.getRestriccion().equals(atributoAfectado)))
			return  (int)(this.porcentaje * carta.getAtributo(atributoAfectado).getValor());
		else
			return (0);
	}

}
