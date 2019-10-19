package juego;

import java.awt.Color;

import entorno.Entorno;

public class Estructura {
	
	double posx,posy;
	int ancho, alto;
	Obstaculo[] objeto;
	
	Estructura(double posx,double posy,int ancho, int alto){
		objeto = new Obstaculo[(ancho*alto)+1];
		this.ancho=ancho;
		this.alto=alto;
		setPosx(posx);
		setPosy(posy);
		setObjeto(objeto);
		
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
		System.out.println(objeto.length);
		for (int i = 0; i < objeto.length; i++) {
			System.out.println("numero "+ aux);
			if(aux<ancho) {
				System.out.println("dibuja");
				objeto[i] = new Obstaculo (auxX,auxY);
				auxX+=objeto[i].getAncho();
			}
			else{
				if(aux==ancho) {
					auxX=posx;
					auxY+=objeto[i-1].getAncho();
					aux=-1;
				}
				System.out.println("pasa por aca " + i);
				objeto[i] = new Obstaculo (auxX,auxY);			
			}
			aux++;

		}
		
	}
	
	void Dibujar(Entorno e) {

		for (int i = 0; i < this.objeto.length; i++) {
			this.objeto[i].Dibujar(e, Color.gray);
		}

	}
	
	
	

}
