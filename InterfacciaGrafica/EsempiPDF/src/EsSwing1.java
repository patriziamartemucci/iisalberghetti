import java.awt.*;
import javax.swing.*;
public class EsSwing1 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 1");
		// crea un nuovo JFrame Inizialmente invisibile
		// con titolo "Esempio 1"
		f.setLocation(200,400);
		// (0,0) = angolo superiore sinistro

		f.setSize(300,150);
		//le misure (largezza,altezza) sono in pixel
		//tutto lo schermo: 800*600, 1024*768, etc.

		f.setVisible(true);
		// mostra il JFrame
		
		//chiude il programma quando clicco sul pulsante di chiusura della finestra
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
