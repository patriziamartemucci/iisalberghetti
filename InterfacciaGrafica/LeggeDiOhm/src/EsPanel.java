import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class EsPanel extends JPanel implements ActionListener{
//dichiarare come attributi tutti gli oggetti da inserire sul pannello
	private JLabel labelV;
	private JLabel labelR;
	private JLabel labelI;
	private JTextField txtV;
	private JTextField txtR;
	private JTextField txtI;
	private JButton calcola;
	private JButton azzera;
	//costruttore del pannello
	public EsPanel(){
		setLayout(null);//per mettere gli oggetti in una determinata posizione
		//crea gli oggetti. Imposta posizione e dimensione
		 labelV=new JLabel("V");
		 labelV.setBounds(120, 30, 30, 20);
		 txtV=new JTextField("0",30);
		 txtV.setBounds(140,30,160,30);
		 txtV.setEditable(false);
		 
		 labelR=new JLabel("R");
		 labelR.setBounds(120, 80, 30, 20);
		 txtR=new JTextField("0",30);
		 txtR.setBounds(140,80,160,30);
		 
		 labelI=new JLabel("I");
		 labelI.setBounds(120, 130, 30,20);
		 txtI=new JTextField("0",30);
		 txtI.setBounds(140,130,160,30);
		 
		 calcola=new JButton("Calcola");
		 calcola.setBounds(120,200, 100,30);
		 azzera=new JButton("Azzera");
		 azzera.setBounds(250,200,100,30);
		 
		 //aggiungi gli oggetti al pannello
		 add(labelV);
		 add(txtV);
		 add(labelR);
		 add(txtR);
		 add(labelI);
		 add(txtI);
		 add(calcola);
		 add(azzera);
	 
		 //rendi i bottoni reattivi al click
		 calcola.addActionListener(this);
		 azzera.addActionListener(this);
		 
	}
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();//chi ha provocato l'evento?
		if(o==calcola){//il bottone calcola?
			//gestisci l'evento click sul bottone "calcola"
			double r=Double.parseDouble(txtR.getText());
			double i=Double.parseDouble(txtI.getText());
			double v=r*i;
			txtV.setText(String.valueOf(v));
		}
		if(o==azzera){//il bottone azzera?
			//gestisci l'evento click sul bottone "azzera"
			txtR.setText("0");
			txtI.setText("0");
			txtV.setText("0");
		}	
	}
}
