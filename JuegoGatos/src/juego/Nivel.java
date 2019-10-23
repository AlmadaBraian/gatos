package juego;

import java.awt.Color;

import entorno.Entorno;

public class Nivel {

	Mapa mapa;
	Evento[] eventos;
	
	Nivel(){
		Estructura[]ni= {new Estructura(130,350,4,1),new Estructura(130,250,1,10),new Estructura(20,500,20,2),new Estructura(450,350,2,2,Color.red)};
		this.mapa=new Mapa(4, ni);
		this.eventos=new Evento[4];
		eventos[0]=new Evento(mapa.mapa[3].objeto[0].posx, mapa.mapa[3].objeto[0].posy,3,0,0,0);
		eventos[1]=new Evento(mapa.mapa[1].objeto[0].posx, mapa.mapa[1].objeto[0].posy,1,10,100,0);
		eventos[2]=new Evento(mapa.mapa[1].objeto[0].posx, mapa.mapa[1].objeto[0].posy,1,10,-70,0);
		eventos[3]=new Evento(mapa.mapa[1].objeto[0].posx, mapa.mapa[1].objeto[0].posy,1,10,0,-250);
	}
	
	public void actualizarEvento(Entorno e) {
		for(int i=0; i<this.eventos.length;i++) {
			int estr=eventos[i].estr;
			int obj=eventos[i].obj;
			eventos[i].actualizarPos(mapa.mapa[estr].objeto[obj].posx, mapa.mapa[estr].objeto[obj].posy);
			eventos[i].Dibujar(e, Color.blue);
		}
		
	}
	
	public void dibujar(Entorno e, int i) {
		mapa.mapa[i].Dibujar(e);
		actualizarEvento(e);

	}
	
	public void evento(Personajes gato) {
		
	}
	

}
