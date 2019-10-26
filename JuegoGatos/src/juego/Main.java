package juego;

import java.awt.Color;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.awt.Image;
import java.util.concurrent.CountDownLatch;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Main extends InterfaceJuego{
	private Entorno entorno;
	int ancho = 800, alto = 600;
	int mapaPosx=0, mapaPosy=0;
	Personajes gato;
	Nivel nivel=new Nivel();
	boolean salto=false,caer=true;
	int contador = 0, vueltasSalto = 23;
	MediaPlayer mediaPlayer;
	//Obstaculo a = new Obstaculo(130, 250);
	
	Main(){
		final CountDownLatch latch = new CountDownLatch(1);
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        new JFXPanel(); // initializes JavaFX environment
		        latch.countDown();
		    }
		});
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.entorno = new Entorno(this, "Gato loco - V0.01", ancho, alto);
		this.gato=new Personajes(200, 150, 50.0, 50.0, 0);
		this.mediaPlayer= new MediaPlayer(nivel.musica);
		//mediaPlayer.setStartTime(Duration.seconds(0));
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
		this.entorno.iniciar();
		//entorno.dibujarRectangulo(gato.getPosX(), gato.getPosY(), gato.getAncho(), gato.getAlto(), 0.0, Color.gray);
	}
	
	public void dibujarMapa() {
		for(int i=0;i<nivel.mapa.length;i++) {
			if(nivel.moverMapa) {
				
				if(gato.derecha==false) {
					nivel.mapa.mapa[i].moverD(2.5);
					if (gato.isSaltar()) {
							nivel.mapa.mapa[i].moverD(2.5);
					}
				}else {
					nivel.mapa.mapa[i].moverI(1.5);
					if (gato.isSaltar()) {
							nivel.mapa.mapa[i].moverI(2.5);

					}
				}
				if(nivel.arriba) {
					nivel.mapa.mapa[i].moverArr(5);
				}if(nivel.abajo) {
					nivel.mapa.mapa[i].moverAb(10);
					gato.setPosY(gato.getPosY()-3);
				}
			}
			nivel.dibujar(entorno, i);	
		}
		
		nivel.evento(gato);
		//nivel.ev1.contacto(gato);
		//nivel.actualizarEvento(entorno);
		//nivel.ev1.actualizarPos(nivel.eventoPosx, nivel.eventoPosy);
		
	}

	
	
	public void tick() {
		
		gato.Dibujar(entorno);
		dibujarMapa();
		dibujartexto(entorno);
		mover();
		//Fisicas.correccion(gato, mapa);
		comprobar();
		
		//System.out.println("x " + gato.getPosX()+" y "+ gato.getPosY());
		//System.out.println("objeto b: x "+ nivel.mapa.mapa[3].objeto[0].posx+" y "+ nivel.mapa.mapa[3].objeto[0].posy);
		//System.out.println("evento: x "+ nivel.ev1.posx+" y "+ nivel.ev1.posy);
		//System.out.println("caer: "+caer);
		
		if (gato.isSaltar()) {
			contador++;
			if (contador < vueltasSalto - 5) {
				gato.saltar();
			}else if (contador == vueltasSalto) {
				gato.setSaltar(false);
				contador = 0;
			}
		}
		//a.imprimir();
		if(Fisicas.colision(gato, nivel.mapa.mapa)==false) {
			gato.caer();
			caer=true;
		}else {
			caer=false;
		}

		
	}
	
	public void comprobar() {

		gato.mover = false;
		nivel.moverMapa=false;
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			
			if(gato.getPosX()<=200 && Fisicas.contacto(gato, nivel.mapa.mapa)) {
				nivel.moverMapa=true;
			}else {
				gato.mover = true;
			}
			
			
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			
			if(gato.getPosX()>=430 && Fisicas.contacto(gato, nivel.mapa.mapa)) {
				nivel.moverMapa=true;
			}else {
				gato.mover = true;
			}
			
		}
		
		if(gato.getPosY()<=120){
			nivel.moverMapa=true;
			nivel.arriba=true;
			gato.setPosY(gato.getPosY()+4);
			
		}else if(gato.getPosY()<100){
			nivel.moverMapa=true;
			nivel.arriba=true;
			
			//gato.setPosY(240);
		}else {
			nivel.arriba=false;
		}
		if(gato.getPosY()>=360 && Fisicas.colision(gato, nivel.mapa.mapa)==false){
			gato.setPosY(gato.getPosY()-4);
			nivel.moverMapa=true;
			nivel.abajo=true;
		}else if(gato.getPosY()>250){
			nivel.moverMapa=true;
			nivel.abajo=true;
			
			//gato.setPosY(240);
		}else {
			nivel.abajo=false;
		}
		//nivel.moverMapa(gato);

	}

	public void mover() {
		if(gato.mov) {
			if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				gato.derecha=false;

					if(Fisicas.contacto(gato, nivel.mapa.mapa)&&gato.mover) {
						gato.retroceder(2);
						if (gato.isSaltar()) {
								if(Fisicas.contacto(gato, nivel.mapa.mapa)&&gato.mover) {
									if(Fisicas.colision(gato, nivel.mapa.mapa)==false) {
										gato.retroceder(2);
									}
									
								}

						if(caer&&gato.isSaltar()==false) {
							if(Fisicas.contacto(gato, nivel.mapa.mapa)&&gato.mover) {
								if(Fisicas.colision(gato, nivel.mapa.mapa)==false) {
									gato.retroceder(2);
								}
								
								//gato.retroceder();
							}
						}
					}
				}


			}
			if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
				gato.derecha=true;

					if(Fisicas.contacto(gato, nivel.mapa.mapa)&&gato.mover) {
						gato.avanzar(2);
							if (gato.isSaltar()) {
									if(Fisicas.contacto(gato, nivel.mapa.mapa)&&gato.mover) {
										if(Fisicas.colision(gato, nivel.mapa.mapa)==false) {
											gato.avanzar(2);
										}
										
									}


							}
							if(caer&&gato.isSaltar()==false) {
								
								if(Fisicas.colision(gato, nivel.mapa.mapa)==false){
									if (Fisicas.contacto(gato, nivel.mapa.mapa)&&gato.mover) {
										gato.avanzar(2);
									}
									
									//gato.avanzar();
								}
							}
					}
				}

			if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
				gato.saltarwav.sound.play();
				gato.setSaltar(true);
				//salto = true;
			}
		}
		
		
	}
	
	public void dibujartexto(Entorno e) {
		e.cambiarFont("Arial", 20, Color.red);
		e.escribirTexto("posx "+gato.getPosX(), 50, 50);
		e.escribirTexto("posy "+gato.getPosY(), 50, 70);
		e.escribirTexto("saltar "+gato.saltar, 50, 90);
		e.escribirTexto("caer "+caer, 50, 110);
		e.escribirTexto("mover "+gato.mover, 50, 130);
		e.escribirTexto("derecha "+gato.derecha, 50, 150);
	}


	
	public static void main(String[] args) {
		new Main();
	}
	
}
