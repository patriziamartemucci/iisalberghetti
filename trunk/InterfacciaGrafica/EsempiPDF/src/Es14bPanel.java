import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

class Es14bPanel extends JPanel implements ItemListener{
	JTextField txt1, txt2;
	JCheckBox c1, c2;
	
	public Es14bPanel(){
		super();
		txt1 = new JTextField(15);
		txt1.setEditable(false);
		txt2 = new JTextField(15);
		txt2.setEditable(false);
		c1 = new JCheckBox("Mele");
		c1.addItemListener(this);
		c2 = new JCheckBox("Pere");
		c2.addItemListener(this);
		add(c1);
		add(c2);
		add(txt1); add(txt2);
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object p = e.getItemSelectable();
		if (p==c1)
			txt1.setText("Sono cambiate le mele");
		else
			txt1.setText("Sono cambiate le pere");
	
		String frase = (c1.isSelected() ? "Mele " : "")
				+ (c2.isSelected() ? "Pere" : "");
				
		txt2.setText(frase);
	}
}










