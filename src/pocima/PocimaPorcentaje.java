package pocima;

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
	public double alterarAtributo(String atributo, double valor) {		
		return (this.porcentaje * valor);
	}

}
