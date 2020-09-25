package juego;

public class Carta{
	
	private Atributos atributos;
	private int numero;
	private String nombre;
	
	public Carta ()
	{
		this.atributos = new Atributos();
		this.setNumero(0);
		this.setNombre("");
	}
	
	public Carta (int fuerza, double altura, double peso, int velocidad, int peleasGanadas, int numero, String nombre)
	{
		this.atributos = new Atributos (fuerza, altura, peso, velocidad, peleasGanadas);
		this.setNumero(numero);
		this.setNombre(nombre);
	}
	
	public Carta (Atributos atributos, int numero, String nombre)
	{
		this.setAtributos(atributos);
		this.setNumero(numero);
		this.setNombre(nombre);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Atributos getAtributos() {
		return atributos;
	}

	public void setAtributos(Atributos atributos) {
		this.atributos = atributos;
	}
	
	
}
