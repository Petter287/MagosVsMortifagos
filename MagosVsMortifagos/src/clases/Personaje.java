package clases;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import exception.PersonajeHechizoNoDisponibleException;
import exception.PersonajeHechizoNuloException;
import exception.PersonajeNuloException;
import hechizos.Hechizo;

public abstract class Personaje {
	// ATRIBUTOS
	protected String nombre;
	protected float puntosVida;
	protected int nivelMagia;
	protected boolean armado, protegido;
	protected List<Hechizo> hechizos;

	public abstract boolean esMago();

	public abstract boolean esMortifago();

	// GETTERS & SETTERS
	public List<Hechizo> getHechizos() {
		return this.hechizos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public float getPuntosVida() {
		return this.puntosVida;
	}

	public boolean getArmado() {
		return this.armado;
	}

	public int getNivelMagico() {
		return this.nivelMagia;
	}

	public boolean getProtegido() {
		return this.protegido;
	}

	public void setArmado(boolean nuevoArmado) {
		this.armado = nuevoArmado;
	}

	public void setProtegido(boolean nuevoProtegido) {
		this.protegido = nuevoProtegido;
	}

	// CONSTRUCTORES
	public Personaje(String nombre) {
		this.nombre = nombre;
		this.nivelMagia = 10;
		this.puntosVida = 100;
		this.protegido = false;
		this.armado = true;
		this.hechizos = new ArrayList<>();
	}

	public Personaje(String nombre, int nivelMagia, float puntosVida, boolean armado, boolean protegido) {
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
		return "Personaje [nombre=" + nombre + ", nivelMagia=" + nivelMagia + ", puntosVida=" + puntosVida + ", armado="
				+ armado + ", protegido=" + protegido + ", hechizos=" + hechizos + "]";
	}

	// Ver si el personaje está vivo.
	public boolean estaVivo() {
		return puntosVida > 0;
	}

	// Lanza el hechizo seleccionado al enemigo especificado.
	public int lanzarHechizo(Hechizo hechizo, Personaje enemigo) {
		if (hechizo == null)
			throw new PersonajeHechizoNuloException("El hechizo para lanzar no puede ser null.");

		if (enemigo == null)
			throw new PersonajeNuloException("El destino para lanzar hechizo no puede ser null.");

		if (!hechizos.contains(hechizo))
			throw new PersonajeHechizoNoDisponibleException("No se puede lanzar un hechizo que no se dispone.");

		hechizo.ejecutar(this, enemigo);

		return 0;
	}

	// Agrega un hechizo al personaje.
	public boolean agregarHechizo(Hechizo hechizo) {
		if (hechizo == null)
			throw new PersonajeHechizoNuloException("El hechizo para agregar no puede ser null.");
		
		if (hechizos.contains(hechizo))
			return false;

		hechizos.add(hechizo);
		
		return true;
	}

	// Recibe el daño el personaje.
	public boolean recibirDanio(double danioReal) {
		if(danioReal <= 0)
			return false;
		
		if(getPuntosVida() <= 0)
			return false;
		
		this.puntosVida -= danioReal;
		if (puntosVida <= 0)
			System.out.println(nombre + " ha sido derrotado.");
		else
			System.out.println(nombre + " tiene " + puntosVida + " puntos de vida restantes.");
		
		return true;
	}
	
	public void actualizarEstadisticaPorRonda(PrintWriter escritor, String tipo, int ronda) {
		escritor.println("estado_" + tipo + "(" + nombre.toLowerCase() + ", " + nivelMagia + ", " + puntosVida + ", " + Integer.toString(ronda) + ").");
	}
}