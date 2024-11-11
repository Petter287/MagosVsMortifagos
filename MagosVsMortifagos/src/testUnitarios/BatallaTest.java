package testUnitarios;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import batalla.Batalla;
import batallon.Batallon;
import clases.Personaje;
import clases.PersonajeFactory;
import exception.BatallonNuloException;
import exception.LanzarHechizoVictimaNoValidaException;
import exception.PersonajeHechizoNoDisponibleException;
import hechizos.AvadaKedavra;
import hechizos.Sectumsempra;
import magos.Estudiante;
import magos.Mago;
import magos.TipoMago;
import mortifagos.Mortifago;
import mortifagos.Seguidor;
import mortifagos.TipoMortifago;

class BatallaTest {
	private final InputStream originalIn = System.in;
	private Batalla batalla;
	private Batallon batallonMagos;
	private Batallon batallonMortifagos;

	@BeforeEach
	void inicializar() {
		// Redirige System.in a un InputStream que simula que el usuario presionó Enter
		System.setIn(new ByteArrayInputStream("\n".getBytes()));
		batallonMagos = new Batallon();
		batallonMortifagos = new Batallon();

		Mago auror = PersonajeFactory.crearMago(TipoMago.Auror, "Auror"),
				estudiante = PersonajeFactory.crearMago(TipoMago.Estudiante, "Estudiante"),
				profesor = PersonajeFactory.crearMago(TipoMago.Profesor, "Profesor");

		Mortifago seguidor1 = PersonajeFactory.crearMortifago(TipoMortifago.Seguidor, "Seguidor1"),
				seguidor2 = PersonajeFactory.crearMortifago(TipoMortifago.Seguidor, "Seguidor2"),
				comandante = PersonajeFactory.crearMortifago(TipoMortifago.Comandante, "Comandante");

		batallonMagos.setTipoBatallonMago();
		batallonMortifagos.setTipoBatallonMortifago();
		batallonMagos.agregarPersonaje(auror);
		batallonMagos.agregarPersonaje(estudiante);
		batallonMagos.agregarPersonaje(profesor);
		batallonMortifagos.agregarPersonaje(seguidor1);
		batallonMortifagos.agregarPersonaje(seguidor2);
		batallonMortifagos.agregarPersonaje(comandante);
		batalla = new Batalla(batallonMagos, batallonMortifagos);
	}

	@AfterEach
	void reiniciar() {
		// Restaura System.in después de cada prueba
        System.setIn(originalIn);
		batalla = null;
		batallonMagos = null;
		batallonMortifagos = null;
	}

	@Test
	void batallonMagosIniciaSinMagosEnBatalla() { // ver return realizarBatalla
		batallonMagos = null;

		BatallonNuloException ex = assertThrows(BatallonNuloException.class, () -> {
			new Batalla(batallonMagos, batallonMortifagos);
		});

		assertEquals("Constructor Batalla: batallonMagos no puede ser nulo.", ex.getMessage());
	}

	@Test
	void batallonMortifagosIniciaSinMortifagosEnBatalla() { // ver return realizarBatalla
		batallonMortifagos = null;

		BatallonNuloException ex = assertThrows(BatallonNuloException.class, () -> {
			new Batalla(batallonMagos, batallonMortifagos);
		});

		assertEquals("Constructor Batalla: batallonMortifagos no puede ser nulo.", ex.getMessage());
	}

	@Test
	void batallonMagosIniciaSinSaludablesEnBatalla() throws IOException { // ver return realizarBatalla
		List<Personaje> magos = batallonMagos.getAtacantes();

		for (Personaje mago : magos)
			mago.recibirDanio(mago.getPuntosVida());

		batalla = new Batalla(batallonMagos, batallonMortifagos);
		assertFalse(batalla.simularBatalla());
	}

	@Test
	void batallonMortifagosIniciaSinSaludablesEnBatalla() throws IOException { // ver return realizarBatalla
		List<Personaje> mortifagos = batallonMortifagos.getAtacantes();

		for (Personaje mortifago : mortifagos)
			mortifago.recibirDanio(mortifago.getPuntosVida());

		batalla = new Batalla(batallonMagos, batallonMortifagos);
		assertTrue(batalla.simularBatalla());
	}

	@Test
	void magoLanzaHechizoDeEquipoAenemigo() {
		Mago mago = (Mago) batallonMagos.getPersonajeVivoAleatorio();
		Mortifago mortifago = (Mortifago) batallonMortifagos.getPersonajeVivoAleatorio();

		assertThrows(PersonajeHechizoNoDisponibleException.class,
				() -> batalla.magosAtacan(mago, mortifago, new Sectumsempra()));
	}

	@Test
	void mortifagoLanzaHechizoDeEquipoAenemigo() {
		Mago mago = (Mago) batallonMagos.getPersonajeVivoAleatorio();
		Mortifago mortifago = (Mortifago) batallonMortifagos.getPersonajeVivoAleatorio();

		assertThrows(PersonajeHechizoNoDisponibleException.class,
				() -> batalla.mortifagosAtacan(mortifago, mago, new AvadaKedavra()));
	}

	@Test
	void magoLanzaHechizoDirigidoOponenteAaliado() {
		Mago mago = (Mago) batallonMagos.getPersonajeVivoAleatorio();
		Mago nuevoMago = new Estudiante("nuevo");

		assertThrows(LanzarHechizoVictimaNoValidaException.class,
				() -> batalla.magosAtacan(mago, nuevoMago, new Sectumsempra()));
	}

	@Test
	void mortifagoLanzaHechizoDirigidoOponenteAaliado() {
		Mortifago mortifago = (Mortifago) batallonMortifagos.getPersonajeVivoAleatorio();
		Mortifago nuevoMortifago = new Seguidor("nuevo");

		assertThrows(LanzarHechizoVictimaNoValidaException.class,
				() -> batalla.mortifagosAtacan(mortifago, nuevoMortifago, new Sectumsempra()));
	}

}
