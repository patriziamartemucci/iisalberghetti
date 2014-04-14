import java.awt.*; import javax.swing.*;
public class EsSwing4 {
	public static void main(String[] v){
		MyFrame f = new MyFrame("Esempio 4");
		// potremmo anche usare un JFrame standard...
		Container c = f.getContentPane();
		MyPanel panel = new MyPanel();
		c.add(panel);
		f.setVisible(true);
		//imposta l'angolo superiore sinistro e la dimensione della finestra
		f.setBounds(100,100,500,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
