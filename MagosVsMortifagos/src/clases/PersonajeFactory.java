package clases;

import hechizos.HechizoFactory;
import hechizos.TipoHechizo;
import magos.*;
import mortifagos.*;

public class PersonajeFactory {
	
	public static Mago crearMago(TipoPersonaje tipo, String nombrePersonaje) {
		
		Mago magoNuevo;
		
		switch (tipo) {	
		
		case TipoPersonaje.Auror:
			magoNuevo = new Auror(nombrePersonaje, 10, 120);
			magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Expelliarmus));
			magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
			break;
		case TipoPersonaje.Estudiante:
			magoNuevo = new Estudiante(nombrePersonaje, 10, 120);
			magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Expelliarmus));
			magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
			break;
		case TipoPersonaje.Profesor:
			magoNuevo = new Profesor(nombrePersonaje, 10, 120);
			magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Expelliarmus));
			magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
			break;
		default:
			throw new IllegalArgumentException("Tipo de mago desconocido");
		}
		return magoNuevo;
	}
	
	public static Mortifago crearMortifago(TipoPersonaje tipo, String nombrePersonaje) {
		
		Mortifago mortifagoNuevo;
		
		switch (tipo) {	
		
		case TipoPersonaje.Comandante:
			mortifagoNuevo = new Comandante(nombrePersonaje, 10, 120);
			mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Expelliarmus));
			mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
			break;
		case TipoPersonaje.Seguidor:
			mortifagoNuevo = new Seguidor(nombrePersonaje, 10, 120);
			mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Expelliarmus));
			mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
			break;
		default:
			throw new IllegalArgumentException("Tipo de mortifago desconocido");
		}
		return mortifagoNuevo;
	}
	
}
