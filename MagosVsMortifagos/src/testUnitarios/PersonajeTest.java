package testUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exception.PersonajeHechizoNoDisponibleException;
import hechizos.*;
import magos.Auror;
import magos.Mago;
import mortifagos.Mortifago;
import mortifagos.Seguidor;


class PersonajeTest {
	
	private Mago mago;
	private Mortifago mortifago;

	@BeforeEach
	void inicializar() {
		mago = new Auror("Mago00");
		mortifago = new Seguidor("Mortifago00");
	}
	
	@AfterEach
	void reiniciar() {
		mago = null;
		mortifago = null;
	}
	
	@Test
	void personajeAgregaHechizoDuplicado() {
		mago.agregarHechizo(new Sectumsempra());
		assertTrue(mago.agregarHechizo(new Sectumsempra()));
	}
	

	@Test
	void personajeLanzaHechizoNoDispone() {
		assertThrows(PersonajeHechizoNoDisponibleException.class,
				() -> mago.lanzarHechizo(new Sectumsempra(), mortifago));
	}
	
	@Test
	void personajeRecibeDanioNegativo() {
		assertFalse(mago.recibirDanio(-10));
	}

	@Test
	void personajeRecibeDanioEstandoMuerto() {
		float hp = mago.getPuntosVida();
		mago.recibirDanio(hp);
		assertFalse(mago.recibirDanio(10));
	}
}
