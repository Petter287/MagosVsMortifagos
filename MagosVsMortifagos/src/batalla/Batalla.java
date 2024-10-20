package batalla;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

import clases.Personaje;
import clases.PersonajeFactory;
import clases.TipoPersonaje;
import hechizos.Hechizo;

public class Batalla {
	// ATRIBUTOS
	Scanner scanner;
	private static final int CANT_PERSONAJES = 3;
	Batallon batallonMagos;
	Batallon batallonMortifagos;

	// CONSTRUCTORES
	public Batalla() {
		this.batallonMagos = new Batallon();
		this.batallonMortifagos = new Batallon();
	}

	// METODOS
	// Obtener un tipo de personaje basado en un rango. 1 - 3: Magos; 4 - 5:
	// Mortifagos
	public static TipoPersonaje getRandomDeRango(int minIndex, int maxIndex) {
		Random random = new Random();
		TipoPersonaje[] valores = TipoPersonaje.values();

		int index = random.nextInt((maxIndex - minIndex) + 1) + minIndex;
		return valores[index - 1];
	}

	// Generar el batallón de magos.
	private void generarBatallonMagos() {
		for (int i = 0; i < CANT_PERSONAJES; i++) {
			TipoPersonaje magoSeleccionado = getRandomDeRango(1, 3);
			this.batallonMagos.agregarPersonaje(
					PersonajeFactory.crearMago(magoSeleccionado, magoSeleccionado.toString() + "0" + i));
		}
	}

	// Generar el batallón de mortífagos.
	private void generarBatallonMortifagos() {
		for (int i = 0; i < CANT_PERSONAJES; i++) {
			TipoPersonaje mortifagoSeleccionado = getRandomDeRango(4, 5);
			this.batallonMortifagos.agregarPersonaje(
					PersonajeFactory.crearMortifago(mortifagoSeleccionado, mortifagoSeleccionado.toString() + "0" + i));
		}
	}

	// Ver estado batallon.
	private void verBatallon(Batallon batallon) {
		for (Personaje personaje : batallon.getAtacantes())
			System.out.println(personaje.toString());
		
		System.out.println();
	}

	// Realizar una ronda.
	private void realizarRonda(int ronda) {
		Random random = new Random();

		System.out.println("------------RONDA " + ronda + " ----------------");
		if (random.nextBoolean()) {
			this.batallonMagos.atacar(this.batallonMortifagos);
			if (this.batallonMortifagos.tienePersonajesSaludables())
				this.batallonMortifagos.atacar(this.batallonMagos);
		} else {
			this.batallonMortifagos.atacar(batallonMagos);
			if (batallonMagos.tienePersonajesSaludables())
				batallonMagos.atacar(this.batallonMortifagos);
		}

		this.batallonMagos.vaciarHechizosUsados();
		this.batallonMortifagos.vaciarHechizosUsados();
		System.out.println("------------ FIN DE LA RONDA " + ronda + "----------------");

		System.out.println();
		this.verBatallon(this.batallonMagos);
		this.verBatallon(this.batallonMortifagos);

		System.out.println("Presiona Enter para continuar...");
		scanner.nextLine();
	}

	// Ver hechizos lanzados.
	private void verHechizosLanzados(Batallon batallon) {
		for (Entry<Personaje, List<Hechizo>> entry : batallon.getPersonajeHechizo().entrySet()) {
			if (!entry.getValue().isEmpty()) {
				//Si el personaje lanzó hechizos
				System.out.println(entry.getKey().getNombre() + " lanzó los siguientes hechizos:");
				for (Hechizo hechizo : entry.getValue())
					System.out.println("- " + hechizo);
			} else
				System.out.println("No lanzó hechizos.");
				
			System.out.println();
		}
	}

	// Simular la batalla entre los batallones.
	public void simularBatalla() {
		scanner = new Scanner(System.in);
		int ronda = 1;

		if (this.batallonMagos == null) {
			scanner.close();
			throw new RuntimeException("No hay batallon de Magos para la batalla.");
		}

		if (this.batallonMortifagos == null) {
			scanner.close();
			throw new RuntimeException("No batallon de Mortífagos para la batalla.");
		}

		this.generarBatallonMagos();
		this.generarBatallonMortifagos();

		System.out.println("ESTADO INICIAL DE LOS BATALLONES:");
		System.out.println("BATALLÓN DE MAGOS:");
		verBatallon(this.batallonMagos);
		
		System.out.println("BATALLÓN DE MORTIFAGOS:");
		verBatallon(this.batallonMortifagos);

		System.out.println("Presiona Enter para continuar...");
		scanner.nextLine();

		//Se realizará ronas hasta que alguno de los batallones no tenga personajes con vida.
		while (this.batallonMagos.tienePersonajesSaludables() && this.batallonMortifagos.tienePersonajesSaludables()) {
			realizarRonda(ronda);
			ronda++;
		}

		if (this.batallonMagos.tienePersonajesSaludables())
			System.out.println("¡Los magos han ganado la batalla!");
		else
			System.out.println("¡Los mortífagos han ganado la batalla!");
		System.out.println();

		System.out.println("HECHIZOS LANZADOS POR LOS MAGOS:");
		verHechizosLanzados(this.batallonMagos);
		
		System.out.println("HECHIZOS LANZADOS POR LOS MORTIFAGOS:");
		verHechizosLanzados(this.batallonMortifagos);

		scanner.close();
	}
}
