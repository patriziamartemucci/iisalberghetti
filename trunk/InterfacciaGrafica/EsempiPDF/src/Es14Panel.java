import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Es14Panel extends JPanel implements ActionListener {
	JTextField txt1, txt2;
	JCheckBox c1, c2;
	
	public Es14Panel(){
		super();
		txt1 = new JTextField(15);
		txt1.setEditable(false);
		txt2 = new JTextField(15);
		txt2.setEditable(false);
		c1 = new JCheckBox("Mele");
		c1.addActionListener(this);
		c2 = new JCheckBox("Pere");
		c2.addActionListener(this);
		add(c1);
		add(c2);
		add(txt1); add(txt2);
	}
	
	public void  actionPerformed(ActionEvent e){
		Object p = e.getSource();
		if (p==c1)
			txt1.setText("Sono cambiate le mele");
		else
			txt1.setText("Sono cambiate le pere");
	
		String frase="";
		if(c1.isSelected()) frase="mele";
		if(c2.isSelected()) frase="pere";
		if(c1.isSelected() && c2.isSelected()) frase="mele pere";
		txt2.setText(frase);
		}
}










