package estrategia;

import juego.Carta;

import juego.Mazo;
import java.util.ArrayList;

import java.util.List;


public abstract class Jugador {

	protected String nombre;
	private Mazo mazoJugador;
	
	public Jugador (String nombre)
	{
		this.nombre = nombre;
		this.mazoJugador = new Mazo();
	}
	
	public Jugador (Jugador jugador)
	{
		this.nombre = jugador.nombre;
		this.mazoJugador = jugador.mazoJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Mazo getMazoJugador() {
		return mazoJugador;
	}

	public void setMazoJugador(Mazo mazoJugador) {
		this.mazoJugador = mazoJugador;
	}
	
	public abstract Jugador cambiarEstrategia(Jugador jugador);
	public abstract String elegirAtributo(Carta carta);
	
	
	public Carta cartaEnMano()
	{
		return this.mazoJugador.sacarCartaDelMazo();
	}
	
		
		public int cantidadCartas()
		{
			return (this.mazoJugador.getTamanioMazo());
		}
		
		public void recibirCartas(Carta carta)
		{
			this.mazoJugador.agregarCartaAlMazo(carta);
		}
		
		public void recibirCartas(Mazo mazo)
		{
			this.mazoJugador.agregarMazo(mazo);
		}
	
		public void estadisticasJugador() //public String?
		{
			
			System.out.println (this.getNombre()+" posee "+this.cantidadCartas()+" cartas");
		}

		@Override
		public String toString() {
			return getNombre();
		}


		@Override
		public boolean equals(Object o) {
			// TODO Auto-generated method stub
			try {
				Jugador aux = (Jugador) o;
				if (this.getNombre().equals(aux.getNombre()))
					return true;
				else
					return false;
			}
			catch (Exception e)
			{
				return false;
			}
		}



}
