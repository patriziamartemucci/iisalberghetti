//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.*;


public class Es8Panel extends JPanel implements ActionListener{
	private JLabel l;
	private JButton b;

	public Es8Panel(){
		super();
		l = new JLabel("Tizio");
		add(l);
		b = new JButton("Tizio/Caio");// Tizio/Caio e' l'etichetta che appare sul pulsante
		b.addActionListener(this);//il JButton b puo' generare l'evento clic
		// registra l'oggetto Es8Panel (this) come ascoltatore degli eventi 
		add(b); 
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//actionPerformed e' il gestore degli eventi. 
		//Reagisce (viene invocato) quando viene generato un evento su uno degli oggetti "cliccabili" 
		//(quelli che sono stati aggiunti all'ActionListener tramite il metodo addActionListener, in questo esempio solo l'oggetto b)
		
		//si e' verificato un evento clic su b
		if (l.getText().equals("Tizio"))//se l'etichetta e' Tizio cambiala in Caio
			l.setText("Caio");
		else//viceversa se l'etichetta e' Caio cambiala in tizio
			l.setText("Tizio");
	}
}
