package magos;

public class Auror extends Mago {
    public Auror(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
        hechizos.add("Expecto Patronum");
        hechizos.add("Protego");
    }
}