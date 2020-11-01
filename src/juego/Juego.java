package juego;

import java.util.ArrayList;

import estrategia.Jugador;

public class Juego extends Mazo{  //esta mas por comodidad que otra cosa, seguramente sera eliminado el extends

	public static Mazo mesa = null;
	private Mazo mazoOriginal;
	private ArrayList<Jugador> jugadores;
	
	public Juego(String jsonFile) {
		mazoOriginal.crearMazo(jsonFile);
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
			jugadores.get(j).recibirCartas(mazoOriginal.sacarCartaDelMazo());
			// TODO: mazoOriginal.crearMazo(); <-- Tiene que estar ni bien empieza el juego; tiene que llamarse una sola vez y aplicar las potas
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
		if (jugadores.size() < 0)
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
	
	public void declararGanador()
	{
		//utilizara hayGanador o jugadorConMasCartas dependiendo de si quedan rondas o no
	}
	/*
	public Jugador juegaRonda(Jugador ganador) {
		// TODO: Incluir verificación externa:
		// sólo se puede jugar una ronda si hay al menos 2 jugadores en el arraylist jugadores
		Jugador ganaRonda = ganador;
		
		jugadores.get(jugadores.indexOf(ganador)).jugarCarta();
		for(int i = 0; i < jugadores.size(); i++) {
		//	if(jugadores.get(i).presentarCarta().eslamejorcartadelaronda())
				ganaRonda = jugadores.get(i);
		}
		return ganaRonda;
	}
	*/
	
	public void Ronda()
	{
		boolean ganador = this.hayGanador();
		int turno = 0, numeroRonda=1;
		ArrayList <Atributo> valores = null;
		while (!ganador)
		{
			System.out.println("------ RONDA "+numeroRonda+" ------");
			
			
			Jugador jugadorTurno = jugadores.get(turno);
			Carta cartaTurno = jugadorTurno.cartaEnMano();
			String atributoTurno = jugadorTurno.elegirAtributo(cartaTurno);
			valores.add(new Atributo(jugadorTurno.getNombre(), cartaTurno.getValor(atributoTurno)));
			
			System.out.println("El jugador "+jugadorTurno+" selecciona competir por el atributo "+atributoTurno);
			System.out.println("La carta de "+jugadorTurno+" es "+cartaTurno+ " con "+atributoTurno+""+cartaTurno.getValor(atributoTurno));
			
			ArrayList <Jugador> enfrentar = this.competidores(jugadorTurno);
			mesa.agregarCartaAlMazo(cartaTurno);
			for (Jugador competidor : enfrentar)
			{
				Carta cartaCompetidor = competidor.cartaEnMano();
				System.out.println("La carta de "+competidor+" es "+cartaCompetidor+" con "+atributoTurno+""+cartaCompetidor.getValor(atributoTurno));
				valores.add(new Atributo(competidor.getNombre(), cartaCompetidor.getValor(atributoTurno)));
				mesa.agregarCartaAlMazo(cartaCompetidor);
			}
			
			String ganadorEstaRonda = this.ganadorRonda(valores);
			//recibe las cartas
			Jugador vencedor = this.getJugador(ganadorEstaRonda);
			System.out.println("Gana la ronda "+ganadorEstaRonda+" y queda con "+vencedor.cantidadCartas()+" cartas ");
			//Mostrar estadisticas de todos los jugadores <-- abstraer el tema porque ya molesta -.-
			// mesa.clear(); //en realidad debe ir al ganador
			vencedor.recibirCartas(mesa);
			 ganador = this.hayGanador();
			 numeroRonda++;
			 turno++;
			 if (turno == jugadores.size())
				 turno = 0;
		}
	}

	private ArrayList <Jugador> competidores(Jugador jugador)
	{
		ArrayList <Jugador> copia = new ArrayList <Jugador>();
		copia.addAll(this.jugadores);
		copia.remove(jugador);
		return copia;
	}


}
