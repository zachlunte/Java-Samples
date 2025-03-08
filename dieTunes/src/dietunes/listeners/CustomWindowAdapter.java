package dietunes.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CustomWindowAdapter extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
    	
    	    // Exit the system
    	    	System.exit(0);
    }
}