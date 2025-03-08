package dietunes.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import dietunes.listeners.CustomWindowAdapter;
import dietunes.utilities.Resources;

public class DieTunesGUI extends JFrame {
	
	// Specs
	private static final String TITLE = "DieTunes";
	private static final Dimension SIZE = new Dimension(Resources.DEFAULT_WIDTH, Resources.DEFAULT_HEIGHT);

	// Make serializable
	private static final long serialVersionUID = 1L;
	

	// Default constructor
	public DieTunesGUI() {

		// Call JFrame constructor
		super();

		// Initialize this instance
		this.initialize();
	}
	
	// Initialize this JFrame
	private void initialize() {

		// Undecorate this frame
		// this.setUndecorated(true);
		
		// Set the title
		this.setTitle(TITLE);
		
		// Set the size 
        this.setPreferredSize(SIZE);
        // this.setMinimumSize(SIZE);
        // this.setMaximumSize(SIZE);

		// Set the layout 
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		// Add the header
		HeaderPanel header = new HeaderPanel();
		this.add(header, BorderLayout.NORTH);
		
		// Set the header panel dialogue labels
		HeaderPanel.setNowPlayingLabel("Now playing: ");
		HeaderPanel.setLibraryStatsLabel("Number of tracks: ");
		
		// Add the all group panel
		GroupPanel allGroup = new GroupPanel();
		this.add(allGroup, BorderLayout.CENTER);

		// Disable resizability
		this.setResizable(true);
		
		// Initialize GUI as not visible
		this.setVisible(true);

		// Add a custom window listener to handle exit
		CustomWindowAdapter cwa = new CustomWindowAdapter();
		this.addWindowListener(cwa);

		this.pack();
	}
}
