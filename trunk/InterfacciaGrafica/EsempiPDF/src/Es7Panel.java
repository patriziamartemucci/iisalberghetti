import java.awt.*; 

import javax.swing.*;

public class Es7Panel extends JPanel {
	//dichiaro come attributi gli oggetti da aggiungere al pannello
	JLabel l;
	
	//costruttore
	public Es7Panel(){
		super();//richiama il costruttore della super classe
		//crea un oggetto di tipo Font
		Font f  = new Font("Currier",  Font.BOLD+Font.ITALIC, 18);
		l = new JLabel("Etichetta");//crea l'oggetto JLabel
		l.setFont(f);//imposta il Font
		l.setForeground(Color.blue);//imposta il colore
		add(l);//aggiungi la label al pannello
	}
}
