package juego;

import java.awt.Color;

import entorno.Entorno;

public class Personajes {
	private double x;
	private double y;
	public double ancho;
	private double alto;
	private double angulo;
	private double peso;
	private boolean estado, saltar;
	boolean derecha;
	private boolean contacto;
	private boolean vulnerable;
	public boolean mover;
	
	Personajes (double x, double y, double ancho, double alto, double angulo) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.angulo = angulo;
		this.peso = 10;
		this.estado = true;
		this.mover = false;
		setSaltar(false);
	}

	void setSaltar(boolean saltar) {
		this.saltar = saltar;
		
	}
	
	void inicio(int i) {
		this.y = i;
	}

	public void setPosX(int x) {
		this.x = x;
	}

	public double getPosX() {
		return x;
	}

	public double getPosY() {
		return y;
	}

	public double getAlto() {
		return alto;
	}
	public double getAncho() {
		return ancho;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	void Dibujar(Entorno e) {
		e.dibujarRectangulo(this.x, this.y + 13, this.ancho, this.alto, this.angulo, Color.orange);

	}

	void Dibujar(Entorno e, Color color) {
		e.dibujarRectangulo(this.x, this.y + 13, this.ancho, this.alto, this.angulo, color);
	}

	void avanzar() {
		this.y = y + (float) Math.sin(angulo);
		this.x = x + (float) Math.cos(angulo);
		derecha = true;
	}

	void retroceder() {
		this.y = y - (float) Math.sin(angulo);
		this.x = x - (float) Math.cos(angulo);
		derecha = false;
	}

	void caer() {
		this.y = y + peso;

	}

	void saltar() {
		this.y = y - peso * 2;
	}

	public boolean isSaltar() {
		return saltar;
	}


}
