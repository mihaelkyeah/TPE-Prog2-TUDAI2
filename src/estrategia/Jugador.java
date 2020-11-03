package estrategia;

import juego.Carta;

import juego.Mazo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;


public class Jugador {

	private String nombre;
	private Mazo mazoJugador;
	private Estrategia estrategia;
	
	public Jugador (String nombre)
	{
		this.nombre = nombre;
		this.mazoJugador = new Mazo();
	}
	
	public Jugador (Jugador jugador)
	{
		this.nombre = jugador.getNombre();
		this.mazoJugador = jugador.getMazoJugador();
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
	
	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public Carta cartaEnMano()
	{
		return this.mazoJugador.sacarCartaDelMazo();
	}
	
		
	public int cantidadCartas()
	{
		return (this.mazoJugador.getTamanioMazo());
	}
	
	public void recibirCarta(Carta carta)
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
	
	public void cambiarEstrategia(String atributoMano) {
		System.out.println("Seleccione estrategia:");
		System.out.println("1. Ambicioso (\"1\")");
		System.out.println("2. Obstinado (\"2\")");
		System.out.println("3. Timbero (\"3\")");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char opcion = '0';
		Jugador retorno = null;
		try {
			opcion = (char)reader.read();
		}
		catch(Exception e) {
			System.out.println("Opción inválida. No se harán cambios.");
		}
		switch(opcion) {
		case('1'):
				this.setEstrategia(new Ambicioso());
			break;
		case('2'):
				this.setEstrategia(new Obstinado(atributoMano));
			break;
		case('3'):
				this.setEstrategia(new Timbero());
			break;
		default:
				System.out.println("No se harán cambios.");
		}	
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