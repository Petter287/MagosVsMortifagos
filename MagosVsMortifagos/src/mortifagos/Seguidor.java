package mortifagos;

public class Seguidor extends Mortifago {
    public Seguidor(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
        hechizos.add("Crucio");
        hechizos.add("Imperio");
    }
}