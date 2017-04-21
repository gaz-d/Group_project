//Importing minim Library so microphone features can be used 


import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;


public class Ninja_noise_game extends PApplet{
	
	Minim minim;
 	AudioInput audioInput;
	PImage run;
	PImage jump;


float x = 0;

public void setup()
	{	
		run = loadImage("ninja.png");
		jump = loadImage("ninja_run.png");
	    minim = new Minim(this);
	  
	    audioInput = minim.getLineIn(Minim.MONO, width, 44100, 16);
	}//end setup


	public void settings()
	{
	    size(850,850);
	
	}//end settings

	 
  












	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] a = {"MAIN"};
	        PApplet.runSketch( a, new Ninja_noise_game());

	}

}
