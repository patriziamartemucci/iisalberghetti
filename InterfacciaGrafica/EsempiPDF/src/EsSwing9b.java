import java.awt.*; 
import javax.swing.*;
public class EsSwing9b {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 9. Aggiunta del gestore degli eventi sulla finestra");
		Container c = f.getContentPane();
		JPanel p = new Es9Panel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 300, 170);
		f.addWindowListener(new Terminator());
	} 
}