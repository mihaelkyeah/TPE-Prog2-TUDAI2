package pocima;

public abstract class Pocima {

	private String nombre;	
	
	public Pocima(String nombre) {
		this.nombre = nombre;
	}
	
	public Pocima(String nombre, String restriccion) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return (this.nombre);
	}
	
	public abstract double alterarAtributo(String atributo, double valor);
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
