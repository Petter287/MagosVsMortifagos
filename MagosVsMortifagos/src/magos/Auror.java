package magos;

public class Auror extends Mago {
	private static final int NIVEL_MAGICO = 10;
	
	public Auror(String nombrePersonaje) {
		super(TipoMago.Auror, nombrePersonaje);
	}
	
    public Auror(String nombrePersonaje, float puntosVida, boolean armado, boolean protegido) {
        super(TipoMago.Auror, nombrePersonaje, NIVEL_MAGICO, puntosVida, armado, protegido);
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