package pocima;

public class PocimaSeteo extends Pocima {

	private double seteo;
	public PocimaSeteo(String nombre, double seteo) {
		super(nombre);
		this.seteo = seteo;
	}

	// Altera el valor del atributo aplicable reemplazándolo por un valor arbitrario
	@Override
	public double alterarAtributo(String atributo, double valor) {
		return (this.seteo);
	}

}
