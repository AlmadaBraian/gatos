package juego;
import javax.swing.*;  
import java.awt.event.*;  
import java.applet.*;  
import java.io.*;  
class Audio extends JFrame implements ActionListener  
{  
  File wavFile;  
  AudioClip sound;  
  public Audio(String nombre)  
  {  
	  	this.wavFile=new File(nombre);
	    try{sound = Applet.newAudioClip(wavFile.toURL());}  
	    catch(Exception e){e.printStackTrace();} 
  }  
  //public void actionPerformed(ActionEvent ae){sound.play();}  
	//public static void main(String[] args) throws Exception {
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

//		System.out.println("1");
//		URL url = new URL("http://www.edu4java.com/es/game/sound/back.wav");
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

//		URL url = new URL(
//			"file:/C:/eclipseClasic/workspace/minitennis/src/com/edu4java/minitennis7/back.wav");
		//Audio audio= new Audio("8bitkit-jump-9.wav");
		//audio.sound.play();
		
		//System.out.println("end");
	//}    
} 
