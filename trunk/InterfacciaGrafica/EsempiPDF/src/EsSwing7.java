import java.awt.*; 
import javax.swing.*;
public class EsSwing7 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 7");
		Container c = f.getContentPane();
		
		//Creo un oggetto di tipo Es7Panel e lo assegno ad un riferimento di tipo JPanel.
		//Esegue un Upcast (conversione implicita) a JPanel (Es7Panel e' una sottoclasse di JPanel)
		JPanel p = new Es7Panel();
		c.add(p);
		f.setVisible(true);
		f.setBounds(100, 100, 300, 170);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	} 
}

