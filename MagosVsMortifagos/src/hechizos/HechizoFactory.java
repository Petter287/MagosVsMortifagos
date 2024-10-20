package hechizos;

public class HechizoFactory {
	public static Hechizo crearHechizo(TipoHechizo tipo) {
		switch (tipo) {
		case TipoHechizo.Expelliarmus:
			return new Expelliarmus();

		case TipoHechizo.AvadaKedavra:
			return new AvadaKedavra();

		case TipoHechizo.Protego:
			return new Protego();
			
		case TipoHechizo.ExpectoPatronum:
			return new ExpectoPatronum();
		default:
			throw new IllegalArgumentException("Tipo de hechizo desconocido");
		}
	}
}
