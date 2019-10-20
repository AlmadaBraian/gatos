package juego;

import java.awt.Color;

import entorno.Entorno;

public class Obstaculo {
	
	double ancho, alto, posx, posy,angulo;
	double bordeIz, bordeDer;
	double[]laterales=new double [10];

	Obstaculo(){
		
	}
	Obstaculo(double x, double y) {
		setPosx(x);
		setPosy(y);
		setAlto(50);
		setAncho(50);
		setBordeDer();
		setBordeIz();
		setLaterales();

	}
	private void setLaterales() {
		double aux=posy;
		for(int i=0;i<laterales.length;i++) {
			if(i<laterales.length/2) {
				laterales[i]=aux;
				aux+=10;
			}else {
				aux=posy;
				laterales[i]=aux;
				aux-=10;
			}
			
		}
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
		this.bordeIz = posx - (ancho / 2) - 30;
		
	}

	private void setBordeDer() {
		this.bordeDer = (posx + ancho / 2) + 30;
		
	}

	private void setAncho(double i) {
		this.ancho=i;
		
	}

	private void setAlto(double i) {
		this.alto=i;
		
	}

	void setPosy(double y) {
		this.posy=y;
		actualizar();
		
	}

	void setPosx(double x) {
		this.posx=x;
		actualizar();
		
	}
	
	public void imprimir() {
		for(int i=0;i<laterales.length;i++) {
			System.out.println(laterales[i]);
		}
	}
	
	void actualizar() {
		setBordeDer();
		setBordeIz();
	}

}
