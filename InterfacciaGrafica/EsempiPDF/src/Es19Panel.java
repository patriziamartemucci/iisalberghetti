import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Es19Panel extends JPanel implements ActionListener
 {
	JTextField txt; 
	JComboBox <String >list;
	
	public Es19Panel(){
		super();
		txt = new JTextField(15);
		txt.setEditable(false);
		list = new JComboBox<String>();
		list.setEditable(true);
		// per poter aggiungere nuove voci!
		list.addItem("Rosso"); list.addItem("Giallo");
		list.addItem("Verde"); list.addItem("Blu");
		list.addActionListener(this);
		add(list);
		add(txt);
	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String scelta = (String) list.getSelectedItem();
		// recupera la voce selezionata o scritta
		// dall'utente
		txt.setText("Scelta: " + scelta);
	}

}
