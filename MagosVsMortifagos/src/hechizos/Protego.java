package hechizos;

import clases.Personaje;

public class Protego implements Hechizo {
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		if (!lanzador.getProtegido()) {
			lanzador.setProtegido(true);
			System.out.println(lanzador.getNombre() + " lanza Protego y se protege de los ataques.");
		} else
			System.out.println(lanzador.getNombre() + " lanza Protego, pero ya estaba protegido.");
	}

	@Override
	public String toString() {
		return "Protego";
	}
}