import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class Es15Panel extends JPanel implements ActionListener {
	
	JTextField txt;
	JRadioButton b1, b2, b3;
	ButtonGroup grp;
	
	public Es15Panel(){
		super();
		txt = new JTextField(15); txt.setEditable(false);
		b1 = new JRadioButton("Mele");
		b2 = new JRadioButton("Pere");
		b3 = new JRadioButton("Arance");
		grp = new ButtonGroup();
		grp.add(b1); grp.add(b2); grp.add(b3);
		b1.addActionListener(this); add(b1);
		b2.addActionListener(this); add(b2);
		b3.addActionListener(this); add(b3);
		add(txt);
	}
	
	public void actionPerformed(ActionEvent e){
		String scelta = e.getActionCommand();
		txt.setText("Scelta corrente: " + scelta);
	}
}




















