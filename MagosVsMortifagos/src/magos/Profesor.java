package magos;

public class Profesor extends Mago {
	private static final int NIVEL_MAGICO = 5;
	
	public Profesor(String nombrePersonaje) {
        super(TipoMago.Profesor, nombrePersonaje);
    }
	
    public Profesor(String nombrePersonaje, float puntosVida, boolean armado, boolean protegido) {
        super(TipoMago.Profesor, nombrePersonaje, NIVEL_MAGICO, puntosVida, armado, protegido);
    }

	@Override
	public boolean esMago() {
		return true;
	}

	@Override
	public boolean esMortifago() {
		return false;
	}
}