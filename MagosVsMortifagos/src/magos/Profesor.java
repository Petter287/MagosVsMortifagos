package magos;

import clases.TipoPersonaje;
import hechizos.HechizoFactory;
import hechizos.TipoHechizo;

public class Profesor extends Mago {
    public Profesor(String nombrePersonaje, int nivelMagia, int puntosVida) {
        super(TipoPersonaje.Profesor, nombrePersonaje, nivelMagia, puntosVida);
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.AvadaKedavra));
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.Protego));
    }
}