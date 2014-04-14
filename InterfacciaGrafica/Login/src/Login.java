import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JPanel;
public class Login extends JPanel implements ActionListener{
	private JLabel utente;
	private JLabel password;
	private JLabel ok;
	private JTextField txtUtente;
	private JPasswordField txtPwd;
	private JButton entra;
	private JButton reset;
	private int contatore;

	public Login(){
		setLayout(null);
		 utente=new JLabel("Nome utente ",JLabel.RIGHT);
		 utente.setBounds(20, 30, 160, 30);
		 txtUtente=new JTextField(30);
		 txtUtente.setBounds(240,30,160,30);
		
		 password=new JLabel("password ",JLabel.RIGHT);
		 password.setBounds(20,80,160,30);
		 txtPwd=new JPasswordField(30);
		 txtPwd.setEchoChar('*');
		 txtPwd.setBounds(240,80,160,30);
	
		 ok=new JLabel();
		 ok.setBounds(130,200,300,30);
		 ok.setVisible(false);
		
		 entra=new JButton("Entra");
		 entra.setBounds(240,130,80,30);
		 
		 reset=new JButton("Reset");
		 reset.setBounds(340,130,80,30);
		 add(utente);
		 add(txtUtente);
		 add(password);
		 add(txtPwd);
		 add(entra);
		 add(reset);
		 add(ok);
		 
		 entra.addActionListener(this);
		 reset.addActionListener(this);
		 contatore=0;
	}


	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==entra){
			String passwd=new String(txtPwd.getPassword());
			if(txtUtente.getText().equals("pippo") && passwd.equals("123456")){
				String s="Ciao " +txtUtente.getText()+". Benvenuto/a su Facebook!";
				ok.setText(s);
				ok.setVisible(true);
				txtUtente.setEditable(false);
				txtPwd.setEditable(false);
				entra.setEnabled(false);
				reset.setEnabled(false);
				contatore=0;
			}
			else{
				contatore++;
				if(contatore>2){
					String s="Hai esaurito il numero di tentativi. Accesso Bloccato!";
					ok.setText(s);
					ok.setVisible(true);
					txtUtente.setEditable(false);
					txtPwd.setEditable(false);
					entra.setEnabled(false);
					reset.setEnabled(false);
				}
			}
		}
		if(o==reset){
			txtUtente.setText("");
			txtPwd.setText("");
		}
		
	}

}
