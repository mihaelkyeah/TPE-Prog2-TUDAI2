package pocima;

// Esta Pocima "altera" el valor del atributo "reemplazándolo" por el valor de la pocima

public class PocimaSeteo extends Pocima {

	private double seteo;
	public PocimaSeteo(String nombre, double seteo) {
		super(nombre);
		this.seteo = seteo;
	}

	@Override
	public double alterarAtributo(String atributo, double valor) {
		return (this.seteo);
	}

}
