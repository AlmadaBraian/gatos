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
	Estructura[] mapa;
	Estructura a,b,c,d,e;
	boolean salto=false,moverMapa=false;
	int contador = 0, vueltasSalto = 23;
	//Obstaculo a = new Obstaculo(130, 250);
	
	Main(){
		this.entorno = new Entorno(this, "Gato loco - V0.01", ancho, alto);
		this.gato=new Personajes(200, 150, 50.0, 50.0, 0);
		this.a=new Estructura(130,250,4,2);
		b=new Estructura(130,100,1,4);
		c=new Estructura(20,500,20,2);
		d=new Estructura(20,500,20,2);
		e=new Estructura(450,450,2,2);
		this.mapa=new Estructura[4];
		mapa[0]=a;
		mapa[1]=b;
		mapa[2]=c;
		mapa[3]=e;
		
		this.entorno.iniciar();
		//entorno.dibujarRectangulo(gato.getPosX(), gato.getPosY(), gato.getAncho(), gato.getAlto(), 0.0, Color.gray);
	}
	
	public void dibujarMapa() {
		for(int i=0;i<mapa.length;i++) {
			if(moverMapa) {
				if(gato.derecha==false) {
					mapa[i].moverD();
					if (gato.isSaltar()) {
						for (int a = 0; a < 4; a++) {
							mapa[i].moverD();

						}
					}
				}else {
					mapa[i].moverI();
					if (gato.isSaltar()) {
						for (int a = 0; a < 4; a++) {
							mapa[i].moverI();

						}
					}
				}
			}
			mapa[i].Dibujar(entorno);
		}
	}

	
	
	public void tick() {
		
		gato.Dibujar(entorno);
		dibujarMapa();
		mover();
		comprobar();
		System.out.println(gato.getPosX());
		
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
		if(Fisicas.colision(gato, mapa)==false) {
			gato.caer();
		}
		
	}
	
	public void comprobar() {

		gato.mover = false;
		moverMapa=false;
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			gato.derecha = false;
			if(gato.getPosX()<=140) {
				moverMapa=true;
			}else {
				gato.mover = true;
			}
			
			
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			gato.derecha = true;
			if(gato.getPosX()>=530) {
				moverMapa=true;
			}else {
				gato.mover = true;
			}
			
		}
	}

	public void mover() {
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			if(Fisicas.contacto(gato, mapa)&&gato.mover) {
				gato.retroceder();
				gato.retroceder();
				if (gato.isSaltar()) {
					for (int i = 0; i < 4; i++) {
						gato.retroceder();

					}
				}
			}

		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			if(Fisicas.contacto(gato, mapa)&&gato.mover) {
				gato.avanzar();
				gato.avanzar();
					if (gato.isSaltar()) {
						for (int i = 0; i < 4; i++) {
							gato.avanzar();
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
