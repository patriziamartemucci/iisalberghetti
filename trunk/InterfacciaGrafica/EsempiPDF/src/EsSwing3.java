import java.awt.*;
import javax.swing.*;
public class EsSwing3 {
	public static void main(String[] v){
		//JFrame con l'aggiunta di un contenitore JPanel
		MyFrame f = new MyFrame("Esempio 3");
		//prendi il contenitore del JFrame e assegnalo al Container c
		Container c = f.getContentPane();
		//crea un nuovo pannello
		JPanel panel = new JPanel();
		//colora di rosso
		panel.setBackground(Color.RED);
		//aggiungi il pannello al conteiner c
		c.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}