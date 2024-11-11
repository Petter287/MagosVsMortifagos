package batalla;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import app.Main;

import java.util.Map.Entry;

import batallon.*;
import clases.*;
import exception.*;
import hechizos.*;
import magos.*;
import mortifagos.*;

public class Batalla{
	// ATRIBUTOS
	private static final boolean GANADOR_MAGOS = true;
	private static final boolean GANADOR_MORTIFAGOS = false;

	Scanner scanner;
	Batallon batallonMagos;
	Batallon batallonMortifagos;
	private boolean flagTurno; //Mago: True, Mortifago: False

	// CONSTRUCTORES
	public Batalla(Batallon batallonMagos, Batallon batallonMortifagos) {
		if (batallonMagos == null)
			throw new BatallonNuloException("Constructor Batalla: batallonMagos no puede ser nulo.");

		if (batallonMortifagos == null)
			throw new BatallonNuloException("Constructor Batalla: batallonMortifagos no puede ser nulo.");

		this.batallonMagos = batallonMagos;
		this.batallonMortifagos = batallonMortifagos;

		Random rand = new Random();
		flagTurno = rand.nextBoolean();
	}

	// METODOS
	// Ver estado batallon.
	private void verBatallon(Batallon batallon) {
		for (Personaje personaje : batallon.getAtacantes())
			System.out.println(personaje.toString());

		System.out.println();
	}

	// Ver hechizos lanzados.
	private void verHechizosLanzados(Batallon batallon) {
		for (Entry<Personaje, List<Hechizo>> entry : batallon.getPersonajeHechizo().entrySet()) {
			if (!entry.getValue().isEmpty()) {
				// Si el personaje lanzó hechizos
				System.out.println(entry.getKey().getNombre() + " lanzó los siguientes hechizos:");
				for (Hechizo hechizo : entry.getValue())
					System.out.println("- " + hechizo);
			} else
				System.out.println("No lanzó hechizos.");

			System.out.println();
		}
	}

	private void magosAtacan() {
		this.batallonMagos.atacar(this.batallonMortifagos);
		if (this.batallonMortifagos.tienePersonajesSaludables())
			this.batallonMortifagos.atacar(this.batallonMagos);
	}

	public int magosAtacan(Mago origen, Personaje destino, Hechizo hechizo) {
		if (destino.esMago())
			throw new LanzarHechizoVictimaNoValidaException(origen + " no puede lanzar hechizo a " + destino + ". Fuego amigo.");
		
		return origen.lanzarHechizo(hechizo, destino);
	}
	
	private void mortifagosAtacan() {
		this.batallonMortifagos.atacar(batallonMagos);
		if (batallonMagos.tienePersonajesSaludables())
			batallonMagos.atacar(this.batallonMortifagos);
	}
	
	public int mortifagosAtacan(Mortifago origen, Personaje destino, Hechizo hechizo) {
		if (destino.esMortifago())
			throw new LanzarHechizoVictimaNoValidaException(origen + " no puede lanzar hechizo a " + destino + ". Fuego amigo.");
		
		return origen.lanzarHechizo(hechizo, destino);
	}

	// Realizar una ronda.
	private void realizarRonda(int ronda) throws IOException {
		System.out.println("------------RONDA " + ronda + " ----------------");
		if (flagTurno)
			magosAtacan();
		else
			mortifagosAtacan();

		flagTurno = !flagTurno;
		
		this.batallonMagos.vaciarHechizosUsados();
		this.batallonMortifagos.vaciarHechizosUsados();
		System.out.println("------------ FIN DE LA RONDA " + ronda + "----------------");

		System.out.println();
		this.verBatallon(this.batallonMagos);
		this.verBatallon(this.batallonMortifagos);

		this.actualizarBaseConocimientos(this.batallonMagos, Main.baseDeConocimientosMagos, "mago", ronda);
		this.actualizarBaseConocimientos(this.batallonMortifagos, Main.baseDeConocimientosMortifagos, "mortifago", ronda);
		
		if(this.batallonMagos.tienePersonajesSaludables()) {
			System.out.println("[Sugerencia respecto al batallón de los Magos]");
			Heuristica.sugerirObjetivoDeseable(Main.baseDeConocimientosMagos, "mago", Integer.toString(ronda));			
		}
		if(this.batallonMortifagos.tienePersonajesSaludables()) {
			System.out.println("\n[Sugerencia respecto al batallón de los Mortifagos]");
			Heuristica.sugerirObjetivoDeseable(Main.baseDeConocimientosMortifagos, "mortifago", Integer.toString(ronda));			
		}
		
		System.out.println("\nPresiona Enter para continuar...");
		scanner.nextLine();
	}

	// Simular la batalla entre los batallones.
	public boolean simularBatalla() throws IOException {
		boolean ganador;
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

		System.out.println("ESTADO INICIAL DE LOS BATALLONES:");
		System.out.println("BATALLÓN DE MAGOS:");
		verBatallon(this.batallonMagos);

		System.out.println("BATALLÓN DE MORTIFAGOS:");
		verBatallon(this.batallonMortifagos);
		
		System.out.println("Presiona Enter para continuar...");
		scanner.nextLine();

		Heuristica.bindReglas(Main.reglasMagosPath);
		Heuristica.bindReglas(Main.reglasMortifagosPath);
		this.instanciarBaseDeConocimientosTmp(Main.baseDeConocimientosMagos, "mago");
		this.instanciarBaseDeConocimientosTmp(Main.baseDeConocimientosMortifagos, "mortifago");
		
		// Se realizará ronas hasta que alguno de los batallones no tenga personajes con
		// vida.
		while (this.batallonMagos.tienePersonajesSaludables() && this.batallonMortifagos.tienePersonajesSaludables()) {
			realizarRonda(ronda);
			ronda++;
		}

		if (this.batallonMagos.tienePersonajesSaludables()) {
			System.out.println("¡Los magos han ganado la batalla!");
			ganador = GANADOR_MAGOS;
		} else {
			System.out.println("¡Los mortífagos han ganado la batalla!");
			ganador = GANADOR_MORTIFAGOS;
		}
		System.out.println();

		System.out.println("HECHIZOS LANZADOS POR LOS MAGOS:");
		verHechizosLanzados(this.batallonMagos);

		System.out.println("HECHIZOS LANZADOS POR LOS MORTIFAGOS:");
		verHechizosLanzados(this.batallonMortifagos);

		scanner.close();

		return ganador;
	}
	
	// Actualizar estadísticas.
	public void actualizarBaseConocimientos(Batallon batallon, String path, String tipo, int ronda) throws IOException {
		FileWriter archivo = null;
		PrintWriter escritor = null;
		
		try {

			archivo = new FileWriter(path, true);
			
			escritor = new PrintWriter(archivo);
			
			for (Personaje personaje : batallon.getAtacantes())
				personaje.actualizarEstadisticaPorRonda(escritor, tipo, ronda);
			
		}
		catch (Exception e){
			System.out.println("No es posible actualizar estadísticas del tipo " + tipo + "[" + e + "]");
		}
		finally {
			archivo.close();
		}
		
	}
		
	public void instanciarBaseDeConocimientosTmp(String path, String tipo) throws IOException {
		FileWriter archivo = null;
		PrintWriter escritor = null;
		
		 LocalDateTime localDateTime = LocalDateTime.now();
	     ZoneId zoneId = ZoneId.systemDefault();
	     ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
	     long currentTimestamp = zonedDateTime.toInstant().toEpochMilli();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	     String formattedDateTime = localDateTime.format(formatter);
			
		try {

			archivo = new FileWriter(path);
			
			escritor = new PrintWriter(archivo);

			escritor.print("/* tmp timestamp " + formattedDateTime + " */\n\n");
			
		}
		catch (Exception e){
			System.out.println("No es posible instanciar estadísticas del tipo " + tipo + "[" + e + "]");
		}
		finally {
			archivo.close();
		}	
	}
}
