import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Es12Panel extends JPanel implements DocumentListener {
	JTextField txt1;//txt1 mi serve per scrivere il testo
	JTextField txt2;//txt2 per visualizzare quello che ho scritto in txt1
	
	public Es12Panel(){
		super();
		txt1=new JTextField("", 25);//richiama il costruttore con 2 parametri. 
		//La stringa passata come primo parametro apparira' nella casella di testo quando si avviera' l'applicazione.
		//Il secondo parametro indica la larghezza in caratteri della casella di testo
		txt2 = new JTextField(25); // larghezza in 25 caratteri della casella di testo 
		txt2.setEditable(false); // Casella di testo di sola lettura. Non modificabile direttamente dall'utente
		txt1.getDocument().addDocumentListener(this);
		// ricava il documento di cui il campo
		// di test txt1 fa parte e gli associa il
		// pannello come listener
		add(txt1);
		add(txt2);
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		// implementazione formale
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		txt2.setText(txt1.getText());
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		txt2.setText(txt1.getText());
	}
	
}

