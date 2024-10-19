package magos;

public class Profesor extends Mago {
    public Profesor(String nombre, int nivelMagia, int puntosVida) {
        super(nombre, nivelMagia, puntosVida);
        hechizos.add("Stupefy");
        hechizos.add("Wingardium Leviosa");
    }
}