package juego;

import java.util.ArrayList;

public class Mazo {
	
	protected static ArrayList<Carta> mazo = new ArrayList<Carta> ();
	
	public int posicionAzar()
	{
		return (int) (Math.random()*mazo.size());
	}
	
	public void crearMazo()
	{
		//AQUI SE HACE LA CARGA POR ARCHIVO
		int tamañoArchivo = 15;
		mazo.ensureCapacity(tamañoArchivo); //Asegurar tamaño del mazo?
		
		
		//al terminar de crearlo lo mezcla?
		//mezclarMazo();
	}
	
	public void agregarCartaAlMazo(Carta carta)
	{
		mazo.add(carta);
		
		//agregar al azar?
		/*
		 * if (mazo.size() > 2)
				mezclarMazo();
		*/

	}
	
	public Carta sacarCartaDelMazo()
	{
		Carta aux = mazo.get(0);
		mazo.remove(0);
		return (aux);
	}
	
	public void mezclarMazo()
	{
		for (int i = 0; i < mazo.size() ; i++)
		{
			int posOrigen = posicionAzar();
			int posDestino = posicionAzar();
			Carta aux = mazo.get(posDestino);
			mazo.set(posDestino, mazo.get(posOrigen));
			mazo.set(posOrigen, aux);
		}
	}
	

	
	
	
	
}
