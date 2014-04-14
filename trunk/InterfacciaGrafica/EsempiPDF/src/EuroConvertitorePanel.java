import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class EuroConvertitorePanel extends JPanel implements ActionListener {
	
		JButton b,c,d;
		JTextField txt1, txt2;
		private JLabel euro,dollaro;
		public EuroConvertitorePanel(){
			super();
			this.setLayout(null);
			euro= new JLabel ("euro");
			dollaro= new JLabel ("dollaro");
			b = new JButton("da € a $");
			c = new JButton("da $ a €");
			d = new JButton("reset");
			txt1=new JTextField("0",10 );
			txt2 = new JTextField("0",10); 
			b.addActionListener(this);
			c.addActionListener(this);
			d.addActionListener(this);
			euro.setBounds(10, 10, 40, 20);
			txt1.setBounds(50, 10, 80, 20);
			dollaro.setBounds(140, 10, 150, 20);
			txt2.setBounds(200, 10, 80, 20);
			b.setBounds(10, 50, 130, 20);
			c.setBounds(155, 50, 130, 20);
			d.setBounds(80, 80, 150, 50);
			add(euro);
			add(txt1);
			add(dollaro);
			add(txt2);
			add(b);
			add(c);
			add(d);
			
	}
	
		public void actionPerformed(ActionEvent e){
		double valore = 0.0; 
	//		String s="";
			Object pulsantePremuto = e.getSource();
			
			if (pulsantePremuto==b){
				valore = Double.parseDouble(txt1.getText())*1.3;
				valore=((int)(valore*100))/100.0;
				txt2.setText( "" + valore);
				
			}
			
			if (pulsantePremuto==c){
				valore = Double.parseDouble(txt2.getText())/1.3;
				valore=((int)(valore*100))/100.0;
				txt1.setText( ""+valore);
			}
			if (pulsantePremuto==d){
				txt1.setText( "0" );
				txt2.setText( "0" );
			}

		}
	}




