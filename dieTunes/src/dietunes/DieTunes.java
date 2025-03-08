package dietunes;

import dietunes.gui.DieTunesGUI;

public class DieTunes {
	
	public static void main(String[] args) {
	
		// Create the GUI
		DieTunesGUI gui = new DieTunesGUI();

		// Center it on screen
		gui.setLocationRelativeTo(null);

		// Bring it to the front
		gui.requestFocus();
	}
}
