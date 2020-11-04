package pocima;

import juego.Carta;

public abstract class Pocima {

	private String nombre;
	private String restriccion;
	public final String SIN_RESTRICCION = "NINGUNA";
	
	
	public Pocima(String nombre) {
		this.nombre = nombre;
		this.restriccion=SIN_RESTRICCION;
	}
	public Pocima(String nombre, String restriccion) {
		this.nombre = nombre;
		this.restriccion= restriccion;
	}

	public String getNombre()
	{
		return (this.nombre);
	}
	
	public String getRestriccion()
	{
		return (this.restriccion);
	}
	
	public abstract int alterarAtributo(String atributo, int valor);
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
