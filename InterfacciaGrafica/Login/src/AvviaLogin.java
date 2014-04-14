import javax.swing.*;
import java.awt.*;
public class AvviaLogin {
	public static void main(String args[]){
		JFrame f=new JFrame("Benvenuto su Facebook");
		f.setSize(600,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=f.getContentPane();
		Login p=new Login();
		c.add(p);
		f.setVisible(true);
	}
}
