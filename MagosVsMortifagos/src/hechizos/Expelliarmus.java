package hechizos;

import clases.Personaje;

public class Expelliarmus implements Hechizo {
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        System.out.println(lanzador.getNombre() + " lanza Expelliarmus y desarma a " + objetivo.getNombre());
    }
}