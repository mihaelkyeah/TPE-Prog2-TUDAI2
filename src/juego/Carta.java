package juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pocima.Pocima;


public class Carta {
	
	private String nombre;
	private Map<String,Double> atributos;
	private Pocima pocima;
	
	public Carta (String nombre) {
		this.nombre = nombre;
		this.atributos = new HashMap<>();
		this.pocima = null;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Pocima getPocima() {
		return (this.pocima);
	}
	
	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}
	
	// Buscar atributo en el mapa
	public boolean contieneAtributo(String nombreAtributo) {
		return this.atributos.containsKey(nombreAtributo);
	}
	
	// Devuelve el valor de un atributo por nombre
	public double getValorAtributo(String nombreAtributo) {
		if (this.pocima != null)
			return this.pocima.alterarAtributo(nombreAtributo,this.atributos.get(nombreAtributo));
		return this.atributos.get(nombreAtributo);
	}
	
	// Agrega un atributo a la lista de atributos
	public void agregarAtributo(String nombreAtributo, double valor) {
		this.atributos.put(nombreAtributo, valor);
	}
	
	// Devuelve la cantidad de atributos que tiene una carta
	public int getCantidadAtributos() {
		return this.atributos.size();
	}
	
	public boolean validarCarta(Carta cartaDeReferencia) {
		if(this.getCantidadAtributos() == cartaDeReferencia.getCantidadAtributos()) {
			for(String nombre:this.atributos.keySet())
				if(!cartaDeReferencia.getNombresAtributos().contains(nombre))
					return false;
			return true;
		}
		return false;
    }
	
	// Devuelve los nombres de los atributos de la carta
	public List<String> getNombresAtributos() {
		ArrayList<String> retorno = new ArrayList<>();
		for(String clave:this.atributos.keySet())
			retorno.add(clave);
		return retorno;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public boolean equals(Object o) {
		try {
			Carta aux = (Carta) o;
			if (this.getNombre().equalsIgnoreCase(aux.getNombre()))
				return true;
			else
				return false;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public String getString(String atributo) {
		String retorno = this+" - Valor de atributo "+atributo+": "+this.atributos.get(atributo);
		if(this.pocima != null && this.getValorAtributo(atributo) != this.atributos.get(atributo))
			retorno += " - Se aplica la pócima "+this.pocima+" - valor resultante: "+this.getValorAtributo(atributo);
		return retorno;
	}
	
}