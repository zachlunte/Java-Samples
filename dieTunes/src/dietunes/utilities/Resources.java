package dietunes.utilities;

import java.awt.Color;

public class Resources {
	
	// Constant ints
	public static final int DEFAULT_WIDTH = 512;
	public static final int DEFAULT_HEIGHT = 512;
	
	// Resource paths
	public static final String IMAGEPATH = System.getProperty("user.dir") + "/files/images/";
	public static final String MUSICPATH = System.getProperty("user.dir") + "/files/music/";
	
	// Color paths
	public static final Color BACKGROUND = new Color(10, 40, 10);
	public static final Color TEXT_ON_BACKGROUND = new Color(0, 200, 0);
	public static final Color SELECTED = new Color(0, 255, 0);
	public static final Color TEXT_ON_SELECTED = new Color(20,100,20);
	public static final Color ALT_BACKGROUND = new Color(10,70,10);
	public static final Color BAR = new Color(20,130,20);
}
