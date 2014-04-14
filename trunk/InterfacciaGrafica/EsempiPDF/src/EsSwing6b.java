import java.awt.Container;

import javax.swing.JFrame;


public class EsSwing6b {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio di disegno di immagini");
		Container c = f.getContentPane();
		Es6bPanel p = new Es6bPanel();
		c.add(p);
		f.setBounds(100,100,300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
