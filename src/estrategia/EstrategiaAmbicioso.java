package estrategia;

import juego.Carta;

//Esta estrategia siempre elige el atributo con mayor valor
public class EstrategiaAmbicioso extends Estrategia  {
	
	private static final String ESTRATEGIA_NOMBRE_AMBICIOSO = "Ambicioso";
	
	public EstrategiaAmbicioso() {
		super(ESTRATEGIA_NOMBRE_AMBICIOSO);
	}

	/**
	 * El jugador ambicioso elige el atributo de la carta
	 * que tenga el valor más alto
	 * @param carta
	 * @return String
	 */
	@Override
	public String elegirAtributo(Carta carta) {
		double aux = 0;
		String mayor = "";
		for(String atributo:carta.getNombresAtributos()) {
			if(carta.getValorAtributo(atributo) > aux) {
				aux = carta.getValorAtributo(atributo);
				mayor = atributo;
			}
		}
		return mayor;
	}

}
