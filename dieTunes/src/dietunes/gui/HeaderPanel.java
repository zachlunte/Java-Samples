package dietunes.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dietunes.utilities.Resources;

public class HeaderPanel extends JPanel {
	
	// JPanel specifications
	private static final Dimension SIZE = new Dimension(Resources.DEFAULT_WIDTH, 64+40);
	private static final Dimension IMAGESIZE = new Dimension(128, 64);
	private static final Dimension BARSIZE = new Dimension(Resources.DEFAULT_WIDTH, 16);
	private static final String HEADER_FILE = "header.png";
	

	// Make serializable
	private static final long serialVersionUID = 1L;
	
	private static JLabel nowPlaying;
	private static JLabel libraryStats;
	
	// Default constructor
	public HeaderPanel() {

		// Set the size 
		this.setPreferredSize(SIZE);
		this.setMinimumSize(SIZE);
		this.setMaximumSize(SIZE);

		// Set the layout
		this.setLayout(new BorderLayout());

		// Set the background color
		this.setBackground(Resources.ALT_BACKGROUND);
		
		// Set the padding of this panel
		this.setBorder(new EmptyBorder(0, 0, 0, 0));

		// Create the header label
		JLabel header = new JLabel();
		
		// Create the now playing label
		nowPlaying = new JLabel();

		// Create the library stats label
		libraryStats = new JLabel();
		
		// Set the font of the label
		nowPlaying.setFont(new Font("Courier New", Font.BOLD, 12));
		libraryStats.setFont(new Font("Courier New", Font.BOLD, 12));
        
        // Set the alignment
		nowPlaying.setVerticalAlignment(SwingConstants.CENTER);
		libraryStats.setVerticalAlignment(SwingConstants.CENTER);
		nowPlaying.setHorizontalAlignment(SwingConstants.CENTER);
		libraryStats.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set the font color
		nowPlaying.setForeground(Resources.TEXT_ON_BACKGROUND);
		libraryStats.setForeground(Resources.TEXT_ON_BACKGROUND);
		
		// Add the dialogue labels to this panel
		this.add(nowPlaying, BorderLayout.CENTER);
		this.add(libraryStats, BorderLayout.EAST);
		
		JPanel topBar = new JPanel();
		topBar.setPreferredSize(BARSIZE);
		topBar.setMinimumSize(BARSIZE);
		topBar.setMaximumSize(BARSIZE);
		topBar.setBackground(Resources.BAR);
		this.add(topBar, BorderLayout.NORTH);
		
		JPanel bottomBar = new JPanel();
		bottomBar.setPreferredSize(BARSIZE);
		bottomBar.setMinimumSize(BARSIZE);
		bottomBar.setMaximumSize(BARSIZE);
		bottomBar.setBackground(Resources.BAR);
		this.add(bottomBar, BorderLayout.SOUTH);
		

		// Try to load the header image
		try {

			// Load the header image
			File headerFile = new File(Resources.IMAGEPATH + HEADER_FILE);
			Image headerImage;
			headerImage = ImageIO.read(headerFile);

			// Scale the header image
			Image scaledHeader = headerImage.getScaledInstance(IMAGESIZE.width, IMAGESIZE.height, java.awt.Image.SCALE_SMOOTH);

			// Create the header icon from the header image
			ImageIcon headerIcon = new ImageIcon(scaledHeader);

			// Add the header icon to the header label
			header.setIcon(headerIcon);
			
			// Set the horizontal alignment of the header label
			header.setHorizontalAlignment(SwingConstants.LEFT);
			
			// Create a name for the header image lable
			header.setName("header_image");

			// Add the header to the panel
			this.add(header, BorderLayout.WEST);

			// If failed to load header image, throw io exception
		} catch (IOException e) {
			e.printStackTrace();
		}        
	}
	
	// Sets the now playing label text
	public static void setNowPlayingLabel(String text) {
		nowPlaying.setText(text);
	}
	
	// Sets the library stats label text
	public static void setLibraryStatsLabel(String text) {
		libraryStats.setText(text);
	}
}
