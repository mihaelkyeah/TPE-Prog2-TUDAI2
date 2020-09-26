package juego;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private Mazo mazoJugador;
	
	public Jugador ()
	{
		this.setNombre ("");
		this.mazoJugador = new Mazo();
	}
	
		public Jugador (String Nombre)
	{
		this.setNombre (nombre);
		this.mazoJugador = new Mazo();
	}
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// El jugador devuelve las cartas de su mazo al mazo original
	public void devolverMazo(Mazo mazo) {
		while(mazoJugador.getTamanioMazo() > 0) {
			mazo.agregarCartaAlMazo(mazoJugador.sacarCartaDelMazo());
		}
	}
	
	public int cantidadCartas()
	{
		return (this.mazoJugador.getTamanioMazo());
	}
	
	public void recibirCarta(Carta carta)
	{
		this.mazoJugador.agregarCartaAlMazo(carta);
	}
	
	public String seleccionarAtributo()
	{
		//Validar "entrada" del atributo
		//Hacer de manera aleatoria
		//cambiar por int/double ?
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add("Altura");
		atributos.add("Fuerza");
		atributos.add("PeleasGanadas");
		atributos.add("Peso");
		atributos.add("Velocidad");
		
		int opcion = (int) (Math.random()*5);
		
		String atributo = atributos.get(opcion);
		return ("get"+atributo);
	}
	
	public void estadisticasJugador() //public String?
	{
		
		System.out.print (this.getNombre()+" posee "+this.cantidadCartas()+" cartas");
	}
	
	public void entregarCarta(Jugador jugador)
	{
		jugador.recibirCarta(this.mazoJugador.sacarCartaDelMazo());
	}
	

	
	public void jugarCarta()
	{
		Carta carta = mazoJugador.sacarCartaDelMazo();
		String strAux = this.seleccionarAtributo();
		try {
		
		/**
		 * Idea: que Java interprete al String strAux como un método para llamar
		 * {
		 * 	double dblAux = this.mazoJugador.get(0).strAux;
		 * 	
		 * }
		 * Alternativa: USAR SWITCH
		 */
		}
		catch(Exception e) {
			System.out.println("E");
		}
	}

}

