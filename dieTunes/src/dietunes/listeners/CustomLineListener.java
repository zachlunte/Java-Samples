package dietunes.listeners;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import dietunes.audio.Playback;
import dietunes.gui.TrackPanel;

public class CustomLineListener implements LineListener {
	
	@Override
	public void update(LineEvent event) {
		if (!Playback.isActive()) {
			TrackPanel.removeAllPlayingIcons();
		}
	}
}
