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
	
	

}
