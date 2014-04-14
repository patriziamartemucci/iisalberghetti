import java.awt.*;
import javax.swing.*;
public class MyPanel extends JPanel {
	// nessun costruttore, va bene il default
	
	//override del metodo paintComponent
	public void paintComponent(Graphics g){
		super.paintComponent(g);//richiama il metodo paintComponent della classe JPanel
		//g è l'oggetto su cui e' possibile disegnare
		g.setColor(Color.red);
		// altre constanti (attributi public static final) di Color:
		// white, gray, lightGray, darkGray
		// red, green, yellow, pink, etc. etc.
		
		//disegna un rettangolo pieno in posizione (20,20) e di dimensione (100,80)
		g.fillRect(20,20, 100,80);
		g.setColor(Color.blue);//imposta il colore blu
		
		//disegna un rettangolo (solo contorno) di colore blu
		g.drawRect(30,30, 80,60);
		
		/* scrive con il font di default */
		Font f1=g.getFont();
	    g.drawString("Font di default: "+f1.getName(),200,10);

		/* cambia font: times con dimensione 14 */
	    Font f  = new Font("TimesRoman", Font.PLAIN, 14);
	    g.setFont(f);//impostalo sull'oggetto grafico
		/* scrive un'altra stringa */
	    g.drawString("Nuova stringa in un nuovo carattere",200,50);

		/* ancora cambiamento di font: Helvetica bold, dim 16 */
	    f = new Font("Helvetica", Font.BOLD, 16);
	    g.setFont(f);
	    g.drawString("In grassetto",200,100);

		/* grassetto+corsivo */
	    f = new Font("Courier", Font.BOLD+Font.ITALIC, 12);
	    g.setFont(f);
	    g.drawString("safdsaf",200,150);
	    
		g.setColor(Color.black);//imposta il colore nero
		g.drawString("ciao",50,60);//disegna la stringa "ciao" 
		
		g.setColor(Color.yellow);//imposta il colore giallo
		g.fillOval(150, 50, 50, 50);//disegna una circonferenza piena
		g.setColor(Color.green);//imposta il colore verde
		g.drawOval(150, 50, 50, 50);//disegna una circonferenza
		
	}
}