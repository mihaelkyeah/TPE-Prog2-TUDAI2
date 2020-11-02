package pocima;

import juego.Carta;

public class PocimaSeteo extends Pocima {

	private int seteo;
	public PocimaSeteo(String nombre, int seteo) {
		super(nombre);
		this.seteo = seteo;
		// TODO Auto-generated constructor stub
	}

	public PocimaSeteo(String nombre, int seteo, String restriccion) {
		super(nombre, restriccion);
		this.seteo=seteo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int alterarCarta(Carta carta, String atributoAfectado) {
		if (this.getRestriccion().equals(SIN_RESTRICCION))
			return (this.seteo);
		else
		{
			if (this.getRestriccion().equals(atributoAfectado))
				return  (this.seteo);
			else
				return (0);
		}
	}

}
