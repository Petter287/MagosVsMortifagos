package magos;

import clases.Personaje;
import clases.TipoPersonaje;

public abstract class Mago extends Personaje {
    public Mago(TipoPersonaje tipo, String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
        super(tipo, nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
}
