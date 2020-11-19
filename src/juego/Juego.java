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
	
	public List<String> getLog() {
		return new ArrayList<>(this.log);
	}
	
	public void repartirCartas(List<Pocima> listaPocimas) {
		this.mazoOriginal.mezclarMazo();
		Jugador jugadorRecibeCarta = j1;
		while (this.mazoOriginal.getTamanioMazo() > 0) {
			Carta aux = this.mazoOriginal.sacarCartaDelMazo();
			// Mientras queden pocimas para repartir agrega una pocima a la carta
			if (listaPocimas.size() > 0) {
				aux.setPocima(listaPocimas.get(0));
				// Una vez agregada a una carta la saca de la lista
				listaPocimas.remove(0);
			}
			jugadorRecibeCarta.recibirCarta(aux);
			// Pasa al otro jugador para que reciba la proxima carta
			if(jugadorRecibeCarta == j1)
				jugadorRecibeCarta = j2;
			else
				jugadorRecibeCarta = j1;
		}
	}
	
// Se fija si algun jugador gano porque el otro se quedo sin cartas
	public Jugador hayGanador() {
		if(j1.getCantidadCartas() == 0)
			return j2;
		else if (j2.getCantidadCartas() == 0)
			return j1;
		return null;
	}
	
	public void ronda() {
		this.ronda(Integer.MAX_VALUE);
	}
	
	public void ronda(int limiteRonda) {
		Jugador ganador = this.hayGanador();
		Jugador jugadorTurno = j1;
		int numeroRonda=1;
		this.logInicioJuego();
		while (ganador==null && numeroRonda <= limiteRonda) {
			jugadorTurno = this.juegaRonda(numeroRonda, jugadorTurno);
			numeroRonda++;
			ganador = this.hayGanador();
		}
		this.logFinDeJuego(ganador);
	}

// Se encarga de jugar una ronda y devuelve el jugador que le toca en la proxima ronda
	public Jugador juegaRonda(int numeroRonda, Jugador jugadorTurno) {	
		
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
		this.log.add("¡Inicio de juego!");
		this.log.add(j1+" tiene "+j1.getCantidadCartas()+" cartas y "+j2+" tiene "+j2.getCantidadCartas()+" cartas.");
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
	
	private void logFinDeJuego(Jugador j) {
		Jugador jugadorQueGana = null;
		if(j != null)
		// Si el juego termino porque un jugador se quedo sin cartas	
			jugadorQueGana = j;
		else {
		// Si el juego termino porque se llego al limite de rondas
			if(j1.getCantidadCartas() > j2.getCantidadCartas())
				jugadorQueGana = j1;
			else if(j1.getCantidadCartas() < j2.getCantidadCartas())
				jugadorQueGana = j2;
		}
		if(jugadorQueGana != null)	
			this.log.add("¡"+jugadorQueGana+" ha ganado el juego!");
		else
			this.log.add("¡Empate!");
	}
	

}