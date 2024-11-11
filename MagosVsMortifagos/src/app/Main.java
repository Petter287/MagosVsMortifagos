package app;

import java.io.IOException;
import java.util.Random;

import batalla.Batalla;
import batallon.Batallon;
import clases.PersonajeFactory;
import magos.TipoMago;
import mortifagos.TipoMortifago;

public class Main {
	public static String reglasMagosPath = "C:/Users/Admin/N/UNLaM/PdP/MagosVsMortifagosFinal/reglasMagos.pl",
            			 reglasMortifagosPath = "C:/Users/Admin/N/UNLaM/PdP/MagosVsMortifagosFinal/reglasMortifagos.pl",
                         baseDeConocimientosMagos = "C:/Users/Admin/N/UNLaM/PdP/MagosVsMortifagosFinal/tmpBaseDeConocimientosMagos.pl",
                         baseDeConocimientosMortifagos = "C:/Users/Admin/N/UNLaM/PdP/MagosVsMortifagosFinal/tmpBaseDeConocimientosMortifagos.pl";
	
	public static void main(String[] args) throws IOException {
		Batallon batallonMagos = crearBatallonMago();
		Batallon batallonMortifagos = crearBatallonMortifago();
		Batalla batalla = new Batalla(batallonMagos, batallonMortifagos);

		batalla.simularBatalla();
	}

	// Obtener un mago aleatorio
	public static TipoMago getRandomMago() {
		Random random = new Random();
		TipoMago[] tiposMagos = TipoMago.values();
		return tiposMagos[random.nextInt(tiposMagos.length)];
	}

	// Obtener un mortífago aleatorio
	public static TipoMortifago getRandomMortifago() {
		Random random = new Random();
		TipoMortifago[] tiposMortifago = TipoMortifago.values();
		return tiposMortifago[random.nextInt(tiposMortifago.length)];
	}

	private static Batallon crearBatallonMago() {
		TipoMago magoSeleccionado;
		Batallon batallonMago = new Batallon();
		batallonMago.setTipoBatallonMago();

		for (int i = 0; i < 3; i++) {
			magoSeleccionado = getRandomMago();
			batallonMago.agregarPersonaje(PersonajeFactory.crearMago(magoSeleccionado, magoSeleccionado.toString() + "0" + i));
		}

		return batallonMago;
	}

	private static Batallon crearBatallonMortifago() {
		TipoMortifago mortifagoSeleccionado;
		Batallon batallonMortifago = new Batallon();
		batallonMortifago.setTipoBatallonMortifago();

		for (int i = 0; i < 3; i++) {			
			mortifagoSeleccionado = getRandomMortifago();
			batallonMortifago.agregarPersonaje(PersonajeFactory.crearMortifago(mortifagoSeleccionado, mortifagoSeleccionado.toString() + "0" + i));
		}

		return batallonMortifago;
	}
}
