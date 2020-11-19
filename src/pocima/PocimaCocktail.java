package pocima;

//Esta Pocima "altera" el valor del atributo "reemplazándolo" por resultado de aplicar una cadena de pocimas

public class PocimaCocktail extends Pocima {
	
	private Pocima pota1;
	private Pocima pota2;
	
	public PocimaCocktail(String nombre, Pocima pota1, Pocima pota2) {
		super(nombre);
		this.pota1 = pota1;
		this.pota2 = pota2;
	}

	// La pócima cocktail aplica la pota 1 a la carta y luego aplica la pota 2
	@Override
	public double alterarAtributo(String atributo, double valor) {
		double resultado = this.pota1.alterarAtributo(atributo, valor);
		resultado = this.pota2.alterarAtributo(atributo, resultado);
		return resultado;
	}
	

}
