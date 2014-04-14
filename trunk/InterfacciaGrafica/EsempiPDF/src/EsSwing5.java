import java.awt.*; 
import javax.swing.*;
public class EsSwing5 {
	public static void main(String[] v){
		JFrame f = new JFrame("Esempio 5: Grafico f(x)");
		Container c = f.getContentPane();
		FunctionPanel p = new FunctionPanel();
		c.add(p);
		f.setBounds(100,100,500,450);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

