package magos;

import clases.TipoPersonaje;

public class Estudiante extends Mago {
    public Estudiante(String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
        super(TipoPersonaje.Estudiante,  nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
}