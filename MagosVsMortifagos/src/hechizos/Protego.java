package hechizos;

import clases.Personaje;

public class Protego implements Hechizo {
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        System.out.println(lanzador.getNombre() + " lanza Protego y se protege de los ataques.");
    }
}