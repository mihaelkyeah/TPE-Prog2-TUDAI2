package juego;

import java.util.ArrayList;
import java.util.List;

import estrategia.*;
import pocima.Pocima;

public class Juego {
	
	private Jugador j1, j2;
	private List<String> log;
	private Mazo mazoOriginal;
	
	public Juego(Jugador j1, Jugador j2, Mazo mazoOriginal) {
		this.j1 = j1;
		this.j2 = j2;
		this.mazoOriginal = mazoOriginal;
		this.log = new ArrayList<>();
	}
	
	public void repartirCartas(ArrayList<Pocima> listaPocimas) {
		this.mazoOriginal.mezclarMazo();
		Jugador jugadorRecibeCarta = j1;
		while (this.mazoOriginal.getTamanioMazo() > 0) {
			Carta aux = this.mazoOriginal.sacarCartaDelMazo();
			if (listaPocimas.size() > 0) {
				aux.setPocima(listaPocimas.get(0));
				listaPocimas.remove(0);
			}
			jugadorRecibeCarta.recibirCarta(aux);
			// consulta la dirección de memoria a ver si se trata de ese objeto
			if(jugadorRecibeCarta == j1)
				jugadorRecibeCarta = j2;
			else
				jugadorRecibeCarta = j1;
		}
	}
	
	public void ronda() {
		this.ronda(Integer.MAX_VALUE);
	}
	
	public void ronda(int limiteRonda) {
		boolean ganador = this.hayGanador();
		Jugador jugadorTurno = j1;
		int numeroRonda=1;
		// TODO imprimir las estadísticas de todos
		this.logInicioJuego();
		while (!ganador && numeroRonda <= limiteRonda) {
			// juegaRonda se encarga de jugar la ronda y devuelve el jugador que ganó
			jugadorTurno = this.juegaRonda(numeroRonda, jugadorTurno);
			numeroRonda++;
			ganador = this.hayGanador();
		}
		// TODO imprimir quién gana
		this.logFinDeJuego();
	}

	public Jugador juegaRonda(int numeroRonda, Jugador jugadorTurno) {	
		// <Atributo> valores = new ArrayList<Atributo>();
			// Esto se suponía que iba a ir guardando los atributos y valores
			// elegidos por cada jugador si eran más de 2
		String atributoTurno = jugadorTurno.getAtributoJuego();
		
		this.logInicioRonda(jugadorTurno,numeroRonda,atributoTurno);
		
		Carta cartaj1 = j1.cartaEnMano();
		Carta cartaj2 = j2.cartaEnMano();
		
		this.logEstado(j1,cartaj1,atributoTurno);
		this.logEstado(j2,cartaj2,atributoTurno);
		
		if(cartaj1.getValorAtributo(atributoTurno) > cartaj2.getValorAtributo(atributoTurno)) {
			j1.recibirCarta(cartaj1);
			j1.recibirCarta(cartaj2);
			this.logGanadorRonda(j1,j2);
			return j1;
		} else if (cartaj1.getValorAtributo(atributoTurno) < cartaj2.getValorAtributo(atributoTurno)) {
			j2.recibirCarta(cartaj2);
			j2.recibirCarta(cartaj1);
			this.logGanadorRonda(j2,j1);
			return j2;
		}
		else {
			j1.recibirCarta(cartaj1);
			j2.recibirCarta(cartaj2);
			this.logEmpate(j1,j2);
			return jugadorTurno;
		}
	}

	private void logInicioJuego() {
		// TODO Auto-generated method stub	
	}
	
	private void logInicioRonda(Jugador jugadorTurno, int numeroRonda, String atributoTurno) {
		this.log.add("------- Ronda "+numeroRonda+" -------");
		this.log.add("El jugador "+jugadorTurno+" selecciona competir por el atributo "+atributoTurno);
	}

	private void logEstado(Jugador jugador, Carta cartaJugador, String atributoTurno) {
		this.log.add("La carta de "+jugador+" es "+cartaJugador.getString(atributoTurno));
	}
	
	private void logGanadorRonda(Jugador ganador, Jugador perdedor) {
		this.log.add("Ganó la ronda "+ganador+" y queda con "+ganador.getCantidadCartas()+" cartas "
							+" ("+perdedor+" posee ahora "+perdedor.getCantidadCartas()+" cartas)");
	}
	
	private void logEmpate(Jugador j1, Jugador j2) {
		this.log.add("Se produjo un empate. "+j1+" tiene "+j1.getCantidadCartas()+" cartas y "+j2+" tiene "+j2.getCantidadCartas()+" cartas.");
	}
	
	private void logFinDeJuego() {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> getLog() {
		return new ArrayList<>(this.log);
	}
	
	public boolean hayGanador() {
		return(j1.getCantidadCartas() == 0 || j2.getCantidadCartas() == 0);
	}

}