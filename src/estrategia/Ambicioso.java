package estrategia;

import juego.Atributo;
import juego.Carta;
import java.util.ArrayList;

public class Ambicioso extends Estrategia  {
	
	private static final String ESTRATEGIA_NOMBRE_AMBICIOSO = "Ambicioso";
	
	public Ambicioso() {
		super(ESTRATEGIA_NOMBRE_AMBICIOSO);
	}

	@Override
	public String elegirAtributo(Carta carta) {
		
		ArrayList<String> nombres = carta.getNombresAtributos();
		String nombre = "";
		int aux = -1;
		for (String nombreAtributo: nombres)
			if (carta.getValor(nombreAtributo) > aux) {
				nombre = nombreAtributo;
				aux = carta.getValor(nombreAtributo);
			}
		return nombre;
		
		// return (carta.getAtributoMayor());
		
	}

}
