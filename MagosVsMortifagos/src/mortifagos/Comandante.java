package mortifagos;

import clases.TipoPersonaje;

public class Comandante extends Mortifago {
    public Comandante(String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
        super(TipoPersonaje.Comandante, nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
}