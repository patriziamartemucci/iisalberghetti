import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AvviaPinPuk {
	public static void main(String[] v){
		JFrame f = new JFrame("Blocca/Sblocca sistema");
		Container c = f.getContentPane();
		JPanel p = new PannelloPinPuk();
		c.add(p);
		f.setBounds(100,100,400,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
