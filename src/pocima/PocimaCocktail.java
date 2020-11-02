package pocima;

import juego.Carta;

public class PocimaCocktail extends Pocima {
///ESTA CLASE DEBE SER PUESTA A PRUEBA
	
	private Pocima pota1;
	private Pocima pota2;
	
	public PocimaCocktail(String nombre, Pocima pota1, Pocima pota2) {
		super(nombre);
		this.pota1 = pota1;
		this.pota2 = pota2;
		// TODO Auto-generated constructor stub
	}


	@Override
	public int alterarCarta(Carta carta, String atributoEnJuego) {
		// TODO Auto-generated method stub
		return (this.pota1.alterarCarta(carta, atributoEnJuego) + this.pota2.alterarCarta(carta, atributoEnJuego) );
	}
	

}
