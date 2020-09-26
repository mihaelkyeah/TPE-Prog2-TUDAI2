package juego;

import java.util.ArrayList;

public class Juego extends Mazo{  //esta mas por comodidad que otra cosa, seguramente sera eliminado el extends

	private Mazo mazoOriginal;
	private ArrayList<Jugador> jugadores;
	
	public Juego() {
		mazoOriginal.crearMazo(15);
		jugadores = new ArrayList<Jugador>();
	}
	
	public void agregarJugador(Jugador j) {
		jugadores.add(j);
	}
	
	public Jugador getJugador(String nombre) {
		for(int i = 0; i < jugadores.size(); i++)
			if(jugadores.get(i).getNombre().equalsIgnoreCase(nombre))
				return jugadores.get(i);
		return null;
	}
	
	// ¿Es mejor boolean o un mensaje por string?
	public void eliminarJugador(String nombre) {
		if(jugadores.contains(this.getJugador(nombre)))
			jugadores.remove(this.getJugador(nombre));
	}
		
	public void repartirCartas()
	{
		int j = 0;
		for (int i = 0; i < mazoOriginal.getTamanioMazo(); i++)
		{
			if(j == jugadores.size())
				j=0;
			else
				j++;
			jugadores.get(j).recibirCarta(mazoOriginal.sacarCartaDelMazo());
			// TODO: mazoOriginal.crearMazo(); <-- Tiene que estar ni bien empieza el juego; tiene que llamarse una sola vez
		}
	}
	
	public Jugador juegaRonda(Jugador ganador) {
		// TODO: Incluir verificación externa:
		// sólo se puede jugar una ronda si hay al menos 2 jugadores en el arraylist jugadores
		Jugador ganaRonda = ganador;
		
		jugadores.get(jugadores.indexOf(ganador)).jugarCarta();
		for(int i = 0; i < jugadores.size(); i++) {
			if(jugadores.get(i).presentarCarta().eslamejorcartadelaronda())
				ganaRonda = jugadores.get(i);
		}
		return ganaRonda;
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
	
	// Devuelve la posición en el arraylist jugadores que apunta al jugador con más cartas
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
