package juego;

public class Mapa {
	Estructura[]mapa;
	public int length;
	Mapa(){
		
	}
	
	
	Mapa(int cantEstructuras, Estructura[]a){
		this.mapa=new Estructura[cantEstructuras];
		this.mapa=a;
		this.length=a.length;
	}
	
	public Mapa(Estructura[]a) {
		this.mapa=a;
		this.length=a.length;
		
	}


}
