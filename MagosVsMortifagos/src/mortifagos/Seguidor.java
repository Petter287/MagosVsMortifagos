package mortifagos;

import clases.TipoPersonaje;

public class Seguidor extends Mortifago {
    public Seguidor(String nombrePersonaje, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
        super(TipoPersonaje.Seguidor, nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
    }
}