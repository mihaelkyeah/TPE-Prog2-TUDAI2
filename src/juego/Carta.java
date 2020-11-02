package juego;

import java.util.ArrayList;

import pocima.Pocima;


public class Carta{
	
	private String nombre;
	private ArrayList <Atributo> atributos;
	private Pocima pocima;
	
	public Carta (String nombre)
	{
		this.nombre = nombre;
		this.atributos =  new ArrayList <Atributo>();
		this.pocima =  null;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Pocima getPocima()
	{
		return (this.pocima);
	}
	
	public void setPocima(Pocima pocima)
	{
		if (this.pocima == null)
			this.pocima = pocima;
	}
	
	//Devolver atributo por nombre
	public Atributo getAtributo(String atributo) {
		for (Atributo a: this.atributos)
			if (a.getNombre().equals(atributo))
				return(a);
		return null;
	}
	
	//Devolver atributo por posicion en el ArrayList
	public Atributo getAtributo(int indice) {
		return (this.atributos.get(indice));
	}
	
	// Agrega un atributo a la lista de atributos
	public void agregarAtributo(Atributo atributo)
	{
		Atributo aux = this.getAtributo(atributo.getNombre()); //Se fija si el atributo ya existe
		if (aux == null)
			this.atributos.add(atributo); //Si no esta lo agrega
		else
			aux.setValor(atributo.getValor()); //Si ya existe lo modifica
	}
	
	//Devolver valor de un atributo por su nombre
	public int getValor(String atributo) {
		Atributo aux = this.getAtributo (atributo);
		if (aux == null)
			return 0; //si el atributo no existe devuelve 0
		else
			return (aux.getValor());
	}
	
	//Devolver valor de un atributo de manera directa
	public int getValor(Atributo atributo) {
		return (atributo.getValor());
	}
	
	// Devuelve el nombre del atributo con mayor valor de la estructura 
	public String getAtributoMayor()
	{
		Atributo aux = new Atributo("", -1);
		for (Atributo atributo: this.atributos)
			if ((int)atributo.getValor() > (int)aux.getValor())
			{
				aux.setNombre(atributo.getNombre());
				aux.setValor(atributo.getValor());
			}
		return (aux.getNombre());
	}
	
	// Devuelve la cantidad de atributos que tiene una carta
	public int cantidadAtributos() {
		return this.atributos.size();
	}
	
	// Aplica el efecto de una pócima al valor de una carta
	// sin afectar la carta del mazo, sólo afectando el valor de la carta en la jugada
	public int usarPocima(Pocima pocima, String atributoEnJuego)
	{	
		if (pocima == null)
			return this.getValor(atributoEnJuego);
		else {
			int resultado = pocima.alterarCarta(this,atributoEnJuego);
			if(resultado != 0) {
				System.out.println("Se aplica la pócima "+pocima+" - Valor resultante = "+resultado);
				// Cuando la pócima se usa, se gasta
				// O_O
				this.pocima = null;
				return resultado;
			}
			else
				return this.getValor(atributoEnJuego);
		}
		
	}
	
	// Hace un deep clone de una carta
	// (con direcciones nuevas de memoria para la instancia y sus atributos)
	public Carta copiarCarta() {
		Carta retorno = new Carta(this.nombre);
		ArrayList<Atributo> atributosCarta = this.getCopiaAtributos();
		for(Atributo a:atributosCarta)
			retorno.agregarAtributo(a);
		retorno.setPocima(this.pocima);
		return retorno;
	}
	
	// Hace un deep clone de la estructura de atributos que tiene la carta
	public ArrayList<Atributo> getCopiaAtributos() {
		ArrayList<Atributo> retorno = new ArrayList<>();
		for(Atributo a:this.atributos) {
			Atributo nuevo = a.copiarAtributo();
			retorno.add(nuevo);
		}
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		try {
			Carta aux = (Carta) o;
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
