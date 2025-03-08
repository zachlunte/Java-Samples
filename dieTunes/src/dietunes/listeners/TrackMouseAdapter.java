package dietunes.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dietunes.audio.Playback;
import dietunes.gui.TrackPanel;
import dietunes.utilities.Resources;

public class TrackMouseAdapter extends MouseAdapter {
	
	// String variable to store absolute path to audio file
	private String absolutePath;
	private String filename;
	
	// Panel that house the track display
	private TrackPanel trackPanel;
	
	// Parameterized constructor
	public TrackMouseAdapter(String filename, String absolutePath, TrackPanel trackPanel) {
		
		// Store the absolute path
		this.absolutePath = absolutePath;
		this.filename = filename;
		
		// Store the track panel
		this.trackPanel = trackPanel;
	}
	
	@Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("FUNCTION: Should play "+filename);
        if (trackPanel.isPlaying()) {
        	    Playback.stopClip();
        	    Playback.closeClip();
        	    trackPanel.setIsPlaying(false);
        	    trackPanel.removePlayingIcon();
        } else {
        	    TrackPanel.removeAllPlayingIcons();
        	    if (Playback.isLoaded()) {
        	    	    Playback.stopClip();
            	    Playback.closeClip();
        	    }
        	    Playback.loadClip(absolutePath);
        	    Playback.playClip();
        	    trackPanel.setIsPlaying(true);
        	    trackPanel.addPlayingIcon();
        }
    }
	
	@Override
    public void mouseEntered(MouseEvent e) {
		trackPanel.setIsSelected(true);
		trackPanel.setPlayButtonBackground(Resources.SELECTED);
        trackPanel.setBackground(Resources.SELECTED);
        trackPanel.setTextColor(Resources.TEXT_ON_SELECTED);
        
        // Change the playing icon to be the proper colored one
        if (trackPanel.isPlaying()) {
        	    trackPanel.removePlayingIcon();
        	    trackPanel.addPlayingIcon();
        }
    }
	
	@Override
    public void mouseExited(MouseEvent e) {
		trackPanel.setIsSelected(false);
		trackPanel.setPlayButtonBackground(Resources.BACKGROUND);
        trackPanel.setBackground(Resources.BACKGROUND);
        trackPanel.setTextColor(Resources.TEXT_ON_BACKGROUND);
        
        // Change the playing icon to be the proper colored one
        if (trackPanel.isPlaying()) {
        	    trackPanel.removePlayingIcon();
        	    trackPanel.addPlayingIcon();
        }
    }	
}
