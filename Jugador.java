package juego;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> mano;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Carta> getMano() {
		return mano;
	}
	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public Jugador ()
	{
		this.setNombre ( "");
		this.mano = new ArrayList<Carta> ();
	}
	
		public Jugador (String Nombre)
	{
		this.setNombre (nombre);
		this.mano = new ArrayList<Carta> ();
	}
	
	public int cantidadCartas()
	{
		return (this.mano.size());
	}
	
	public void recibirCarta(Carta carta)
	{
		this.mano.add(carta);
	}
	
	public String seleccionarAtributo()
	{
		//Validar "entrada" del atributo
		//Hacer de manera aleatoria
		//cambiar por int/double ?
		
		String atributo= "Fuerza";
		return (atributo);
	}
	
	public void estadisticasJugador() //public String?
	{
		System.out.print (this.getNombre()+" posee "+this.cantidadCartas()+" cartas");
	}
	
	public void entregarCarta(Jugador jugador)
	{
		jugador.recibirCarta(this.mano.get(0));
		this.mano.remove(0);
	}
	

	
	public void jugarCarta()
	{
		this.mano.get(0);
		String atributo = seleccionarAtributo();
		/*double aux = this.mano.getatributo;  eeeeeehhhmm*/ 
		
	}

}

