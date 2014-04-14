import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Es10Panel extends JPanel implements ActionListener {
	
	
	
	JButton b;
	JTextField txt1;//txt1 mi serve per scrivere il testo
	JTextField txt2;//txt2 per visualizzare quello che ho scritto in txt1
	
	public Es10Panel(){
		super();
		b = new JButton("Aggiorna");
		txt1=new JTextField("Scrivere qui il testo", 25);//richiama il costruttore con 2 parametri. 
		//La stringa passata come primo parametro apparira' nella casella di testo quando si avviera' l'applicazione.
		//Il secondo parametro indica la larghezza in caratteri della casella di testo
		txt2 = new JTextField(25); // larghezza in 25 caratteri della casella di testo 
		txt2.setEditable(false); // Casella di testo di sola lettura. Non modificabile direttamente dall'utente
		b.addActionListener(this);
		add(txt1);
		add(txt2);
		add(b);
	}
	
	public void actionPerformed(ActionEvent e){
		//al verificarsi dell'evento clic sul bottone, prendi il testo contenuto nella txt1 e impostalo nella txt2
		txt2.setText( txt1.getText() );
	}
}

