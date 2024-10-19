package hechizos;

public class HechizoFactory {
	public static Hechizo crearHechizo(String tipo) {
		switch (tipo) {
		case "Expelliarmus":
			return new Expelliarmus();

		case "Avada Kedavra":
			return new AvadaKedavra();

		case "Protego":
			return new Protego();

		default:
			throw new IllegalArgumentException("Tipo de hechizo desconocido");
		}
	}
}
