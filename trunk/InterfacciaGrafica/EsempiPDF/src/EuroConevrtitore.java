import java.awt.*; 
import javax.swing.*;
public class EuroConevrtitore {
	public static void main(String[] v){
		JFrame f = new JFrame("Euro convertitore");
		Container c = f.getContentPane();
		JPanel p = new EuroConvertitorePanel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 350, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
}