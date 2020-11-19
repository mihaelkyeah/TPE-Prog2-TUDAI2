package estrategia;

import juego.Carta;

//Esta estrategia siempre elige un atributo al azar	
public class EstrategiaTimbero extends Estrategia {
	
	private static final String ESTRATEGIA_NOMBRE_TIMBERO = "Timbero";
	
	public EstrategiaTimbero() {
		super(ESTRATEGIA_NOMBRE_TIMBERO);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		return (carta.getNombresAtributos().get((int)(Math.random()*carta.getCantidadAtributos())));
	}

}
