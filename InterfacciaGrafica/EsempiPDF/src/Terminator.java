import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class Terminator implements WindowListener {
	
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		// in questo modo chiudendo la finestra si esce dalla applicazione
		System.exit(0);		
	}
	
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}

}

