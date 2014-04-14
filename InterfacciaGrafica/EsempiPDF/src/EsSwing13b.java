import java.awt.*; 
import javax.swing.*;
public class EsSwing13b {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 13b");
		Container c = f.getContentPane();
		JPanel p = new Es13bPanel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 200, 170);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}