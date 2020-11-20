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
	
	/**
	 * Devuelve el valor de un atributo que llega por parámetro
	 * Si tiene una pócima devuelve el resultado de la alteración
	 * @param nombreAtributo
	 * @return double
	 */
	public double getValorAtributo(String nombreAtributo) {
		if (this.pocima != null)
			return this.pocima.alterarAtributo(nombreAtributo,this.atributos.get(nombreAtributo));
		return this.atributos.get(nombreAtributo);
	}
	
	/**
	 * Devuelve la cantidad de atributos que tiene una carta
	 * @return int
	 */
	public int getCantidadAtributos() {
		return this.atributos.size();
	}
	
	/**
	 * Devuelve una copia de los nombres de los atributos de la carta
	 * @return List<String>
	 */
	public List<String> getNombresAtributos() {
		List<String> retorno = new ArrayList<>();
		for(String clave:this.atributos.keySet())
			retorno.add(clave);
		return retorno;
	}
	
	/**
	 * Devuelve un String al que se le incluye el nombre de la
	 * carta, el atributo que llega por parámetro y el valor de
	 * dicho atributo en la carta
	 * Si se aplicó una pócima tambien agrega el nombre de dicha
	 * pócima y el efecto resultante
	 * @param atributo
	 * @return String
	 */
	public String getString(String atributo) {
		String retorno = this+" - Valor de atributo "+atributo+": "+this.atributos.get(atributo);
		if(this.pocima != null && this.getValorAtributo(atributo) != this.atributos.get(atributo))
			retorno += " - Se aplica la pócima "+this.pocima+" - valor resultante: "+this.getValorAtributo(atributo);
		return retorno;
	}
	
	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}
		
	/**
	 * Agrega un atributo a la lista de atributos
	 * @param nombreAtributo
	 * @param valor
	 */
	public void agregarAtributo(String nombreAtributo, double valor) {
		this.atributos.put(nombreAtributo, valor);
	}
	
	/**
	 * Busca atributo en el mapa
	 * @param nombreAtributo
	 * @return boolean
	 */
	public boolean contieneAtributo(String nombreAtributo) {
		return this.atributos.containsKey(nombreAtributo);
	}
	
	/**
	 * Determina si la carta cumple el tener exactamente los mismos
	 * atributos que la carta de referencia (el orden es indiferente)
	 * @param cartaDeReferencia
	 * @return boolean
	 */
	public boolean validarCarta(Carta cartaDeReferencia) {
		if(this.getCantidadAtributos() == cartaDeReferencia.getCantidadAtributos()) {
			for(String nombre:this.atributos.keySet())
				if(!cartaDeReferencia.contieneAtributo(nombre))
					return false;
			return true;
		}
		return false;
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
	
}