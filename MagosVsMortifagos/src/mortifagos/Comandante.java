package mortifagos;

import clases.TipoPersonaje;
import hechizos.HechizoFactory;
import hechizos.TipoHechizo;

public class Comandante extends Mortifago {
    public Comandante(String nombrePersonaje, int nivelMagia, int puntosVida) {
        super(TipoPersonaje.Comandante, nombrePersonaje, nivelMagia, puntosVida);
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.AvadaKedavra));
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.Protego));
    }
}