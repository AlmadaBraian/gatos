package juego;

import java.awt.Color;

import entorno.Entorno;

public class Evento {
	
	double posx,posy;
	boolean activado=true;
	int estr, obj,modx,mody;
	
	Evento(){
		
	}
	Evento(double posx, double posy, int estr, int obj,int modx,int mody){
		this.modx=modx;
		this.mody=mody;
		this.posx=posx+modx;
		this.posy=mody+posy-50;
		this.estr=estr;
		this.obj=obj;
	}
	
	public void actualizarPos(double posx, double posy){
		this.posx=posx+modx;
		this.posy=mody+posy-50;
	}
	
	public void contacto(Personajes gato) {
		
		Double distancia= Fisicas.distancia(gato, this.posx, this.posy);
		
		if(distancia <=1) {
			if(this.activado) {
				System.out.println("Evento iniciado");
				activado=false;
			}
			
		}
	}
	
	void Dibujar(Entorno e, Color color) {
		if(this.activado) {
			e.dibujarRectangulo(this.posx, this.posy + 13, 50, 50, 0, color);
		}
		
	}

}
