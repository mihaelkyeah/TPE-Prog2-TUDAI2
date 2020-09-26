package juego;

import java.util.ArrayList;

public class Mazo {
	
	protected ArrayList<Carta> mazo = new ArrayList<Carta> ();
	
	public int posicionAzar()
	{
		return (int) (Math.random()*mazo.size());
	}
	
	public int getTamanioMazo() {
		return mazo.size();
	}
	
	public void crearMazo(int tamanioOriginal)
	{
		//AQUI SE HACE LA CARGA POR ARCHIVO
		int tamanioArchivo = 0;
		if(tamanioOriginal > 0)
			tamanioArchivo = tamanioOriginal;
		else
			tamanioArchivo = 15; // AGUANTEN LAS CONSTANTES JARCODEADAS
		mazo.ensureCapacity(tamanioArchivo); //Asegurar tamaño del mazo?
		
		
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
