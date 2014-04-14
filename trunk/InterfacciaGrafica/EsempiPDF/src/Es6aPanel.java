//import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.Timer;

//L'implementazione dell'interfaccia ActionListener e' spiengata da pag.23
public class Es6aPanel extends JPanel implements ActionListener{
	int posx, posy; 
	int dimx, dimy;
	Timer t;//oggetto timer della classe swing
	
	public Es6aPanel () {
		posx =100; posy = 100;
		dimx=20; dimy = 20;
		this.setBackground(Color.yellow);
		//imposta il timer a 100 ms
		t=new Timer(100,this);//ogni 100 ms genera l'evento
		t.start();//fai partire il timer
		}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		//disegna un quadrato pieno di colore rosso
		g.fillRect(posx,posy, 20, 20);
	}
		
	public void aggiorna () {
		Graphics g = getGraphics();
		//disegna il quadrato pieno di colore giallo (cancella quello rosso)
		g.setColor(Color.yellow);
		g.fillRect(posx, posy,dimx, dimy);
		//aggiorna le coordinate
		posx=posx+ 10; posy=posy+ 5;
		if(posx>this.getWidth()-100){
			t.stop();
			System.out.println("Timer stop");
		}
		else repaint();	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==t){
			//se l'evento è stato generato dal timer 
			//calcella il vecchio quadrato (disegna il quadrato col colore uguale a quello di sfondo)
			//e disegna quello rosso nella nuova posizione
			aggiorna();
		}
	}
}