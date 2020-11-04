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
	public int alterarAtributo(String atributo, int valor) {		
		if ((this.getRestriccion().equals(SIN_RESTRICCION)) || (this.getRestriccion().equals(atributo)))
			return  (int)(this.porcentaje * valor);
		else
			return (0);
	}

}
