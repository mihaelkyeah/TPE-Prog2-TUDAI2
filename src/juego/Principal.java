package juego;

import estrategia.Jugador;
import pocima.*;
import estrategia.*;
import java.util.ArrayList;

// Líneas 155-156 en la clase Juego:
// Ofrecen a los jugadores la posibilidad de cambiar de estrategia al final de cada ronda 

public class Principal {

    public static void main(String[] args) {
    	
        String mazoPath = "./autos.json";
        Mazo mazoAux = new Mazo();
        mazoAux.crearMazo(mazoPath);
        
        ArrayList <Pocima> listaPocimas = new ArrayList <Pocima>();
        Jugador jugador1 = new Jugador("jugador 1");
        Jugador jugador2 = new Jugador("jugador 2");
        Jugador jugador3 = new Jugador("jugador 3");
        Jugador jugador4 = new Jugador("jugador 4");
        Jugador jugador5 = new Jugador("jugador 5");
        
        /*
        jugador1.setEstrategia(new EstrategiaObstinado("Km/h"));
        jugador2.setEstrategia(new EstrategiaObstinado("HP"));
        jugador3.setEstrategia(new EstrategiaObstinado("Cilindros"));
        jugador4.setEstrategia(new EstrategiaTimbero());
        */
        jugador1.setEstrategia(new EstrategiaAmbicioso());
        jugador2.setEstrategia(new EstrategiaAmbicioso());
        jugador3.setEstrategia(new EstrategiaAmbicioso());
        jugador4.setEstrategia(new EstrategiaAmbicioso());
        jugador5.setEstrategia(new EstrategiaAmbicioso());
        
        Juego juego = new Juego(mazoPath);
        juego.agregarJugador(jugador1);
        juego.agregarJugador(jugador2);
		juego.agregarJugador(jugador3);
		juego.agregarJugador(jugador4);
		juego.agregarJugador(jugador5);
		
		Pocima pocima1 = new PocimaPorcentaje("Pocion Reductora",0.50,"Km/h");
		Pocima pocima2 = new PocimaSeteo("Numero Mágico",23);
		Pocima pocima3 = new PocimaPorcentaje("Pocion Aumentadora",1.25);
		Pocima pocima4 = new PocimaPorcentaje("Pocion Aumentadora más polenta",2.25);
		Pocima pocimaCocktail = new PocimaCocktail("VamoAVerQueSale",pocima1,pocima3);
		Pocima pocimaCocktail2 = new PocimaCocktail("sasarasa",pocima4,pocima1);
		Pocima pocimaCocktailLoco = new PocimaCocktail("Cocktail Loco",pocimaCocktail,pocimaCocktail2);
		
		listaPocimas.add(pocima1);
		listaPocimas.add(pocima2);
		listaPocimas.add(pocima3);
		listaPocimas.add(pocimaCocktail);
		listaPocimas.add(pocimaCocktail2);
		listaPocimas.add(pocimaCocktailLoco);
		
       	juego.repartirCartas(listaPocimas);
       	
       	juego.Ronda();
       	
    }
    	
}
