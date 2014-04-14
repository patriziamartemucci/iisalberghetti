import java.awt.*; 
import javax.swing.*;
public class EsSwing8 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 8");
		Container c = f.getContentPane();
		JPanel p = new Es8Panel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 300, 170);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}