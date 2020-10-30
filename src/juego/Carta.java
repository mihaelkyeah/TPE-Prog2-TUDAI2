package juego;

import java.util.ArrayList;


public class Carta{
	
	private String nombre;
	private ArrayList <Atributo> atributos;
	
	public Carta (String nombre)
	{
		this.nombre = nombre;
		this.atributos =  new ArrayList <Atributo>();
	}
	
	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	public int cantidadAtributos()
	{
		return this.atributos.size();
	}
	
	public Atributo getAtributo(String atributo)
	{
		for (Atributo listaAtributos: this.atributos)
			if (listaAtributos.getNombre().equals(atributo))
				return(listaAtributos);
		return null;
	}
	
	public void agregarAtributo(Atributo atributo)
	{
		Atributo aux = this.getAtributo(atributo.getNombre());
		if (aux == null)
			this.atributos.add(atributo);
		else
			aux.setValor(atributo.getValor());
	}
	
	public String getAtributo(int indice)
	{
		try {
			return (this.atributos.get(indice).getNombre());}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public Object getValor(String atributo)
	{
		Atributo aux = getAtributo (atributo);
		if (aux == null)
			return 0;
		else
			return (aux.getValor());
	}
	
	public int getValor(Atributo atributo)
	{
		return ((int) atributo.getValor());
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
	

	

	
}
