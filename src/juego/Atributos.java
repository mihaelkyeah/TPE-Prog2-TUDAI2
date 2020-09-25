package juego;

public class Atributos {//todos son int's o pueden haber doubles?
	protected int Fuerza;
	protected double Altura;
	protected double Peso;
	protected int Velocidad;
	protected int PeleasGanadas;
	
	public Atributos (int fuerza, double altura, double peso, int velocidad, int peleasGanadas) 
	{
		this.setAltura(altura);
		this.setFuerza(fuerza);
		this.setPeleasGanadas(peleasGanadas);
		this.setPeso(peso);
		this.setVelocidad(velocidad);
	}
	
	public Atributos ()
	{
		this.setAltura(0);
		this.setFuerza(0);
		this.setPeleasGanadas(0);
		this.setPeso(0);
		this.setVelocidad(0);
	}

	public int getFuerza() {
		return Fuerza;
	}

	public void setFuerza(int fuerza) {
		this.Fuerza = fuerza;
	}

	public double getAltura() {
		return Altura;
	}

	public void setAltura(double altura) {
		this.Altura = altura;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		this.Peso = peso;
	}

	public int getVelocidad() {
		return Velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.Velocidad = velocidad;
	}

	public int getPeleasGanadas() {
		return PeleasGanadas;
	}

	public void setPeleasGanadas(int peleasGanadas) {
		this.PeleasGanadas = peleasGanadas;
	}

}
