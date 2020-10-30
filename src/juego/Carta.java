package juego;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Carta{
	
	private String nombre;
	private Map<String, Integer> atributos;
	
	
	public Carta (String nombre)
	{
		this.nombre = nombre;
		Map<String, Integer> atributos = new HashMap<>();
	}
	
	public void agregarAtributo(String atributo, int valor)
	{
		this.atributos.put(atributo, valor);
	}
	
	public int cantidadAtributos()
	{
		return this.atributos.size();
	}
	
	public Object getValor(String atributo)
	{
		return (this.atributos.get(atributo));
	}
	
	public String getAtributo(int opcion)
	{
		return ((String) (this.atributos.keySet().toArray()[opcion]));
	}

	public Map<String, Integer> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, Integer> atributos) {
		this.atributos = atributos;
	}
	
	
}
