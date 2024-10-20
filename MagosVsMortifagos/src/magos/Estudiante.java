package magos;

import clases.TipoPersonaje;
import hechizos.HechizoFactory;
import hechizos.TipoHechizo;

public class Estudiante extends Mago {
    public Estudiante(String nombrePersonaje, int nivelMagia, int puntosVida) {
        super(TipoPersonaje.Estudiante,  nombrePersonaje, nivelMagia, puntosVida);
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.AvadaKedavra));
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.Protego));
    }
}