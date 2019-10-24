package juego;

import java.awt.Color;

import entorno.Entorno;

public class Estructura {
	
	double posx,posy;
	int ancho, alto;
	Obstaculo[] objeto;
	Color color;
	boolean derecha=false, quieto=true;
	
	
	Estructura(double posx,double posy,int ancho, int alto,int mod){
		objeto = new Obstaculo[(ancho*alto)+mod];
		this.ancho=ancho;
		this.alto=alto;
		setPosx(posx);
		setPosy(posy);
		this.color=Color.gray;
		setObjeto(objeto);
		
	}
	Estructura(double posx,double posy,int ancho, int alto,int mod,Color color){
		objeto = new Obstaculo[(ancho*alto)+mod];
		this.ancho=ancho;
		this.alto=alto;
		setPosx(posx);
		setPosy(posy);
		setObjeto(objeto);
		this.color=color;
		
	}

	public double getPosx() {
		return posx;
	}

	public void setPosx(double posx) {
		this.posx = posx;
	}

	public double getPosy() {
		return posy;
	}

	public void setPosy(double posy) {
		this.posy = posy;
	}

	private void setObjeto(Obstaculo[] objeto) {
		double auxX=posx;
		double auxY=posy;
		int aux=0;
		for (int i = 0; i < objeto.length; i++) {
			if(aux<ancho) {
				
				objeto[i] = new Obstaculo (auxX,auxY);
				auxX+=objeto[i].getAncho();
			}
			else{
				if(aux==ancho) {
					auxX=posx;
					auxY+=objeto[i-1].getAncho();
					aux=-1;
				}
				objeto[i] = new Obstaculo (auxX,auxY);			
			}
			aux++;

		}
		
	}
	
	private void setPos(Obstaculo[] objeto) {
		double auxX=posx;
		double auxY=posy;
		int aux=0;
		for (int i = 0; i < objeto.length; i++) {
			if(aux<ancho) {
				
				objeto[i].setPosx(auxX);
				objeto[i].setPosy(auxY);
				auxX+=objeto[i].getAncho();
			}
			else{
				if(aux==ancho) {
					auxX=posx;
					auxY+=objeto[i-1].getAncho();
					aux=-1;
				}
				objeto[i].setPosx(auxX);
				objeto[i].setPosy(auxY);			
			}
			aux++;

		}
		
	}
	
	void moverD(double velocidad) {
		this.posy = posy + 0;
		this.posx = posx + velocidad;
		setPos(objeto);
	}
	
	void moverI(double velocidad) {
		this.posy = posy - 0;
		this.posx = posx - velocidad;
		setPos(objeto);
	}
	
	void moverArr() {
		this.posy = 5+posy;
		setPos(objeto);
	}
	
	void moverAb() {
		this.posy = posy - 7;
		setPos(objeto);
	}
	
	void Dibujar(Entorno e) {

		for (int i = 0; i < this.objeto.length; i++) {
			this.objeto[i].Dibujar(e, color);
		}

	}
	
	void Dibujar(Entorno e,int pos, Color color) {

		for (int i = 0; i < this.objeto.length; i++) {
			if(i!=pos) {
				this.objeto[i].Dibujar(e, this.color);
			}else {
				this.objeto[i].Dibujar(e, color);
			}
			
		}

	}
	
	
	

}
