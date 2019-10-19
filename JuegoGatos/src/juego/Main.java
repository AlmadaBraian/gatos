package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Main extends InterfaceJuego{
	private Entorno entorno;
	int ancho = 800, alto = 600;
	Personajes gato;
	Estructura[] mapa;
	Estructura a;
	boolean salto=false;
	int contador = 0, vueltasSalto = 23;
	//Obstaculo a = new Obstaculo(130, 250);
	
	Main(){
		this.entorno = new Entorno(this, "Gato loco - V0.01", ancho, alto);
		this.gato=new Personajes(150, 150, 50.0, 50.0, 0);
		this.a=new Estructura(130,250,4,2);
		this.mapa=new Estructura[1];
		mapa[0]=a;
		
		this.entorno.iniciar();
		//entorno.dibujarRectangulo(gato.getPosX(), gato.getPosY(), gato.getAncho(), gato.getAlto(), 0.0, Color.gray);
	}
	
	public void tick() {
		
		gato.Dibujar(entorno);
		a.Dibujar(entorno);
		mover();
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
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			gato.derecha = false;
			gato.mover = true;
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			gato.derecha = true;
			gato.mover = true;
		}
	}

	public void mover() {
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
				gato.retroceder();
				if (gato.isSaltar()) {
					for (int i = 0; i < 4; i++) {
						gato.retroceder();

					}
				}
		}
		if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			gato.avanzar();
				if (gato.isSaltar()) {
					for (int i = 0; i < 4; i++) {
						gato.avanzar();
					}

				}

		}
		if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
			gato.setSaltar(true);
			salto = true;
		}
		comprobar();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
