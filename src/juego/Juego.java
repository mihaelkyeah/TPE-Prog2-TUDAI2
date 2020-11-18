package juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import estrategia.*;
import pocima.Pocima;

public class Juego {
	
	// Esto me hace ruido
	private Map<Jugador,Jugador> jugadores;
	
	public Juego(Jugador j1, Jugador j2) {
		// Yo quería inicializarlo como un Pair<>() pero el IDE o el JRE no me deja
		jugadores = new HashMap<>();
		jugadores.put(j1, j2);
	}
	
	public boolean juegaRonda(int numeroRonda)
	{	
		// <Atributo> valores = new ArrayList<Atributo>();
			// Esto se suponía que iba a ir guardando los atributos y valores
			// elegidos por cada jugador si eran más de 2
		
		Jugador jugadorTurno = jugadores.get(turno);
		Carta cartaTurno = jugadorTurno.cartaEnMano();
		String atributoTurno = jugadorTurno.getEstrategia().elegirAtributo(cartaTurno);
		
		this.jugarCarta(jugadorTurno,cartaTurno,atributoTurno,valores);
		this.enfrentar(jugadorTurno,atributoTurno,valores);
		
		String ganadorEstaRonda = this.ganadorRonda(valores);
		//recibe las cartas
		Jugador vencedor = this.getJugador(ganadorEstaRonda);
		vencedor.recibirCartas(mesa);// el ganador recibe las cartas en la mesa
		this.mostrarGanadorRonda(vencedor);
		
		boolean ganador = this.hayGanador();
		numeroRonda++;
		turno++;
		valores.clear();
		mesa.borrarMazo();
		
		this.eliminarPerdedores();
		
		return ganador;
	}
	
	private void jugarCarta(Jugador jugador, Carta cartaJugador, String atributoTurno, ArrayList<Atributo> valores) {
		System.out.println("La carta de "+jugador+" es "+cartaJugador+" con "+atributoTurno+" "+cartaJugador.getValor(atributoTurno));
		// Aplicar pócimas
		// Esta verificación sólo es necesaria si queremos imprimir por pantalla.
		int valorPocima = cartaJugador.usarPocima(cartaJugador.getPocima(), atributoTurno);
		if(valorPocima != cartaJugador.getValor(atributoTurno))
			System.out.println("Se aplica la pócima "+cartaJugador.getPocima()+" - Valor resultante = "+valorPocima);
		valores.add(new Atributo(jugador.getNombre(), valorPocima));
		mesa.agregarCartaAlMazo(cartaJugador);
	}

	// Usa un arreglo con todos los oponentes del jugador al que le toca jugar, para poder enfrentarlos
	// Junta todas las cartas de todos los participantes para luego comparar los valores de sus atributos
	private void enfrentar(Jugador jugadorTurno, String atributoTurno, ArrayList<Atributo> valores) {
		ArrayList <Jugador> enfrentar = this.competidores(jugadorTurno);
		for (Jugador competidor : enfrentar) {
			Carta cartaCompetidor = competidor.cartaEnMano();
			this.jugarCarta(competidor, cartaCompetidor, atributoTurno, valores);
		}
	}

	// Trae un arreglo con todos los jugadores excepto el jugador del turno actual
	private ArrayList <Jugador> competidores(Jugador jugador)
	{
		ArrayList <Jugador> copia = new ArrayList <Jugador>();
		copia.addAll(this.jugadores);
		copia.remove(jugador);
		return copia;
	}
	

}