package hechizos;

import clases.Personaje;
import interfaces.*;

public class AvadaKedavra implements Hechizo {
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        System.out.println(lanzador.getNombre() + " lanza Avada Kedavra contra " + objetivo.getNombre());
        objetivo.recibirDanio(9999);
    }
}