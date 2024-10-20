package hechizos;

import clases.Personaje;

public class ExpectoPatronum implements Hechizo {
	private static final int DANIO_BASE = 5;
	
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
    	System.out.println(lanzador.getNombre() + " lanza Expecto Patronum contra " + objetivo.getNombre() + ".");
		
		if (objetivo.getProtegido()) {
			System.out.println(objetivo.getNombre() + " se protegió del hechizo y no tuvo efecto.");
			objetivo.setProtegido(false);
		} else
			objetivo.recibirDanio(DANIO_BASE * (lanzador.getNivelMagico() / 10));
    }
    
    @Override
    public String toString() {
    	return "Expecto Patronum";
    }
}