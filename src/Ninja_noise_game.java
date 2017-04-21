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
	  
	    audioInput = minim.getLineIn(Minim.STEREO, width, 44100, 16);
	}//end setup


	public void settings()
	{
	    size(850,850);
	
	}//end settings

	 
  

 public void draw()
	  {
	        background(0);
	        stroke(0,255,0,128); 
	        float average = 0;
	        
	        float mid = height / 2.0f;
	        
	        
	        for(int i = 0 ; i < audioInput.bufferSize() ; i ++)
	        {
	         
	            
	        	if (audioInput.left.get(i) > 0) // if statement set to accept values over zero so the sprite will not move downwards.
	        	{
	        	
		        	average +=  audioInput.left.get(i);
		            average /=  audioInput.bufferSize();
		            
	        	}//end if 
	        	
	        	
		        x = lerp(x , average * 1000000, (float) .00009);
		        //lerp function makes the movement of the ninja smooth

	            
		     
	        }
	        
	       
	       println(average);
	        
	        image(run, width- 600 ,height/2 - x, 120, 120 );
	     
	  
	    }//end draw function
	        





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] a = {"MAIN"};
	        PApplet.runSketch( a, new Ninja_noise_game());

	}

}
