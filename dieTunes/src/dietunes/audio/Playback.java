package dietunes.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import dietunes.listeners.CustomLineListener;

public class Playback {
	
	private static Clip clip;
	private static boolean isLoaded = false;

	// Load the audio file specified by the path into the clip
	public static void loadClip(String absolutePath) {
		
		try {
			File file = new File(absolutePath);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(inputStream);
			isLoaded = true;
		} catch (Exception e) {
			System.out.println("ERROR: Could not load the specified sound");
			e.printStackTrace();
		}
	}
	
	// Start playing the audio loaded in the clip
    public static void playClip(){
    	
    	    // Make sure the clip starts playing at the beginning
        clip.setFramePosition(0);
        
        // Add a line listener to the clip
        clip.addLineListener(new CustomLineListener());
        
        // Start the clip
        clip.start();
    }
	
	// Stop playing the clip
	public static void stopClip() {
		
		// Stop it
		clip.stop();
	}
	
	// Close the clip
	public static void closeClip() {
		
		// Close it 
		clip.close();
		
		// Set is loaded to false
		isLoaded = false;
	}
	
	// Returns true if a sound is loaded into the clip, else returns false
	public static boolean isLoaded() {
		return isLoaded;
	}
	
	// Returns true if the clip is currently active, else false
	public static boolean isActive() {
		return clip.isActive();
	}
}
