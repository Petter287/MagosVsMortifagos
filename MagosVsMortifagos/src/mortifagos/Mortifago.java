package mortifagos;

import clases.Personaje;

public abstract class Mortifago extends Personaje {
    public Mortifago(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    @Override
    public void lanzarHechizo(String hechizo, Personaje enemigo) {
        if (hechizos.contains(hechizo)) {
            System.out.println(nombre + " lanza el hechizo oscuro " + hechizo + " contra " + enemigo.getNombre());
            enemigo.recibirDanio(nivelMagia * 15);  // mayor daño para los Mortífagos -> Para ver
        } else {
            System.out.println(nombre + " no puede lanzar el hechizo " + hechizo);
        }
    }
}