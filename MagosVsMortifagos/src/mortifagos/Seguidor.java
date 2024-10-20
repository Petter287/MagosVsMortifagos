package mortifagos;

import clases.TipoPersonaje;
import hechizos.HechizoFactory;
import hechizos.TipoHechizo;

public class Seguidor extends Mortifago {
    public Seguidor(String nombrePersonaje, int nivelMagia, int puntosVida) {
        super(TipoPersonaje.Seguidor, nombrePersonaje, nivelMagia, puntosVida);
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.AvadaKedavra));
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.Protego));
    }
}