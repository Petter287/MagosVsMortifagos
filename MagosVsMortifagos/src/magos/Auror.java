package magos;

import clases.TipoPersonaje;
import hechizos.HechizoFactory;
import hechizos.TipoHechizo;

public class Auror extends Mago {
    public Auror(String nombrePersonaje, int nivelMagia, int puntosVida) {
        super(TipoPersonaje.Auror, nombrePersonaje, nivelMagia, puntosVida);
        
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.ExpectoPatronum));
        hechizos.add(HechizoFactory.crearHechizo(TipoHechizo.Protego));
    }
} 