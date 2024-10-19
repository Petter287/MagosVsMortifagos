package hechizos;

import clases.Personaje;

public class ExpectoPatronum implements Hechizo {
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        System.out.println(lanzador.getNombre() + " lanza Expecto Patronum contra " + objetivo.getNombre());
        objetivo.recibirDanio(5);
    }
}