package magos;

import clases.TipoPersonaje;

public class Profesor extends Mago {
    public Profesor(String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
        super(TipoPersonaje.Profesor, nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
}