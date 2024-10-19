package magos;

public class Estudiante extends Mago {
    public Estudiante(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
        hechizos.add("Expelliarmus");
        hechizos.add("Lumos");
    }
}