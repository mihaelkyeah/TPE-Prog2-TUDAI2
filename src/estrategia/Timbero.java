package estrategia;

import juego.Carta;

public class Timbero extends Estrategia {
	
	private static final String ESTRATEGIA_NOMBRE_TIMBERO = "Timbero";
	
	public Timbero() {
		super(ESTRATEGIA_NOMBRE_TIMBERO);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		int opcion = (int) (Math.random()* carta.getNombresAtributos().size());
		return (carta.getNombresAtributos().get(opcion));
	}

}
