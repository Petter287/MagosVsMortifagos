package mortifagos;

public class Comandante extends Mortifago {
    public Comandante(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
        hechizos.add("Avada Kedavra");
        hechizos.add("Sectumsempra");
    }
}