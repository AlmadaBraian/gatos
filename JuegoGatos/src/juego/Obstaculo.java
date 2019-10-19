package juego;

import java.awt.Color;

import entorno.Entorno;

public class Obstaculo {
	
	double ancho, alto, posx, posy,angulo;
	double bordeIz, bordeDer;

	Obstaculo(){
		
	}
	Obstaculo(double x, double y) {
		setPosx(x);
		setPosy(y);
		setAlto(50);
		setAncho(50);
		setBordeDer();
		setBordeIz();

	}
	double getAncho() {
		return this.ancho;
	}
	double getAlto() {
		return this.alto;
	}
	double getPosx() {
		return this.posx;
	}
	double getPosy() {
		return this.posy;
	}
	
	void Dibujar(Entorno e, Color color) {
		e.dibujarRectangulo(this.posx, this.posy + 13, this.ancho, this.alto, this.angulo, color);
	}


	private void setBordeIz() {
		this.bordeIz = posx - (ancho / 2) - 25;
		
	}

	private void setBordeDer() {
		this.bordeDer = (posx + ancho / 2) + 25;
		
	}

	private void setAncho(double i) {
		this.ancho=i;
		
	}

	private void setAlto(double i) {
		this.alto=i;
		
	}

	void setPosy(double y) {
		this.posy=y;
		
	}

	void setPosx(double x) {
		this.posx=x;
		
	}

}
