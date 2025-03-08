package dietunes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dietunes.listeners.TrackMouseAdapter;
import dietunes.utilities.Resources;

public class TrackPanel extends JPanel {
	
	// Make serializable
	private static final long serialVersionUID = 1L;
	
	// JPanel specifications
	private static final Dimension SIZE = new Dimension(Resources.DEFAULT_WIDTH, 20);
	private static final Dimension PLAYBUTTON_SIZE = new Dimension(32,16);

	// Create String to store the name of the file
	private String filename;
	private String absolute;
	private int filecount;
	
	// State related variables
	private boolean isPlaying;
	private boolean isSelected;
	
	// Create the label to store the track name
	private JLabel track;
	
	// Create the panel to store the playbutton
	private JPanel playPanel;
	
	// This class also keeps an array list of all trackpanels created
	public static ArrayList<TrackPanel> trackPanels = new ArrayList<>();
	
	// Default constructor
	public TrackPanel(String absolutePath, int count) {
			    
		// Get the name of the file
		this.absolute = absolutePath;
	    this.filename = absolutePath.substring(absolutePath.lastIndexOf("/")+1);
	    
	    // Store the count number 
	    this.filecount = count;
	    
	    // Initialize this panel
	    this.initialize();
	    
	    // Add this new track panel to the array list of track panels
	    trackPanels.add(this);
	}
	
	private void initialize() {
		
		// Initialize track to not be playing
		isPlaying = false;
		
		// Set the layout manager of this panel
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
				
		// Set the preferred size of this panel
        this.setPreferredSize(SIZE);
        this.setMinimumSize(SIZE);
        this.setMaximumSize(SIZE);
        
        // Set the background color
        this.setBackground(Resources.BACKGROUND);
        
        // Set the padding of this panel
        // this.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        // Create a panel to house the playing icon
        playPanel = new JPanel();
        playPanel.setLayout(new BorderLayout());
        playPanel.setBorder(new EmptyBorder(0, 8, 0, 8));
        playPanel.setBackground(Resources.BACKGROUND);
        playPanel.setPreferredSize(PLAYBUTTON_SIZE);
        playPanel.setMinimumSize(PLAYBUTTON_SIZE);
        playPanel.setMaximumSize(PLAYBUTTON_SIZE);
        this.add(playPanel, BorderLayout.WEST);
        
        // Create a label for the filename
        track = new JLabel(filecount+". "+filename);
        
        // Set the font of the label
        track.setFont(new Font("Courier New", Font.BOLD, 12));
        
        // Set the vertical alignment
        track.setVerticalAlignment(SwingConstants.CENTER);
        
        // Set the font color
        track.setForeground(Resources.TEXT_ON_BACKGROUND);
        
        // Add the track label to this panel
        this.add(track, BorderLayout.CENTER);
        
        // Create and add a mouse listener to this track panel
        TrackMouseAdapter tma = new TrackMouseAdapter(filename, absolute, this);
        this.addMouseListener(tma);
	}
	
	// Setter method to set the text color of the track display
	public void setTextColor(Color color) {
		track.setForeground(color);
	}
	
	// Setter method to set the background color of the play button panel
	public void setPlayButtonBackground(Color color) {
		playPanel.setBackground(color);
	}
	
	// Adds the playing icon to the playPanel via a JLabel
	public void addPlayingIcon() {
		try {
			BufferedImage playbutton;
			if (isSelected) {
				playbutton = ImageIO.read(new File(Resources.IMAGEPATH+"playing_selected.png"));
			} else {
				playbutton = ImageIO.read(new File(Resources.IMAGEPATH+"playing_deselected.png"));
			}
			JLabel playbuttonLabel = new JLabel(new ImageIcon(playbutton));
			playPanel.add(playbuttonLabel, BorderLayout.CENTER);
			
			// Refresh the panel
			playPanel.revalidate();
			playPanel.repaint();
		} catch (IOException e) {
			System.out.println("ERROR: Unable to load playing icon");
			e.printStackTrace();
		}
	}
	
	// Removes the playing icon from the playPanel
	public void removePlayingIcon() {
		
		// Get the components in the panel
		Component[] componentList = playPanel.getComponents();

		// For each component in the panel
		for(Component c : componentList){
			
			// Remove the component
		    playPanel.remove(c);
		}

		// Refresh the panel
		playPanel.revalidate();
		playPanel.repaint();
	}
	
	// Set whether or not this track is playing
	public void setIsPlaying(boolean state) {
		isPlaying = state;
	}
	
	// Get whether or not this track is playing
	public boolean isPlaying() {
		return isPlaying;
	}
	
	// Set whether or not this track is selected
	public void setIsSelected(boolean state) {
		isSelected = state;
	}
	
	// Get whether or not this track is selected
	public boolean isSelected() {
		return isSelected;
	}
	
	// Removes playing icons from all track panels
	public static void removeAllPlayingIcons() {
		
		// For each component in the panel
		for(TrackPanel tp : trackPanels){

			// Remove the component
			tp.removePlayingIcon();
			
			// Set the track panel to not playing
			tp.setIsPlaying(false);
		}
	}
}
