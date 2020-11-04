package estrategia;

import juego.Carta;

import juego.Mazo;


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

	@Override
	public String toString() {
		return getNombre();
	}

	@Override
	public boolean equals(Object o) {
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