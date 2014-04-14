
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame {
	//costruttore senza parametri
	public MyFrame(){
		super(); //richiama il costruttore della super classe
		
		//imposta l'angolo superiore sinistro e la dimensione della finestra
		setBounds(200,100,300,150);
	}
	
	//costruttore con parametro
	public MyFrame(String titolo){
		super(titolo);
		setBounds(200,100, 300,150);
	}
}
