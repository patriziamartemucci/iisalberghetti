import java.awt.*; 
import javax.swing.*;
public class EsSwing18 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 18");
		Container c = f.getContentPane();
		JPanel p = new Es18Panel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 200, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}