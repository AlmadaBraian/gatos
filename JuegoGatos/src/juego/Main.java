package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Main extends InterfaceJuego{
	private Entorno entorno;
	int ancho = 800, alto = 600;
	int mapaPosx=0, mapaPosy=0;
	Personajes gato;
	Mapa mapa;
	boolean salto=false,moverMapa=false,caer=true,arriba=false,abajo=false;
	int contador = 0, vueltasSalto = 23;
	//Obstaculo a = new Obstaculo(130, 250);
	
	Main(){
		this.entorno = new Entorno(this, "Gato loco - V0.01", ancho, alto);
		this.gato=new Personajes(200, 150, 50.0, 50.0, 0);
		this.mapa=Nivel1.mapa;
		this.entorno.iniciar();
		//entorno.dibujarRectangulo(gato.getPosX(), gato.getPosY(), gato.getAncho(), gato.getAlto(), 0.0, Color.gray);
	}
	
	public void dibujarMapa() {
		for(int i=0;i<mapa.length;i++) {
			if(moverMapa) {
				if(gato.derecha==false) {
					mapa.mapa[i].moverD();
					if (gato.isSaltar()) {
						for (int a = 0; a < 4; a++) {
							mapa.mapa[i].moverD();

						}
					}
				}else {
					mapa.mapa[i].moverI();
					if (gato.isSaltar()) {
						for (int a = 0; a < 4; a++) {
							mapa.mapa[i].moverI();

						}
					}
				}
				if(arriba) {
					mapa.mapa[i].moverArr();
				}if(abajo) {
					mapa.mapa[i].moverAb();
				}
			}
			mapa.mapa[i].Dibujar(entorno);
		}
	}

	
	
	public void tick() {
		
		gato.Dibujar(entorno);
		dibujarMapa();
		mover();
		//Fisicas.correccion(gato, mapa);
		comprobar();
		System.out.println("x " + gato.getPosX()+" y "+ gato.getPosY());
		System.out.println("objeto b: x "+ mapa.mapa[1].objeto[0].posx+" y "+ mapa.mapa[1].objeto[0].posy);
		System.out.println("caer: "+caer);
		
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
		if(Fisicas.colision(gato, mapa.mapa)==false) {
			gato.caer();
			caer=true;
		}else {
			caer=false;
		}

		
	}
	
	public void comprobar() {

		gato.mover = false;
		moverMapa=false;
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			gato.derecha = false;
			if(gato.getPosX()<=140 && Fisicas.contacto(gato, mapa.mapa)) {
				moverMapa=true;
			}else {
				gato.mover = true;
			}
			
			
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			gato.derecha = true;
			if(gato.getPosX()>=530 && Fisicas.contacto(gato, mapa.mapa)) {
				moverMapa=true;
			}else {
				gato.mover = true;
			}
			
		}
		
		if(gato.getPosY()<=20){
			moverMapa=true;
			arriba=true;
			gato.setPosY(gato.getPosY()+20);
			
		}else {
			arriba=false;
		}
		if(gato.getPosY()>=360 && Fisicas.colision(gato, mapa.mapa)==false){
			gato.setPosY(gato.getPosY()-12);
			moverMapa=true;
			abajo=true;
		}else{
			abajo=false;
			//gato.setPosY(240);
		}

	}

	public void mover() {
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			for (int a = 0; a < 2; a++) {
				if(Fisicas.contacto(gato, mapa.mapa)&&gato.mover) {
					gato.retroceder();
					if (gato.isSaltar()) {
						for (int i = 0; i < 3; i++) {
							if(Fisicas.contacto(gato, mapa.mapa)&&gato.mover) {
								if(Fisicas.colision(gato, mapa.mapa)==false) {
									gato.retroceder();
								}
								
							}

						}
					}
					if(caer&&gato.isSaltar()==false) {
						if(Fisicas.contacto(gato, mapa.mapa)&&gato.mover) {
							if(Fisicas.colision(gato, mapa.mapa)==false) {
								gato.retroceder();
							}
							
							//gato.retroceder();
						}
					}
				}
			}


		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			for (int a = 0; a < 2; a++) {
				if(Fisicas.contacto(gato, mapa.mapa)&&gato.mover) {
					gato.avanzar();
						if (gato.isSaltar()) {
							for (int i = 0; i < 3; i++) {
								if(Fisicas.contacto(gato, mapa.mapa)&&gato.mover) {
									if(Fisicas.colision(gato, mapa.mapa)==false) {
										gato.avanzar();
									}
									
								}
								
							}

						}
						if(caer&&gato.isSaltar()==false) {
							if(Fisicas.contacto(gato, mapa.mapa)&&gato.mover) {
								if(Fisicas.colision(gato, mapa.mapa)==false) {
									gato.avanzar();
								}
								
								//gato.avanzar();
							}
						}
				}
			}



		}
		if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
			gato.setSaltar(true);
			salto = true;
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
