package pocima;

import juego.Carta;

public abstract class Pocima {

	private String nombre;
	public Pocima(String nombre) {
		this.nombre = nombre;
		// TODO Auto-generated constructor stub
	}

	public String getNombre()
	{
		return (this.nombre);
	}
	public abstract int alterarCarta (Carta carta); //Void o carta?
	
}
