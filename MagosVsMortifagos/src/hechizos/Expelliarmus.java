package hechizos;

import clases.Personaje;

public class Expelliarmus implements Hechizo {
    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
    	System.out.println(lanzador.getNombre() + " lanza Expelliarmus a " + objetivo.getNombre() + ".");
		
		if (objetivo.getProtegido()) {
			System.out.println(objetivo.getNombre() + " se protegió del hechizo y no tuvo efecto.");
			objetivo.setProtegido(false);
		} else {
			System.out.println(objetivo.getNombre() + " fue desarmado.");
			objetivo.setArmado(false);
		}
    }
    
    @Override
    public String toString() {
    	return "Expelliarmus";
    }
}