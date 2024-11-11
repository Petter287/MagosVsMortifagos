package mortifagos;

public class Comandante extends Mortifago {
	private static final int NIVEL_MAGICO = 10;
	
	public Comandante(String nombrePersonaje) {
        super(TipoMortifago.Comandante, nombrePersonaje);
    }
	
    public Comandante(String nombrePersonaje, float puntosVida, boolean armado, boolean protegido) {
        super(TipoMortifago.Comandante, nombrePersonaje, NIVEL_MAGICO, puntosVida, armado, protegido);
    }

	@Override
	public boolean esMago() {
		return false;
	}

	@Override
	public boolean esMortifago() {
		return true;
	}
}