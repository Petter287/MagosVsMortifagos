package batalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import clases.Personaje;
import hechizos.Hechizo;

public class Batallon {

	private ArrayList <Personaje> atacantes = new ArrayList<> ();
	private HashMap <String, Hechizo> personajeHechizo = new HashMap<> (); 
	private HashSet <Hechizo> hechizos = new HashSet<> ();
	
	
	public boolean agregarPersonaje(Personaje personaje) {
		if(personaje == null) {
			return false;
		}
		atacantes.add(personaje);
		return true;
	}
	
	public boolean tienePersonajesSaludables() {
	
		for(Personaje pers : atacantes) {
			if(pers.getPuntosVida() > 0) {
				return true;
			}
		}
		
		return false;
	}

	public void atacar(Batallon oponente) {
		
		
	}
}
