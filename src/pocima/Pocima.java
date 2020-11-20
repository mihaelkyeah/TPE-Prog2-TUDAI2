package pocima;

public abstract class Pocima {

	private String nombre;	
	
	public Pocima(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return (this.nombre);
	}
	
	/**
	 * Altera el valor de un atributo de una carta,
	 * dependiendo del tipo concreto de pócima que la carta tenga
	 * @param atributo
	 * @param valor
	 * @return double
	 */
	public abstract double alterarAtributo(String atributo, double valor);
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
