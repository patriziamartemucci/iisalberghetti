import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

class Es13bPanel extends JPanel implements ItemListener{
	JTextField txt; 
	JCheckBox ck1;
	
	public Es13bPanel(){
		super();
		txt = new JTextField(11);
		txt.setEditable(false);
		ck1 = new JCheckBox("Opzione");
		ck1.addItemListener(this);
		add(ck1); 
		add(txt);
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		if (ck1.isSelected())
			txt.setText("Opzione attivata");
		else txt.setText("Opzione disattivata");
	}
}
