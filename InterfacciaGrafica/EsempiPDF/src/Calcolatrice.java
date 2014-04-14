import java.awt.*; 
import javax.swing.*;
public class Calcolatrice {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio Calcolatrice");
		Container c = f.getContentPane();
		JPanel p = new CalcPanel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 300, 170);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}