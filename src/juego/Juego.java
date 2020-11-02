package juego;

import java.util.ArrayList;

import estrategia.Jugador;

public class Juego extends Mazo{  //esta mas por comodidad que otra cosa, seguramente sera eliminado el extends

	public static Mazo mesa = new Mazo();
	private Mazo mazoOriginal;
	private ArrayList<Jugador> jugadores;
	
	public Juego(String jsonFile) {
		this.mazoOriginal = new Mazo();
		this.mazoOriginal.crearMazo(jsonFile);
        this.mazoOriginal.validarCartas();
		this.jugadores = new ArrayList<Jugador>();
	}
	
	public void imprimirMazo() {
		this.mazoOriginal.imprimirMazo();
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
		if(jugadores.contains(this.getJugador(nombre))) {
			jugadores.remove(this.getJugador(nombre));
			System.out.println(""+nombre+" ha sido eliminad@ de la competencia.");
		}
			
	}
		
	public void repartirCartas()
	{
		int j = 0;
		// TODO: mazoOriginal.crearMazo(); <-- Tiene que estar ni bien empieza el juego; tiene que llamarse una sola vez y aplicar las potas
		while (this.mazoOriginal.getTamanioMazo() > 0)
		{
			jugadores.get(j).recibirCartas(this.mazoOriginal.sacarCartaDelMazo());
			j++;
			if(j == this.jugadores.size())
				j=0;
		}
	}
	

	
	public void estadisticasJugadores()
	{
		for (int i=0; i < jugadores.size(); i++)
			jugadores.get(i).estadisticasJugador();
	}
	
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
	
	// Devuelve la posición en el arraylist jugadores que apunta al jugador con más cartas
	public int jugadorConMasCartas()
	{
		int posMasCartas= -1;
		for(int i = 0; i < jugadores.size(); i ++)
			if ((posMasCartas== -1) || (jugadores.get(i).cantidadCartas()) > jugadores.get(posMasCartas).cantidadCartas())
				posMasCartas= i;
		return (posMasCartas);
	}
	
	public String ganadorRonda(ArrayList <Atributo> jugadores)
	{
		Atributo ganador = null;
		for (Atributo persona : jugadores)
			if ((ganador == null) || (ganador.valor < persona.valor))
			{ganador = persona;}
		return ganador.getNombre();
	}
	
	// Muestra por pantalla las estadísticas de todos los jugadores
	public void mostrarEstadisticasTodos() {
		for (int i= 0; i < this.jugadores.size(); i++)
			 this.jugadores.get(i).estadisticasJugador();
	}
	
	public void Ronda()
	{
		boolean ganador = this.hayGanador();
		int turno = 0, numeroRonda=1;
		ArrayList <Atributo> valores = new ArrayList<Atributo>();
		this.mostrarEstadisticasTodos();
		while (!ganador)
		{
			System.out.println("------ RONDA "+numeroRonda+" ------");
			
			Jugador jugadorTurno = jugadores.get(turno);
			Carta cartaTurno = jugadorTurno.cartaEnMano();
			String atributoTurno = jugadorTurno.elegirAtributo(cartaTurno);
			valores.add(new Atributo(jugadorTurno.getNombre(), cartaTurno.getValor(atributoTurno)));
			
			this.mostrarJugada(jugadorTurno,cartaTurno,atributoTurno);
			
			mesa.agregarCartaAlMazo(cartaTurno);
			
			this.enfrentar(jugadorTurno,atributoTurno,valores);
			
			String ganadorEstaRonda = this.ganadorRonda(valores);
			//recibe las cartas
			Jugador vencedor = this.getJugador(ganadorEstaRonda);
			vencedor.recibirCartas(mesa);// el ganador recibe las cartas en la mesa
			this.mostrarGanadorRonda(vencedor);
			//Mostrar estadisticas de todos los jugadores <-- abstraer el tema porque ya molesta -.-
			
			ganador = this.hayGanador();
			numeroRonda++;
			turno++;
			valores.clear();
			mesa.borrarMazo();
			
			this.eliminarPerdedores();
			 
			if (turno == jugadores.size())
				 turno = 0;
		}
		this.declararGanador();
	}
	
	public void Ronda(int limiteRonda)
	{
		boolean ganador = this.hayGanador();
		int turno = 0, numeroRonda=1;
		ArrayList <Atributo> valores = new ArrayList<Atributo>();
		this.mostrarEstadisticasTodos();
		while (!ganador && numeroRonda < limiteRonda+1)
		{
			System.out.println("------ RONDA "+numeroRonda+" ------");
			
			Jugador jugadorTurno = jugadores.get(turno);
			Carta cartaTurno = jugadorTurno.cartaEnMano();
			String atributoTurno = jugadorTurno.elegirAtributo(cartaTurno);
			valores.add(new Atributo(jugadorTurno.getNombre(), cartaTurno.getValor(atributoTurno)));
			
			this.mostrarJugada(jugadorTurno,cartaTurno,atributoTurno);
			
			mesa.agregarCartaAlMazo(cartaTurno);
			
			this.enfrentar(jugadorTurno,atributoTurno,valores);
			
			String ganadorEstaRonda = this.ganadorRonda(valores);
			//recibe las cartas
			Jugador vencedor = this.getJugador(ganadorEstaRonda);
			vencedor.recibirCartas(mesa);// el ganador recibe las cartas en la mesa
			this.mostrarGanadorRonda(vencedor);
			//Mostrar estadisticas de todos los jugadores <-- abstraer el tema porque ya molesta -.-
			
			ganador = this.hayGanador();
			numeroRonda++;
			turno++;
			valores.clear();
			mesa.borrarMazo();
			
			this.eliminarPerdedores();
			 
			if (turno == jugadores.size())
				 turno = 0;
		}
		this.declararGanador();
	}
	
	private void enfrentar(Jugador jugadorTurno, String atributoTurno, ArrayList<Atributo> valores) {
		ArrayList <Jugador> enfrentar = this.competidores(jugadorTurno);
		for (Jugador competidor : enfrentar)
		{
			Carta cartaCompetidor = competidor.cartaEnMano();
			System.out.println("La carta de "+competidor+" es "+cartaCompetidor+" con "+atributoTurno+" "+cartaCompetidor.getValor(atributoTurno));
			valores.add(new Atributo(competidor.getNombre(), cartaCompetidor.getValor(atributoTurno)));
			mesa.agregarCartaAlMazo(cartaCompetidor);
		}
	}

	private ArrayList <Jugador> competidores(Jugador jugador)
	{
		ArrayList <Jugador> copia = new ArrayList <Jugador>();
		copia.addAll(this.jugadores);
		copia.remove(jugador);
		return copia;
	}
	
	private void mostrarJugada(Jugador jugadorTurno, Carta cartaTurno, String atributoTurno) {
		System.out.println("El jugador "+jugadorTurno+" selecciona competir por el atributo "+atributoTurno);
		System.out.println("La carta de "+jugadorTurno+" es "+cartaTurno+ " con "+atributoTurno+" "+cartaTurno.getValor(atributoTurno));
	}
	
	// Busca y elimina a todos los jugadores que no tengan cartas
	private void eliminarPerdedores() {
		ArrayList<String> perdedores = this.jugadoresPerdedores();
		if(perdedores.size() > 0)
			for(String nombrePerdedor:perdedores)
				this.eliminarJugador(nombrePerdedor);
	}
	
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
	
	private void declararGanador() {
		
		System.out.println("\n========= RESULTADOS =========\n\n");
		
		ArrayList<Atributo> ganadores = new ArrayList<>();
		
		ganadores.add(new Atributo(jugadores.get(0).getNombre(), jugadores.get(0).cantidadCartas()));
		
        for (int i = 1; i < jugadores.size(); i++)
        {
            if (jugadores.get(i).cantidadCartas() >= ganadores.get(0).getValor()) {
            	if (jugadores.get(i).cantidadCartas() > ganadores.get(0).getValor())
            		ganadores.clear();
            	ganadores.add(new Atributo(jugadores.get(i).getNombre(),jugadores.get(i).cantidadCartas()));
            }
            
        }
        
        if(ganadores.size()>1) {
        	System.out.println("Empate entre los siguientes jugadores:");
        	for(Atributo ganador:ganadores)
        		System.out.println(ganador);
        }
        else
        	this.mostrarGanadorJuego(ganadores.get(0).getNombre());
        
        	
	}


}
