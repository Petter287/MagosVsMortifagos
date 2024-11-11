package magos;

public class Estudiante extends Mago {
	private static final int NIVEL_MAGICO = 3;
	
	public Estudiante(String nombrePersonaje) {
		super(TipoMago.Estudiante, nombrePersonaje);
	}
	
    public Estudiante(String nombrePersonaje,float puntosVida, boolean armado, boolean protegido) {
        super(TipoMago.Estudiante,  nombrePersonaje, NIVEL_MAGICO, puntosVida, armado, protegido);
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