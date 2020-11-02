package pocima;

import juego.Carta;

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
	public int alterarCarta(Carta carta, String atributoEnJuego) {
		Carta cartaAux = carta.copiarCarta();
		int resultado = this.pota1.alterarCarta(cartaAux, atributoEnJuego);
		cartaAux.getAtributo(atributoEnJuego).setValor(resultado);
		if (this.pota2 != null)
		{
			resultado =this.pota2.alterarCarta(cartaAux, atributoEnJuego);
			cartaAux.getAtributo(atributoEnJuego).setValor(resultado);
		}
		
		return resultado;
	}
	

}
