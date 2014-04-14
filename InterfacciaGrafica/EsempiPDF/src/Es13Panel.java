import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Es13Panel extends JPanel implements ActionListener{
	JTextField txt; 
	JCheckBox ck1;
	
	public Es13Panel(){
		super();
		txt = new JTextField(11);
		txt.setEditable(false);
		ck1 = new JCheckBox("Opzione");
		ck1.addActionListener(this);
		add(ck1); 
		add(txt);
	}
	
	public void actionPerformed(ActionEvent e){
		if (ck1.isSelected())
			txt.setText("Opzione attivata");
		else txt.setText("Opzione disattivata");
	}
}
