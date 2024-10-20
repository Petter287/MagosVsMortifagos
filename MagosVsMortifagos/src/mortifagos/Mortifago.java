package mortifagos;

import clases.Personaje;
import clases.TipoPersonaje;

public abstract class Mortifago extends Personaje {
    public Mortifago(TipoPersonaje tipo, String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
    	super(tipo, nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
}