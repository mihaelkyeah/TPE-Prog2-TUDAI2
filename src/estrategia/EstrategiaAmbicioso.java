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
