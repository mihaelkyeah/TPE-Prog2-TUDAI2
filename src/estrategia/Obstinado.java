package estrategia;

import juego.Carta;

public class Obstinado extends Estrategia  {

	private static final String ESTRATEGIA_NOMBRE_OBSTINADO = "Obstinado";
	private String atributoJugando;
	
	public Obstinado(String atributoJugando) {
		super(ESTRATEGIA_NOMBRE_OBSTINADO);
		this.atributoJugando = atributoJugando;
	}

	@Override
	public String elegirAtributo(Carta carta) {
		return this.atributoJugando;
	}

}
