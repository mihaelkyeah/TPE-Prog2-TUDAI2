package pocima;

import java.util.AbstractList;
import java.util.ArrayList;

import juego.Carta;

public class PocimaCocktail extends Pocima {
///ESTA CLASE DEBE SER PUESTA A PRUEBA, esta horrible -.-
	
	public PocimaCocktail(String nombre, Object valor) {
		super(nombre, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void alterarCarta(Carta carta) {
		// TODO Auto-generated method stub
		ArrayList <Pocima> cosa = new ArrayList<Pocima>();
		PocimaAtributo pota1 = new PocimaAtributo("pota1", 1.25);
		PocimaAtributo pota2= new PocimaAtributo("pota2", 0.80);
		PocimaCarta pota3= new PocimaCarta("pota3", 4);
		PocimaCocktail prueba = new PocimaCocktail ("probando", cosa);

		for (Pocima pota: this.getValor())
		{
			pota.alterarCarta(carta);
			System.out.println("Que pasara, que misterio abra");
		}
	}
	
	
	public void setValor(Pocima pocima) {
		((AbstractList<Pocima>) this.valor).add(pocima);
	}
	

	public ArrayList<Pocima> getValor() {
		return ((ArrayList<Pocima>) this.valor);
	}

}
