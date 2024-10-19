package hechizos;

import clases.Personaje;
import interfaces.*;

public class Expelliarmus implements Hechizo {
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        System.out.println(lanzador.getNombre() + " lanza Expelliarmus y desarma a " + objetivo.getNombre());
    }
}