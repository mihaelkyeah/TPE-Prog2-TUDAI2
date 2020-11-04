package juego;

import java.util.ArrayList;
import estrategia.*;
import pocima.Pocima;

public class Juego {

	public static Mazo mesa = new Mazo();
	private Mazo mazoOriginal;
	private ArrayList<Jugador> jugadores;
	
	public Juego(String jsonFile) {
		this.mazoOriginal = new Mazo();
		this.mazoOriginal.crearMazo(jsonFile);
		this.jugadores = new ArrayList<Jugador>();
	}
	
	// Imprime todas las cartas por pantalla
	public void imprimirMazo() {
		this.mazoOriginal.imprimirMazo();
	}
	
	// Agrega un jugador a la partida
	public void agregarJugador(Jugador j) {
		jugadores.add(j);
	}
	
	// Busca a un jugador en la estructura por nombre
	public Jugador getJugador(String nombre) {
		for(int i = 0; i < jugadores.size(); i++)
			if(jugadores.get(i).getNombre().equalsIgnoreCase(nombre))
				return jugadores.get(i);
		return null;
	}
	
	// Busca a un jugador por nombre y devuelve su posición en la estructura
	public int getPosicionJugador(String nombre) {
		for(int i = 0; i < jugadores.size(); i++)
			if(jugadores.get(i).getNombre().equalsIgnoreCase(nombre))
				return (i);
		return -1;
	}
	
	// Elimina a un jugador de la partida
	public void eliminarJugador(String nombre) {
		if(jugadores.contains(this.getJugador(nombre))) {
			jugadores.remove(this.getJugador(nombre));
			System.out.println(""+nombre+" ha sido eliminad@ de la competencia.");
		}		
	}
	
	// Reparte las cartas y las pócimas a los jugadores
	public void repartirCartas(ArrayList<Pocima> listaPocimas)
	{
		int j = 0;
		this.mazoOriginal.mezclarMazo();
		while (this.mazoOriginal.getTamanioMazo() > 0)
		{
			Carta aux = this.mazoOriginal.sacarCartaDelMazo();
			if (listaPocimas.size() > 0)
			{
				aux.setPocima(listaPocimas.get(0));
				listaPocimas.remove(0);
			}
			jugadores.get(j).recibirCarta(aux);
			j++;
			if(j >= this.jugadores.size())
				j=0;
		}
	}
	
	// Muestra los nombres y la cantidad de cartas de todos los jugadores
	public void mostrarEstadisticasTodos() {
		for (int i= 0; i < this.jugadores.size(); i++)
			 this.jugadores.get(i).estadisticasJugador();
	}
	
	// Verifica si queda sólo un jugador con cartas
	public boolean hayGanador()
	{
		int conCartas= 0;
		for(int i = 0; i < jugadores.size(); i ++)
			if ((jugadores.get(i).cantidadCartas()) > 0)
				conCartas++;
		if (jugadores.size() < 2)
			return true;
		return (conCartas == 1);
	}
	
	// Busca al ganador de la ronda comparando los valores de atributo de cada jugador en la última jugada
	public String ganadorRonda(ArrayList <Atributo> jugadores)
	{
		Atributo ganador = null;
		for (Atributo persona : jugadores)
			if ((ganador == null) || (ganador.valor < persona.valor))
			{ganador = persona;}
		return ganador.getNombre();
	}
	
	// Ronda sin límites
	public void Ronda() {
		this.Ronda(Integer.MAX_VALUE);
	}
	
	// Ronda con límite de turnos recibido por parámetro
	public void Ronda(int limiteRonda)
	{
		boolean ganador = this.hayGanador();
		int turno = 0, numeroRonda=1;
		this.mostrarEstadisticasTodos();
		while (!ganador && numeroRonda <= limiteRonda)
		{
			ganador = this.juegaRonda(numeroRonda, turno);
			numeroRonda++;
			turno++;
			if (turno >= jugadores.size())
				 turno = 0;
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		this.declararGanador();
	}
	
	// Procedimiento al que llaman Ronda() y Ronda(int)
	// Enfrenta a los jugadores, compara sus atributos, aplica pócimas si las hay,
	// y determina ganador de la ronda o ganador del juego
	public boolean juegaRonda(int numeroRonda, int turno)
	{
		ArrayList <Atributo> valores = new ArrayList<Atributo>();
		
		System.out.println("\n------ RONDA "+(numeroRonda)+" ------");
		
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
	
	// Busca y elimina a todos los jugadores que no tengan cartas
	private void eliminarPerdedores() {
		ArrayList<String> perdedores = this.jugadoresPerdedores();
		if(perdedores.size() > 0)
			for(String nombrePerdedor:perdedores)
				this.eliminarJugador(nombrePerdedor);
	}
	
	// Trae un arreglo con todos los jugadores que no tengan cartas
	private ArrayList<String> jugadoresPerdedores() {
		ArrayList<String> retorno = new ArrayList<>();
		for(Jugador j:this.jugadores)
			if(j.cantidadCartas() == 0)
				retorno.add(j.getNombre());
		return retorno;
	}
	
	private void mostrarGanadorRonda(Jugador vencedor) {
		System.out.println("Gana la ronda "+vencedor+" y queda con "+vencedor.cantidadCartas()+" cartas ");
	}
	
	private void mostrarGanadorJuego(String nombreJugador) {
		System.out.println(""+nombreJugador+" ha ganado el juego!!");
	}
	
	// Determina si hay un ganador definitivo en cualquier momento del juego,
	// y si ya se acabaron las rondas y no hay ganadores, se declara empate
	private void declararGanador() {
		
		System.out.println("\n========= RESULTADOS =========\n");
		
		ArrayList<Atributo> ganadores = new ArrayList<>();
		
		ganadores.add(new Atributo(jugadores.get(0).getNombre(), jugadores.get(0).cantidadCartas()));
		
        for (int i = 1; i < jugadores.size(); i++) {
            if (jugadores.get(i).cantidadCartas() >= ganadores.get(0).getValor()) {
            	if (jugadores.get(i).cantidadCartas() > ganadores.get(0).getValor())
            		ganadores.clear();
            	ganadores.add(new Atributo(jugadores.get(i).getNombre(),jugadores.get(i).cantidadCartas()));
            }
        }
        
        if(ganadores.size()>1) {
        	System.out.println("Empate entre los siguientes jugadores:");
        	for(Atributo ganador:ganadores) {
        		System.out.println(ganador.getNombre());
        		System.out.println("Cantidad de cartas: "+ganador.getValor());
        	}
        }
        else
        	this.mostrarGanadorJuego(ganadores.get(0).getNombre());   
        	
	}

}