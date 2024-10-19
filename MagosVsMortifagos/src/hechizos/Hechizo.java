package hechizos;

import clases.Personaje;

//Interfaz Hechizo (Strategy)
public interface Hechizo {
	void ejecutar(Personaje lanzador, Personaje objetivo);
}