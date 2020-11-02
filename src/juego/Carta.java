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
	
	
	public void usarPocima(Pocima pocima, String atributoEnJuego)
	{
		int resultado = pocima.alterarCarta(this,atributoEnJuego);
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
