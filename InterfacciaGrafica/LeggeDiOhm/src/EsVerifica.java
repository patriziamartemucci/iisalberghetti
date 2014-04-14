import java.awt.*;
import javax.swing.*;

public class EsVerifica {

	public static void main(String[] args) {
		//crea la finestra e imposta il titolo
		JFrame f=new JFrame("Legge di Ohm");
		f.setSize(600,300);//imposta le dimensioni
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//esci se chiudi la finestra
		Container c=f.getContentPane();//prendi il contenitore della finestra
		EsPanel p=new EsPanel();//dichiara il pannello da aggiungere
		c.add(p);//aggiungi il pannello
		f.setVisible(true);//rendi visibile la finestra
	}

}
