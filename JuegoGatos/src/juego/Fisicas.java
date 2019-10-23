package juego;

public class Fisicas {
	
	public static boolean colision(Personajes mago, Estructura[] es) {
		for(int a=0; a<es.length;a++) {
			Obstaculo[] vigas = es[a].objeto;
			for (int i = 0; i < vigas.length; i++) {
				if (mago.getPosY() + mago.getAlto() <= vigas[i].posy && mago.getPosY() + mago.getAlto() >= vigas[i].posy) {
					if (mago.getPosX() > vigas[i].bordeIz && mago.getPosX() < vigas[i].bordeDer) {
						//mago.setPosY(vigas[i].posy-50);
						return true;
					}
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
							System.out.println("contacto");
							return false;
						}
						
					}
				}else {
					
					if (gato.getPosX() - gato.getAncho()-7<= vigas[i].posx && gato.getPosX() - gato.getAncho()+7>= vigas[i].posx) {
						if(gato.getPosY()<= vigas[i].posy+anchoObjeto && gato.getPosY()>= vigas[i].posy-anchoObjeto)  {
							System.out.println("contacto");
							return false;
						}
						
					}
				}

			}

		}
		return true;
	}
	public static void correccion(Personajes gato, Estructura[] es) {
		
		double anchoObjeto=(es[0].objeto[0].ancho)/2;
		
		for(int a=0; a<es.length;a++) {
			Obstaculo[] vigas = es[a].objeto;
			for (int i = 0; i < vigas.length; i++) {
				if(gato.getPosY()== vigas[i].posy)  {
					if(gato.getPosX()<=vigas[i].posx+anchoObjeto && gato.getPosX()>=vigas[i].posx-anchoObjeto) {
							gato.setPosY(vigas[i].posy-vigas[i].getAlto()-7);
						
					}
				}

			}
		}

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
