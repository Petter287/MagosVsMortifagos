package batalla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
//import java.util.Set;

import clases.Personaje;
import hechizos.Hechizo;

public class Batallon {
	private List<Personaje> atacantes = new ArrayList<Personaje>();
	private Map<Personaje, List<Hechizo>> personajeHechizo = new HashMap<Personaje, List<Hechizo>>();
//	private Set<Hechizo> hechizos = new HashSet<Hechizo>();

	public List<Personaje> getAtacantes(){
		return atacantes;
	}
	
	public Map<Personaje, List<Hechizo>> getPersonajeHechizo(){
		return personajeHechizo;
	}
	
	public boolean agregarPersonaje(Personaje personaje) {
		if (personaje == null)
			return false;

		atacantes.add(personaje);
		personajeHechizo.put(personaje, new ArrayList<Hechizo>());
		
		return true;
	}

	public boolean tienePersonajesSaludables() {
		for (Personaje pers : atacantes)
			if (pers.getPuntosVida() > 0)
				return true;

		return false;
	}

	public void atacar(Batallon oponente) {
        Random random = new Random();
        Personaje oponenteSeleccionado;
        int indexOponente, indexHechizo;
        
		for (Personaje atacante : atacantes) {
			if(atacante.getPuntosVida() <= 0)
				continue;
			
			if(!atacante.getArmado()) {
				System.out.println(atacante.getNombre() + " quiere atacar, pero está desarmado.");
				continue;
			}
			
			do {
				indexOponente = random.nextInt(oponente.atacantes.size());
				oponenteSeleccionado = oponente.atacantes.get(indexOponente);
			}
			while(oponente.tienePersonajesSaludables() && oponenteSeleccionado.getPuntosVida() <= 0);
			
			indexHechizo = random.nextInt(atacante.getHechizos().size());
	        Hechizo hechizoSeleccionado = atacante.getHechizos().get(indexHechizo);
	        
	        atacante.lanzarHechizo(hechizoSeleccionado, oponenteSeleccionado);
	        personajeHechizo.get(atacante).add(hechizoSeleccionado);
		}
	}
}
