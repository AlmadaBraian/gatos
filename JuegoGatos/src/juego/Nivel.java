package juego;

import java.awt.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import entorno.Entorno;

public class Nivel {

	Mapa mapa;
	Evento[] eventos;
	Media musica;
	
	Nivel(){
		Estructura[]ni= {new Estructura(130,350,4,1),new Estructura(130,250,1,10),new Estructura(20,500,20,2),new Estructura(450,350,2,2,Color.red)};
		this.mapa=new Mapa(4, ni);
		this.eventos=new Evento[4];
		
		this.musica=  new Media(new File("Electronic-ambient-background-beat.mp3").toURI().toString());
		
		eventos[0]=new Evento(3,0,0,0);
		eventos[1]=new Evento(1,10,100,0);
		eventos[2]=new Evento(1,10,-70,0);
		eventos[3]=new Evento(1,10,0,-250);
		
	}
	
	Nivel(Estructura[]ni,String cancion){
		
		this.mapa=new Mapa(ni);
		this.eventos=new Evento[4];
		eventos[0]=new Evento(3,0,0,0);
		eventos[1]=new Evento(1,10,1,10);
		eventos[1]=new Evento(1,10,100,0);
		eventos[2]=new Evento(1,10,-70,0);
		eventos[3]=new Evento(1,10,0,-250);
		this.musica= new Media(new File(cancion).toURI().toString());
	}
	
	
	
	public void actualizarEvento(Entorno e) {
		for(int i=0; i<this.eventos.length;i++) {
			int estr=eventos[i].estr;
			int obj=eventos[i].obj;
			eventos[i].actualizarPos(mapa.mapa[estr].objeto[obj].getPosx(),mapa.mapa[estr].objeto[obj].getPosy());
			eventos[i].Dibujar(e, Color.blue);
			if(eventos[i].activado==false) {
				if (eventos[i].rep==false) {
					eventos[i].gatowav.sound.play();
					eventos[i].rep=true;
				}
			}
		}
		
	}
	
	public void dibujar(Entorno e, int i) {
		mapa.mapa[i].Dibujar(e);
		actualizarEvento(e);

	}
	
	public void evento(Personajes gato) {
		
	}
	

}
