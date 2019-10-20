package juego;

public class Fisicas {
	
	public static boolean colision(Personajes mago, Estructura[] es) {
		for(int a=0; a<es.length;a++) {
			Obstaculo[] vigas = es[a].objeto;
			for (int i = 0; i < vigas.length; i++) {
				if (mago.getPosY() + mago.getAlto() == vigas[i].posy) {
					if (mago.getPosX() > vigas[i].bordeIz && mago.getPosX() < vigas[i].bordeDer) {
						return true;
					}
				}
			}
		}

		return false;
	}
	
	public static boolean contacto(Personajes gato, Estructura[] es) {
		for(int a=0; a<es.length;a++) {
			Obstaculo[] vigas = es[a].objeto;
			for (int i = 0; i < vigas.length; i++) {
				if(gato.derecha) {
					
					if (gato.getPosX() + gato.getAncho()+5>= vigas[i].posx && gato.getPosX() + gato.getAncho()-5<= vigas[i].posx) {
						if(gato.getPosY()<= vigas[i].posy+25 && gato.getPosY()>= vigas[i].posy-25) {
							System.out.println("contacto");
							return false;
						}
						
					}
				}else {
					
					if (gato.getPosX() - gato.getAncho()-5<= vigas[i].posx && gato.getPosX() - gato.getAncho()+5>= vigas[i].posx) {
						if(gato.getPosY()<= vigas[i].posy+25 && gato.getPosY()>= vigas[i].posy-25)  {
							System.out.println("contacto");
							return false;
						}
						
					}
				}

			}

		}
		return true;
	}
	
	

}
