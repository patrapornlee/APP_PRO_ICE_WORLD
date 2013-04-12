import java.io.*;
import sun.audio.*;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 * @author alvin alexander, devdaily.com.
 */
public class Music {
	private static String fileName;
	
	public Music (String fileName){
		this.fileName = fileName ;
		  try
		  { 
			  InputStream in = new FileInputStream(fileName);
			  AudioStream audioStream = new AudioStream(in);
			  AudioPlayer.player.start(audioStream);
		  }catch(Exception e){System.out.println("no music");}
	}
	
	/*public static void main (String  [] args) {
		new Music ("fat.au");
	}*/
}