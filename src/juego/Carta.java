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
		if (this.pocima == null)
			this.pocima = pocima;
	}
	
	//Buscar atributo en el mapa
	public boolean estaAtributo(String nombreAtributo) {
		for(String clave:this.atributos.keySet())
			if(nombreAtributo.equalsIgnoreCase(clave))
				return true;
		return false;
	}
	
	// Devuelve el valor de un atributo por nombre
	public double getValorAtributo(String nombreAtributo) {
		return this.atributos.get(nombreAtributo);
	}
	
	/**
	 * Devuelve el atributo de la carta con mayor valor con la pócima aplicada
	 * si la carta tiene (para estrategia ambicioso)
	 * (¿no sé si esto estará bien?)
	 * @return string
	 */
	public String getMayorAtributo() {
		String retorno = "";
		double aux = -1;
		for(String atributo:this.atributos.keySet()) {
			if(this.usarPocima(atributo) > aux) {
				aux = this.atributos.get(atributo);
				retorno = atributo;
			}
		}
		return retorno;
	}
	
	// Agrega un atributo a la lista de atributos
	public void agregarAtributo(String nombreAtributo, double valor) {
		this.atributos.put(nombreAtributo, valor);
	}
	
	// Devuelve la cantidad de atributos que tiene una carta
	public int getCantidadAtributos() {
		return this.atributos.size();
	}
	
	// Aplica el efecto de una pócima al valor de una carta
	// sin afectar la carta del mazo, sólo afectando el valor de la carta en la jugada
	public double usarPocima(String atributoEnJuego) {	
		if (this.pocima != null) {
			return this.pocima.alterarAtributo(atributoEnJuego,this.getValorAtributo(atributoEnJuego));
		}
		return this.getValorAtributo(atributoEnJuego);
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
	
}