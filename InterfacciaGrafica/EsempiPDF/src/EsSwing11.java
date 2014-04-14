import java.awt.*; 
import javax.swing.*;
public class EsSwing11 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 11");
		Container c = f.getContentPane();
		JPanel p = new Es11Panel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 300, 170);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}