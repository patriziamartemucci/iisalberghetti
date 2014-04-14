import java.awt.*; 
import javax.swing.*;
public class EsSwing6a {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 6a: Animazioni grafiche");
		Container c = f.getContentPane();
		JPanel p = new Es6aPanel();
		
		c.add(p);
		f.setBounds(100,100,500,450);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

