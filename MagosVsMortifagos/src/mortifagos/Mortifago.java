package mortifagos;

import clases.Personaje;

//Se pleantea que los mortífagos tienen el siguiente puntaje de nivel mágico:
//	-Comandantes: 10
//	-Seguidor: 3
public abstract class Mortifago extends Personaje {
	protected TipoMortifago tipo;
	
	public Mortifago(TipoMortifago tipo, String nombre) {
		super(nombre);
		this.tipo = tipo;
	}
	
	public Mortifago(TipoMortifago tipo, String nombrePersonaje, int nivelMagia, float puntosVida, boolean armado,
			boolean protegido) {
		super(nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
		this.tipo = tipo;
	}
}