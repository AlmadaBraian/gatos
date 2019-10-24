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
	boolean moverMapa=false,arriba=false,abajo=false;
	int mov=0, a=0;
	Estructura movil;
	
	Nivel(){
		Estructura[]ni= {new Estructura(130,350,4,1,1),new Estructura(130,250,1,10,1),new Estructura(20,500,520,2,1),new Estructura(450,350,2,1,0,Color.red),new Estructura(250,250,2,1,0,Color.red)};
		this.mapa=new Mapa(ni);
		this.movil=ni[4];
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
		movil=mapa.mapa[4];
		if(a==0) {
			if(mov<=600) {
				movil.derecha=true;
				movil.quieto=false;
				movil.moverD(0.5);
				mov++;
				if(mov==600) {
					a++;
				}
			}		
		}
		if(a==1) {
			movil.quieto=true;
			mov++;
			if(mov==1000) {
				a++;
				mov=600;
			}		
		}
		if(a==2) {
			if(mov>=0) {
				movil.derecha=false;
				movil.quieto=false;
				movil.moverI(0.5);
				mov--;
				if(mov==0) {
					a++;
				}
			}
		}
		if(a==3) {
			movil.quieto=true;
			mov++;
			if(mov==400) {
				a=0;
				mov=0;
			}
		}
		
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
	public void moverMapa(Personajes gato) {
		
		if(gato.getPosX()<=140 && Fisicas.contacto(gato, mapa.mapa)) {
			gato.avanzar(2);
			for(int i=0; i<mapa.mapa.length;i++) {
				mapa.mapa[i].moverD(2);
			}
			
		}else {
			gato.mover = true;
		}
		if(gato.getPosX()>=530 && Fisicas.contacto(gato, mapa.mapa)) {
			gato.retroceder(2);
			for(int i=0; i<mapa.mapa.length;i++) {
				mapa.mapa[i].moverI(2);
			}
		}else {
			gato.mover = true;
		}
	}
	
	public void evento(Personajes gato) {
		//if(eventos[1].activado==false) {
		//	gato.avanzar(0.5);
		//	for(int i=0;i<mapa.length;i++) {
		//		mapa.mapa[i].moverD(0.5);
		//	}
		//}
		
		if (Fisicas.colision(gato, movil)) {
			if(movil.quieto==false) {
				if(movil.derecha) {
					gato.mover=true;
					gato.avanzar(2.5);


				}else {
					gato.mover=true;
					gato.retroceder(2.5);


				}
				moverMapa(gato);
			}
		}
		int instruccion=eventos[3].instruccion;
		for(int i=0;i<this.eventos.length;i++) {
			eventos[i].contacto(gato);
		}
		if(eventos[3].fin) {
			if(eventos[3].activado==false) {
				this.moverMapa=true;
				gato.mov=false;
				if(instruccion==0) {
					gato.avanzar(2);
					gato.mover=true;
					if(gato.getPosX()>=300) {
						eventos[3].instruccion++;
					}
				}
				
				if(gato.getPosX()==300 && instruccion==1) {
					
					if(gato.getPosX()==300) {
						gato.setSaltar(true);
						eventos[3].instruccion++;
					}

				}
				if(instruccion==2) {
					gato.mover=true;
					gato.avanzar(2);
					if(gato.getPosX()>=450) {
						eventos[3].instruccion++;
					}
					
				}
				if(instruccion==3) {
					gato.mover=true;
					gato.retroceder(2);
					if(gato.getPosX()<=350) {
						eventos[3].instruccion++;
					}
					
				}
				if(instruccion==4) {
					gato.mover=true;
					gato.avanzar(2);
					
					if(gato.getPosX()>=800) {
						gato.mover=false;
						gato.mov=true;
						eventos[3].fin=false;
						eventos[3].instruccion++;
					}
				}
				
				System.out.println(instruccion);
				


			}
		}
		
		
	}
	

}
