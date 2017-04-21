//Importing minim Library so microphone features can be used.
//Reyan
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
		run = loadImage("ninja.png");//image for when the ninja is on a platform .
		jump = loadImage("ninja_jump.png");//image for when the ninja is in the air (jumping)
	    minim = new Minim(this);
	  
	    audioInput = minim.getLineIn(Minim.STEREO, width, 44100, 16);// sampled at CD quality .
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
	        
	       
	        
	        //for statement to read in values generated from the users microphone.
	        for(int i = 0 ; i < audioInput.bufferSize() ; i ++)
	        {
	         
	            
	        	if (audioInput.left.get(i) > 0) 
	      // if statement set to accept values over zero so the sprite will not move downwards.
	        	{
	        	
		        	average +=  audioInput.left.get(i);
		            average /=  audioInput.bufferSize();
		            
	        	}//end if 
	        	
	        	
		        x = lerp(x , average * 1000000, (float) .00009);
		        //lerp function makes the movement of the ninja smooth

	            
	        }//end for 
	        
	       
	       println(average);//used for testing values
	       
	       
	       
	      
	        image(jump, width- 600 ,height/2 -x , 120, 120 );
	        //this is the image to be displayed when the ninja is jumping
	        //(ie. when the user is making noise for the character to jump)
	        
	        if   ( average  <= 7.1848355E-8)
	        {
	        	image(run, width- 600 ,height/2 - x, 120, 120 );
	        }// if statement to make the ninja run when the user is not making noise
	        //(ie meaning they dont want the character to jump )
	     
	  
	    }//end draw function
	        


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] a = {"MAIN"};
	        PApplet.runSketch( a, new Ninja_noise_game());

	}

}//end class 
