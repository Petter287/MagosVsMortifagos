package app;


import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import batalla.Batallon;
import clases.Personaje;
import clases.PersonajeFactory;
import clases.TipoPersonaje;
import hechizos.Hechizo;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ronda = 1;
		Batallon batallonMagos = new Batallon();
		Batallon batallonMortifagos = new Batallon();

		for (int i = 0; i < 3; i++) {
			batallonMagos.agregarPersonaje(PersonajeFactory.crearMago(TipoPersonaje.Auror, "Auror0" + i));
			batallonMortifagos.agregarPersonaje(PersonajeFactory.crearMortifago(TipoPersonaje.Comandante, "Comandante0" + i));
		}

		System.out.println("EQUIPO DE MAGOS:");
		for (Personaje personaje : batallonMagos.getAtacantes()) {
			System.out.println(personaje.toString());
		}
		System.out.println();

		System.out.println("EQUIPO DE MORTIFAGOS:");
		for (Personaje personaje : batallonMortifagos.getAtacantes()) {
			System.out.println(personaje.toString());
		}
		System.out.println();

		System.out.println("Presiona Enter para continuar...");
		scanner.nextLine();

		Random rand = new Random();
		while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {
			System.out.println("------------RONDA " + ronda + " ----------------");
			if (rand.nextBoolean()) {
				batallonMagos.atacar(batallonMortifagos);
				if (batallonMortifagos.tienePersonajesSaludables())
					batallonMortifagos.atacar(batallonMagos);
			} else {
				batallonMortifagos.atacar(batallonMagos);
				if (batallonMagos.tienePersonajesSaludables())
					batallonMagos.atacar(batallonMortifagos);
			}
			System.out.println("------------ FIN DE LA RONDA " + ronda + "----------------");

			ronda++;

			System.out.println("EQUIPO DE MAGOS:");
			for (Personaje personaje : batallonMagos.getAtacantes())
				System.out.println(personaje.toString());
			System.out.println();

			System.out.println("EQUIPO DE MORTIFAGOS:");
			for (Personaje personaje : batallonMortifagos.getAtacantes())
				System.out.println(personaje.toString());
			System.out.println();

			System.out.println("Presiona Enter para continuar...");
			scanner.nextLine();
		}

		if (batallonMagos.tienePersonajesSaludables())
			System.out.println("¡Los magos han ganado la batalla!");
		else
			System.out.println("¡Los mortífagos han ganado la batalla!");
		System.out.println();

		System.out.println("HECHIZOS LANZADOS POR LOS MAGOS:");
		for (Entry<Personaje, List<Hechizo>> entry : batallonMagos.getPersonajeHechizo().entrySet()) {
            System.out.println(entry.getKey().getNombre() + " lanzó los siguientes hechizos:");
            for (Hechizo hechizo : entry.getValue()) {
                System.out.println("- " + hechizo);
            }
        }
		
		scanner.close();
	}
}
