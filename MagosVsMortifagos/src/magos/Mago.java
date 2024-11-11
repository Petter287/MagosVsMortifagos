package magos;

import clases.Personaje;

//Se pleantea que los magos tienen el siguiente puntaje de nivel mágico:
//	-Autores: 10
//	-Profesores: 5
//	-Estudiantes: 3
public abstract class Mago extends Personaje {
	protected TipoMago tipo;
	
	public Mago(TipoMago tipo, String nombre) {
		super(nombre);
		this.tipo = tipo;
	}
	
	public Mago(TipoMago tipo, String nombrePersonaje, int nivelMagia, float puntosVida, boolean armado,
			boolean protegido) {
		super(nombrePersonaje, nivelMagia, puntosVida, armado, protegido);
		this.tipo = tipo;
	}
}
