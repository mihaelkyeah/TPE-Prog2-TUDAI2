package estrategia;

import juego.Carta;

//Esta estrategia siempre elige el mismo atributo
public class EstrategiaObstinado extends Estrategia  {
	
	private static final String ESTRATEGIA_NOMBRE_OBSTINADO = "Obstinado";
	private String atributoJugando;
	
	public EstrategiaObstinado(String atributoJugando) {
		super(ESTRATEGIA_NOMBRE_OBSTINADO);
		this.atributoJugando = atributoJugando;
	}

	@Override
	public String elegirAtributo(Carta carta) {
		return this.atributoJugando;
	}

}
