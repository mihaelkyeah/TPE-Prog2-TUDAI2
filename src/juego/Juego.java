package juego;

import java.util.ArrayList;

public class Juego extends Mazo{  //esta mas por comodidad que otra cosa, seguramente sera eliminado el extends

	private ArrayList<Jugador> jugadores;
	public final int maxRondas = 5; //constante o modificable? static?
	
	public void repartirCartas()
	{
		int j = 0;
		for (int i = 0; i < mazo.size(); i++)
		{
			if(j == jugadores.size())
				j=0;
			else
				j++;
			Carta aux = sacarCartaDelMazo();
			jugadores.get(j).recibirCarta(aux);
			
		}
	}
	
	public void estadisticasJugadores()
	{
		for (int i=0; i < jugadores.size(); i++)
			jugadores.get(i).estadisticasJugador();
	}
	
	public void darCartasAlGanador(Jugador ganador)
	{
		for (int i = 0; i < jugadores.size(); i++)
		{
			if (!(jugadores.get(i).equals(ganador)))
				jugadores.get(i).entregarCarta(ganador);
		}
	}
	
	public boolean hayGanador()
	{
		int conCartas= 0;
		for(int i = 0; i < jugadores.size(); i ++)
			if ((jugadores.get(i).cantidadCartas()) > 0)
				conCartas++;
		return (conCartas == 1);
	}
	
	public int jugadorConMasCartas()
	{
		int posMasCartas= -1;
		for(int i = 0; i < jugadores.size(); i ++)
			if ((posMasCartas== -1) || (jugadores.get(i).cantidadCartas()) > jugadores.get(posMasCartas).cantidadCartas())
				posMasCartas= i;
		return (posMasCartas);
	}
	
	public void declararGanador()
	{
		//utilizara hayGanador o jugadorConMasCartas dependiendo de si quedan rondas o no
	}
}
