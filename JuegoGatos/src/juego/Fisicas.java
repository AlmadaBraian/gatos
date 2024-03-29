package juego;

public class Fisicas {
	
	public static boolean colision(Personajes mago, Estructura[] es) {
		for(int a=0; a<es.length;a++) {
			double masAlto=0;
			Obstaculo[] vigas = es[a].objeto;
			for (int i = 0; i < vigas.length; i++) {
				if(vigas[i].getPosy()>masAlto) {
					masAlto=vigas[i].getPosy();
				}
				if (mago.getPosY()<= vigas[i].posy  && mago.getPosY()>= vigas[i].posy - mago.getAlto() ) {
					if (mago.getPosX() > vigas[i].bordeIz && mago.getPosX() < vigas[i].bordeDer) {
						//mago.setPosY(vigas[i].posy-50);
						if (mago.getPosX() >= vigas[i].getPosx()-30 && mago.getPosX() <= vigas[i].getPosx()+30) {
							mago.setPosY(masAlto-mago.getAlto());
						}
						
						return true;
					}
				}
				
			}
		}

		return false;
	}
	
	public static boolean colision(Personajes mago, Estructura es) {
		
			Obstaculo[] vigas = es.objeto;
			double masAlto=0;
			for (int i = 0; i < vigas.length; i++) {
				if(vigas[i].getPosy()>masAlto) {
					masAlto=vigas[i].getPosy();
				}
				if (mago.getPosY()<= vigas[i].posy && mago.getPosY()>= vigas[i].posy - mago.getAlto() ) {
					if (mago.getPosX() > vigas[i].bordeIz && mago.getPosX() < vigas[i].bordeDer) {
						
						mago.setPosY(masAlto-mago.getAlto());
						return true;
					}
				}
				
			}

		return false;
	}
	
	public static boolean contacto(Personajes gato, Estructura[] es) {
		double anchoObjeto=(es[0].objeto[0].ancho)/2;
		for(int a=0; a<es.length;a++) {
			Obstaculo[] vigas = es[a].objeto;
			for (int i = 0; i < vigas.length; i++) {
				if(gato.derecha ) {
					
					if (gato.getPosX() + gato.getAncho()+7>= vigas[i].posx && gato.getPosX() + gato.getAncho()-7<= vigas[i].posx) {
						if(gato.getPosY()<= vigas[i].posy+anchoObjeto && gato.getPosY()>= vigas[i].posy-anchoObjeto) {
							return false;
						}
						
					}
				}else {
					
					if (gato.getPosX() - gato.getAncho()-7<= vigas[i].posx && gato.getPosX() - gato.getAncho()+7>= vigas[i].posx) {
						if(gato.getPosY()<= vigas[i].posy+anchoObjeto && gato.getPosY()>= vigas[i].posy-anchoObjeto)  {
							return false;
						}
						
					}
				}

			}

		}
		return true;
	}

	
	public static double distancia(Personajes gato,double posx, double posy) {
		double a =(gato.getPosX()-posx);
		a *=a;
		double b =(gato.getPosY()-posy);
		b *=b;
		double distancia = (Math.sqrt(a+b))/50;
		
		return distancia;
	}
	

	
	

}
