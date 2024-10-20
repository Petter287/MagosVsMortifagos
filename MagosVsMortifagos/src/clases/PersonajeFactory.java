package clases;

import hechizos.HechizoFactory;
import hechizos.TipoHechizo;
import magos.*;
import mortifagos.*;

public class PersonajeFactory {
	private static final int PUNTOS_VIDA = 100;
	private static final boolean ARMADO = true;
	private static final boolean PROTEGIDO = false;
	
	public static Mago crearMago(TipoPersonaje tipo, String nombrePersonaje) {
		Mago magoNuevo;

		switch (tipo) {
		case TipoPersonaje.Auror:
			magoNuevo = new Auror(nombrePersonaje, 10, PUNTOS_VIDA, ARMADO, PROTEGIDO);
			break;

		case TipoPersonaje.Profesor:
			magoNuevo = new Profesor(nombrePersonaje, 5, PUNTOS_VIDA, ARMADO, PROTEGIDO);
			break;
			
		case TipoPersonaje.Estudiante:
			magoNuevo = new Estudiante(nombrePersonaje, 3, PUNTOS_VIDA, ARMADO, PROTEGIDO);
			break;

		default:
			throw new IllegalArgumentException("Tipo de mago desconocido");
		}
		
		magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Expelliarmus));
		magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
		magoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Sectumsempra));
		
		return magoNuevo;
	}

	public static Mortifago crearMortifago(TipoPersonaje tipo, String nombrePersonaje) {
		Mortifago mortifagoNuevo;

		switch (tipo) {
		case TipoPersonaje.Comandante:
			mortifagoNuevo = new Comandante(nombrePersonaje, 10, PUNTOS_VIDA, ARMADO, PROTEGIDO);
			break;
			
		case TipoPersonaje.Seguidor:
			mortifagoNuevo = new Seguidor(nombrePersonaje, 3, PUNTOS_VIDA, ARMADO, PROTEGIDO);
			break;
			
		default:
			throw new IllegalArgumentException("Tipo de mortifago desconocido");
		}
		
		mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.AvadaKedavra));
		mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Crusio));
		mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Imperio));
		mortifagoNuevo.agregarHechizo(HechizoFactory.crearHechizo(TipoHechizo.Protego));
		
		return mortifagoNuevo;
	}

}
