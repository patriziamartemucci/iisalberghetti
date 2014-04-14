import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Es16Panel extends JPanel implements ListSelectionListener
 {
	JTextField txt; 
	JList list;
	
	public Es16Panel(){
		super();
		txt = new JTextField(15);
		txt.setEditable(false);
		String voci[]={"Rosso","Giallo","Verde", "Blu"};
		list = new JList(voci);
		list.addListSelectionListener(this);
		add(list); add(txt);
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		String scelta = (String) list.getSelectedValue();
		txt.setText("Scelta corrente: " + scelta);
		
		
		//per gestire scelte multiple
	/*
		Object[] scelte = list.getSelectedValues();
		StringBuffer s = new StringBuffer();
		for (int i=0; i<scelte.length; i++)
		s.append((String)scelte[i] + " ");
		txt.setText("Scelte: " + s);
		*/
	}

}
