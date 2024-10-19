package clases;

import hechizos.HechizoFactory;
import magos.*;
import mortifagos.*;

public class PersonajeFactory {
	public static Personaje crearPersonaje(String tipo, String nombre) {
		switch (tipo) {
		case "Auror":
			Personaje auror = new Auror(nombre, 10, 120);
			auror.agregarHechizo(HechizoFactory.crearHechizo("Expelliarmus"));
			auror.agregarHechizo(HechizoFactory.crearHechizo("Protego"));
			return auror;

		case "Estudiante":
			Personaje estudiante = new Estudiante(nombre, 5, 80);
			estudiante.agregarHechizo(HechizoFactory.crearHechizo("Expelliarmus"));
			return estudiante;

		case "Profesor":
			Personaje profesor = new Profesor(nombre, 8, 100);
			profesor.agregarHechizo(HechizoFactory.crearHechizo("Protego"));
			return profesor;

		case "Seguidor":
			Personaje seguidor = new Seguidor(nombre, 7, 90);
			seguidor.agregarHechizo(HechizoFactory.crearHechizo("Expelliarmus"));
			return seguidor;

		case "Comandante":
			Personaje comandante = new Comandante(nombre, 12, 150);
			comandante.agregarHechizo(HechizoFactory.crearHechizo("Avada Kedavra"));
			comandante.agregarHechizo(HechizoFactory.crearHechizo("Expelliarmus"));
			return comandante;

		default:
			throw new IllegalArgumentException("Tipo de personaje desconocido");
		}
	}
}
