package estrategia;

import juego.Carta;
import java.util.ArrayList;
import java.util.List;

public class EstrategiaAmbicioso extends Estrategia  {
	
	private static final String ESTRATEGIA_NOMBRE_AMBICIOSO = "Ambicioso";
	
	public EstrategiaAmbicioso() {
		super(ESTRATEGIA_NOMBRE_AMBICIOSO);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		// ¿Se puede hacer así o debería hacer new ArrayList<>(carta.getNombresAtributos())?
		return carta.getMayorAtributo();
	}

}
