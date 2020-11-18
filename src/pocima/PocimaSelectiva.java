package pocima;

public class PocimaSelectiva extends Pocima {
	
	private String restriccion;
	private Pocima pocima;

	public PocimaSelectiva(String nombre, String restriccion, Pocima pocima) {
		super(nombre);
		this.restriccion = restriccion;
		this.pocima = pocima;
	}

	public String getRestriccion() {
		return restriccion;
	}

	@Override
	public double alterarAtributo(String atributo, double valor) {
		if (this.getRestriccion().equals(atributo))
			return pocima.alterarAtributo(atributo, valor);
		return valor;
	}

}
