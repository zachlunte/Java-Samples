package dietunes.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dietunes.utilities.Resources;

public class GroupPanel extends JPanel {

	// Make serializable
	private static final long serialVersionUID = 1L;
		
	// Variable to store path to group
	private String path;

	// Default constructor makes a panel containing all audio files
	public GroupPanel() {
		
		// Set the specified path to be the entire library
	    this.path = Resources.MUSICPATH+"all"+"/";
	    
	    // Initialize this panel
	    this.initialize();
	}
	
	// Parameterized constructor makes a panel containing only audio files under specified path
	public GroupPanel(String groupName) {
		
		// Set the specified path
		this.path = Resources.MUSICPATH+groupName+"/";
		
		// Initialize this panel
	    this.initialize();
	}
	
	// Initialize the features of this panel
	private void initialize() {
		
        // Set the background color
        this.setBackground(Resources.BACKGROUND);
		
		// Set the layout of this panel
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		// Create and initialize the constraints instance
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0;
		constraints.weighty = 0;
	
		// For now, just add a label to the panel for each song in the specified path
		File dir = new File(path);
		File[] listing = dir.listFiles();
		int count = 1;
		if (listing != null) {
			for (File child : listing) {
				TrackPanel track = new TrackPanel(child.getAbsolutePath(), count);
				this.add(track, constraints);
				constraints.gridy += 1;
				count += 1;
			}
		} else {
			System.out.println("ERROR: The specified directory does not exist");
		}
		
		constraints.weighty = 1;
		constraints.weightx = 1;
		JLabel bottom = new JLabel("");
		this.add(bottom, constraints);
	}
}
