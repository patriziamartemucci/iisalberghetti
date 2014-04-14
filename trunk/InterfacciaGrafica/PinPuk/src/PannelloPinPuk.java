import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PannelloPinPuk extends JPanel implements ActionListener{
	JLabel labelPin;
	JLabel labelPuk;
	JLabel labelMsg;
	
	JTextField txtPin;
	JTextField txtPuk;
	
	JButton sblocca;
	JButton blocca;
	
	int contaPin;
	int contaPuk;
	
	public  PannelloPinPuk(){
		super();
		labelPin=new JLabel("PIN");
		labelPuk=new JLabel("PUK");
		labelMsg=new JLabel("OK / Sistema bloccato. Rivolgersi ad un centro di assistenza");
		
		txtPin=new JTextField(25);
		txtPuk=new JTextField(25);
		
		sblocca=new JButton("Sblocca");
		blocca=new JButton("Blocca");
		
		this.setLayout(null);
		
		labelPin.setBounds(10,10,100,30);
		add(labelPin);
		txtPin.setBounds(100,10,100,30);
		add(txtPin);
		
		labelPuk.setBounds(10,60,100,30);
		add(labelPuk);
		txtPuk.setBounds(100,60,100,30);
		add(txtPuk);
		
		labelMsg.setBounds(10,110,400,30);
		add(labelMsg);
		
		blocca.setBounds(10,150,100,30);
		add(blocca);
		
		sblocca.setBounds(130,150,100,30);
		add(sblocca);
		
		sblocca.addActionListener(this);
		blocca.addActionListener(this);
		
		txtPuk.setVisible(false);
		labelPuk.setVisible(false);
		blocca.setVisible(false);
		labelMsg.setVisible(false);
	
		contaPin=0;
		contaPuk=0;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o=arg0.getSource();
		
		System.out.println("pin: "+contaPin);
		System.out.println("puk: "+contaPuk);
		
		if(o==sblocca){
			if(contaPin<3){
				contaPin++;
				String s=txtPin.getText();
				if(s.equals("123456")){
					blocca.setVisible(true);
					sblocca.setVisible(false);
					labelMsg.setText("Per bloccare il sistema clicca sul pulsante \"Blocca\"");
					labelMsg.setVisible(true);
					txtPin.setVisible(false);
					labelPin.setVisible(false);
				}
				else{
					if(contaPin==3){
						txtPin.setVisible(false);
						labelPin.setVisible(false);
						txtPuk.setVisible(true);
						labelPuk.setVisible(true);
					}
				}
			}
			else{
				if(contaPuk<3){
					contaPuk++;
					String s=txtPuk.getText();
					if(s.equals("654321")){
						blocca.setVisible(true);
						sblocca.setVisible(false);
						labelMsg.setText("Per bloccare il sistema clicca sul pulsante \"Blocca\"");
						labelMsg.setVisible(true);
						txtPuk.setVisible(false);
						labelPuk.setVisible(false);
					}
					else{
						if(contaPuk==3){
							txtPuk.setVisible(false);
							labelPuk.setVisible(false);
							sblocca.setVisible(false);
							labelMsg.setText("Sistema bloccato. Rivolgersi ad un centro di assistenza");
							labelMsg.setVisible(true);
						}
					}
				}
				
			}
		}
		
		if(o==blocca){
			labelPin.setVisible(true);
			txtPin.setVisible(true);
			contaPin=0;
			contaPuk=0;
			sblocca.setVisible(true);
			blocca.setVisible(false);
			txtPin.setText("");
			txtPuk.setText("");
			labelMsg.setVisible(false);
		}
	}


}