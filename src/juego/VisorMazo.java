package juego;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;


public class VisorMazo { //futuro Main TT.TT


    public static void main(String[] args) {
        String mazoPath = "./superheroes.json";
        Mazo mazoAux = new Mazo();
        mazoAux.crearMazo(mazoPath);
        for (int i= 0 ; i < mazoAux.getTamanioMazo(); i ++)
        {
        	Carta cartaAux = mazoAux.sacarCartaDelMazo();
        	System.out.println(cartaAux);
        }
    }

}
