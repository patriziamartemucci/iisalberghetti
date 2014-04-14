import java.awt.Container;

import javax.swing.JFrame;


public class EsFile {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio Finestra ApriFile e altro");
		Container c = f.getContentPane();
		EsFilePanel p = new EsFilePanel();
		c.add(p);
		f.addWindowListener( new Terminator() );
		f.setBounds(100,100,400,400);
		f.setVisible(true);
	}
}
