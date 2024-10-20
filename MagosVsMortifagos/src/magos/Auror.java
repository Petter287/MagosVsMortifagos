package magos;

import clases.TipoPersonaje;

public class Auror extends Mago {
    public Auror(String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
        super(TipoPersonaje.Auror, nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
} 