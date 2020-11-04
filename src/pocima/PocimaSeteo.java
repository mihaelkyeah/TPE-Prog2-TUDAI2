package pocima;

public class PocimaSeteo extends Pocima {

	private int seteo;
	public PocimaSeteo(String nombre, int seteo) {
		super(nombre);
		this.seteo = seteo;
	}

	public PocimaSeteo(String nombre, int seteo, String restriccion) {
		super(nombre, restriccion);
		this.seteo=seteo;
	}

	// Altera el valor del atributo aplicable reemplazándolo por un valor arbitrario
	@Override
	public int alterarAtributo(String atributo, int valor) {
		if ((this.getRestriccion().equals(SIN_RESTRICCION)) || (this.getRestriccion().equals(atributo)))
			return (this.seteo);
		else
			return (0);
		
	}

}
