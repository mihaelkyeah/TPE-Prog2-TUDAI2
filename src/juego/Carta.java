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
	
	public Carta(Carta carta) {
		this.nombre = carta.getNombre();
		this.atributos = new ArrayList<>(carta.getCopiaAtributos());
		this.pocima = carta.getPocima();
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
		{
			this.pocima = pocima;
		}
	}
	
	public Atributo getAtributo(String atributo)
	{//Devolver atributo por nombre
		for (Atributo a: this.atributos)
			if (a.getNombre().equals(atributo))
				return(a);
		return null;
	}
	
	public Atributo getAtributo(int indice)
	{//Devolver atributo por posicion en el ArrayList
		return (this.atributos.get(indice));
	}
	
	
	public void agregarAtributo(Atributo atributo)
	{
		Atributo aux = this.getAtributo(atributo.getNombre()); //Se fija si el atributo ya existe
		if (aux == null)
			this.atributos.add(atributo); //Si no esta lo agrega
		else
			aux.setValor(atributo.getValor()); //Si ya existe lo modifica
	}
	
	public int getValor(String atributo)
	{//Devolver valor de un atributo por su nombre
		Atributo aux = this.getAtributo (atributo);
		if (aux == null)
			return 0; //si el atributo no existe devuelve 0
		else
			return (aux.getValor());
	}
	
	public int getValor(Atributo atributo)
	{//Devolver valor de un atributo de manera directa
		return (atributo.getValor());
	}
	
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
	
	public int cantidadAtributos()
	{
		return this.atributos.size();
	}
	
	
	public int usarPocima(Pocima pocima, String atributoEnJuego)
	{	
		if (pocima == null)
			return this.getValor(atributoEnJuego);
		else {
			int resultado = pocima.alterarCarta(this,atributoEnJuego);
			if(resultado != 0) {
				System.out.println("Se aplica la p�cima "+pocima+" - Valor resultante = "+resultado);
				// Cuando la p�cima se usa, se gasta
				// O_O
				this.pocima = null;
				return resultado;
			}
			else
				return this.getValor(atributoEnJuego);
		}
		
	}
	
	
	public Carta copiarCarta() {
		Carta retorno = new Carta(this.nombre);
		ArrayList<Atributo> atributosCarta = this.getCopiaAtributos();
		for(Atributo a:atributosCarta)
			retorno.agregarAtributo(a);
		retorno.setPocima(this.pocima);
		return retorno;
	}
	
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
