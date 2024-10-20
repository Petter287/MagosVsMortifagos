package app;

import java.util.Random;

import batalla.Batallon;
import clases.PersonajeFactory;
import clases.TipoPersonaje;

public class Main {
	  public static void main(String[] args) {
	    Batallon batallonMagos = new Batallon();
	    Batallon batallonMortifagos = new Batallon();

	    for (int i = 0; i < 3; i++) {
	      batallonMagos.agregarPersonaje(PersonajeFactory.crearMago(TipoPersonaje.Auror, "Mago0" + i));
	      batallonMortifagos.agregarPersonaje(PersonajeFactory.crearMortifago(TipoPersonaje.Comandante, "Mago0" + i));
	    }

	    Random rand = new Random();
	    while (batallonMagos.tienePersonajesSaludables() && batallonMortifagos.tienePersonajesSaludables()) {

	      // los ataques pueden tener salidas por pantalla para mostrar lo que sucede
	      if (rand.nextBoolean()) {
	        batallonMagos.atacar(batallonMortifagos);
	        if (batallonMortifagos.tienePersonajesSaludables()) {
	          batallonMortifagos.atacar(batallonMagos);
	        }
	      } else {
	        batallonMortifagos.atacar(batallonMagos);
	        if (batallonMagos.tienePersonajesSaludables()) {
	          batallonMagos.atacar(batallonMortifagos);
	        }
	      }

	      System.out.println("----------------------------");
	    }

	    if (batallonMagos.tienePersonajesSaludables()) {
	      System.out.println("¡Los magos han ganado la batalla!");
	    } else {
	      System.out.println("¡Los mortífagos han ganado la batalla!");
	    }
	  }
	}
