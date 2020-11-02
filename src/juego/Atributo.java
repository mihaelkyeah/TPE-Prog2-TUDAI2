package juego;

public class Atributo {
	protected String atributo;
	protected int valor;
	
	public Atributo (String nombre, int valor)
	{
		this.atributo = nombre;
		this.valor = valor;
	}
	
	public String getNombre() {
		return  this.atributo;
	}
	public void setNombre(String nombre) {
		this.atributo = nombre;
	}
	
	public int getValor() {
		return this.valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	// Hace un deep clone de un atributo (con una nueva dirección de memoria)
	public Atributo copiarAtributo() {
		String nombreNuevo = this.getNombre();
		int valorNuevo = this.getValor();
		Atributo retorno = new Atributo(nombreNuevo,valorNuevo);
		return retorno;
	}
	
	@Override
	public String toString() {
		return ("[atributo=" + atributo + ", valor=" + valor + "]");
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		try {
			Atributo aux = (Atributo) o;
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
