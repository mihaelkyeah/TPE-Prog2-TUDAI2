package juego;

public class Atributo {//Las cartas y las pocimas tienen atributos
	protected String atributo;
	protected Object valor;
	
	// En este caso la carta tendria un arrayList de atributos que debera verificar si ya tiene el atributo
	// De tenerlo actualizar el valor y de no crearlo
	// Siempre tendra que tener un valor porque no existen atributos sin valor
	
	public String getNombre() {
		return  this.atributo;
	}
	public void setNombre(String nombre) {
		this.atributo = nombre;
	}
	
	public Object getValor() {
		return this.valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}

	public Atributo (String nombre, Object valor)
	{
		this.atributo = nombre;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Atributo [atributo=" + atributo + ", valor=" + valor + "]";
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
