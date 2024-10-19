package clases;

import java.util.ArrayList;
import java.util.List;

import hechizos.Hechizo;

public abstract class Personaje {
	//ATRIBUTOS
	protected String nombre;
    protected int nivelMagia, puntosVida;
    protected List<Hechizo> hechizos;
	
	//GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }
    
	//CONSTRUCTORES
    public Personaje(String nombre, int nivelMagia, int puntosVida) {
        this.nombre = nombre;
        this.nivelMagia = nivelMagia;
        this.puntosVida = puntosVida;
        this.hechizos = new ArrayList<>();
    }
    
	//METODOS
    public abstract void lanzarHechizo(String hechizo, Personaje enemigo);
    
    public void agregarHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
    }
    
    public void recibirDanio(int danio) {
        this.puntosVida -= danio;
        if (puntosVida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        } else {
            System.out.println(nombre + " tiene " + puntosVida + " puntos de vida restantes.");
        }
    }
}