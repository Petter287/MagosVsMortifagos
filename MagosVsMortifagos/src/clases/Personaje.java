package clases;

import java.util.ArrayList;
import java.util.List;

import hechizos.Hechizo;

public abstract class Personaje {
	// ATRIBUTOS
	protected TipoPersonaje tipo;
	protected String nombre;
	protected int nivelMagia, puntosVida;
	protected boolean armado, protegido;
	protected List<Hechizo> hechizos;

	// GETTERS & SETTERS
	public List<Hechizo> getHechizos(){
		return hechizos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}
	
	public boolean getArmado() {
		return armado;
	}
	
	public int getNivelMagico() {
		return nivelMagia;
	}
	
	public void setArmado(boolean nuevoArmado) {
		this.armado = nuevoArmado;
	}

	public boolean getProtegido() {
		return protegido;
	}
	
	public void setProtegido(boolean nuevoProtegido) {
		this.protegido = nuevoProtegido;
	}
	// CONSTRUCTORES
	public Personaje(TipoPersonaje tipo, String nombre, int nivelMagia, int puntosVida, boolean armado, boolean protegido) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.nivelMagia = nivelMagia;
		this.puntosVida = puntosVida;
		this.armado = armado;
		this.protegido = protegido;
		this.hechizos = new ArrayList<>();
	}

	// METODOS
	@Override
	public String toString() {
		return "Personaje [tipo=" + tipo + ", nombre=" + nombre + ", nivelMagia=" + nivelMagia + ", puntosVida="
				+ puntosVida + ", armado=" + armado + ", protegido=" + protegido + ", hechizos=" + hechizos + "]";
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje enemigo) {
		if (hechizos.contains(hechizo))
			hechizo.ejecutar(this, enemigo);
        else
            System.out.println(nombre + " no puede lanzar el hechizo " + hechizo);
	}

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