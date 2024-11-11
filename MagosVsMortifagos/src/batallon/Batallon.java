package batallon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import clases.Personaje;
import exception.BatallonAgregarPersonajeNoValidoException;
import hechizos.Hechizo;

public class Batallon{
	//ATRIBUTOS
	private boolean tipo; //Mago: True, Mortifago: False
	private List<Personaje> atacantes;
	private Map<Personaje, List<Hechizo>> personajeHechizo;
	private Set<Hechizo> hechizosUsados;

	//GETTERS & SETTERS
	public void setTipoBatallonMago() {
		tipo = true;
	}
	
	public void setTipoBatallonMortifago() {
		tipo = false;
	}
	
	public List<Personaje> getAtacantes() {
		return atacantes;
	}

	public Map<Personaje, List<Hechizo>> getPersonajeHechizo() {
		return personajeHechizo;
	}

	//CONSTRUCTORES
	public Batallon() {
		this.atacantes = new ArrayList<Personaje>();
		this.personajeHechizo = new HashMap<Personaje, List<Hechizo>>();
		this.hechizosUsados = new HashSet<Hechizo>();
	}
	
	//METODOS
	public void vaciarHechizosUsados() {
		this.hechizosUsados.clear();
	}
	
	public boolean agregarPersonaje(Personaje personaje) {
		if(personaje.esMortifago() && tipo)
			throw new BatallonAgregarPersonajeNoValidoException("El batallon es tipo Mortifagos, no se puede agregar un Mago");
		
		if(personaje.esMago() && !tipo)
			throw new BatallonAgregarPersonajeNoValidoException("El batallon es tipo Mago, no se puede agregar un Mortifago");
		
		if(this.contienePersonaje(personaje))
			return false;
		
		return atacantes.add(personaje);
	}
	
	private Personaje[] getPersonajesVivos() {
		List<Personaje> listaPersonajesVivos = new ArrayList<>();
		for(Personaje personaje : atacantes) {
			if(personaje.estaVivo()) {
				listaPersonajesVivos.add(personaje);
			}
		}
		if(listaPersonajesVivos.isEmpty()) {
			return null;
		}
		Personaje[] vectorPersonajesVivos = listaPersonajesVivos.toArray(new Personaje[0]);
		return vectorPersonajesVivos;
	}
	
	public Personaje getPersonajeVivoAleatorio() {
		Personaje[] personajesVivos = getPersonajesVivos();
		if(personajesVivos == null) {
			return null;
		}
		Random rand = new Random();
		return personajesVivos[rand.nextInt(personajesVivos.length)];
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
			if (atacante.getPuntosVida() <= 0)
				continue;

			if (!atacante.getArmado()) {
				System.out.println(atacante.getNombre() + " quiere atacar, pero está desarmado.");
				continue;
			}
			
			if (oponente.tienePersonajesSaludables()) {
				do {
					indexOponente = random.nextInt(oponente.atacantes.size());
					oponenteSeleccionado = oponente.atacantes.get(indexOponente);
				} while (oponenteSeleccionado.getPuntosVida() <= 0);

				indexHechizo = random.nextInt(atacante.getHechizos().size());
				Hechizo hechizoSeleccionado = atacante.getHechizos().get(indexHechizo);

				if(!this.hechizosUsados.contains(hechizoSeleccionado)) {
					atacante.lanzarHechizo(hechizoSeleccionado, oponenteSeleccionado);
					
					if(!personajeHechizo.containsKey(atacante))
						personajeHechizo.put(atacante, new ArrayList<Hechizo>());
						
					personajeHechizo.get(atacante).add(hechizoSeleccionado);
					hechizosUsados.add(hechizoSeleccionado);
				}
				else
					System.out.println(atacante.getNombre() + " ya lanzó " + hechizoSeleccionado.toString() + " en esta ronda. ¡No se puede repetir!");
			}
		}
	}
	
	public boolean contienePersonaje(Personaje personaje) {
		for(Personaje enLista : atacantes) {
			if(enLista.getNombre().equals(personaje.getNombre())) {
				return true;
			}
		}
		return false;
	}
}
