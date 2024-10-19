package magos;

import clases.Personaje;

public abstract class Mago extends Personaje {
    public Mago(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
    }

    @Override
    public void lanzarHechizo(String hechizo, Personaje enemigo) {
        if (hechizos.contains(hechizo)) {
            System.out.println(nombre + " lanza el hechizo " + hechizo + " contra " + enemigo.getNombre());
            enemigo.recibirDanio(nivelMagia * 10);  // daño basado en nivel de magia -> Para ver
        } else {
            System.out.println(nombre + " no puede lanzar el hechizo " + hechizo);
        }
    }
}
