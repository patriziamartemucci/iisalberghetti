import java.awt.*; 
import javax.swing.*;
public class EsSwing19 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 19");
		Container c = f.getContentPane();
		JPanel p = new Es19Panel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 200, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}