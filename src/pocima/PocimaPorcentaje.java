package pocima;

//Esta Pocima "altera" el valor del atributo por el resultado de multiplicar el porcentaje de la pocima con dicho valor

public class PocimaPorcentaje extends Pocima{

	private double porcentaje;
	public PocimaPorcentaje(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje=porcentaje;
	}

	@Override
	public double alterarAtributo(String atributo, double valor) {		
		return (this.porcentaje * valor);
	}

}
