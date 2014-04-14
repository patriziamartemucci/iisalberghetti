import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Es18Panel extends JPanel implements ListSelectionListener
 {
	JTextField txt; 
	JList <String> list;
	
	public Es18Panel(){
		super();
		txt = new JTextField(15);
		txt.setEditable(false);
		String voci[]={"Rosso","Giallo","Verde", "Blu"};
		list = new JList<String>(voci);
		list.addListSelectionListener(this);
		JScrollPane pane = new JScrollPane(list);
		list.setVisibleRowCount(3);
		add(pane); add(txt);
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
