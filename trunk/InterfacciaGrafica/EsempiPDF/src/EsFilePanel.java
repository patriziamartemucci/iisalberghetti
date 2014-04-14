import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EsFilePanel extends JPanel implements ActionListener {
	JButton b1;
	JTextField txtFile;
	TextArea txtArea;

	
	public EsFilePanel(){
		super();
		setLayout(null);
		b1 = new JButton("Apri file");
		b1.setBounds(40, 30, 170, 30);
		b1.addActionListener(this);
		
		txtFile=new JTextField(30);
		txtFile.setBounds(20,100, 270,30);
		txtFile.setEditable(false);
		
		
		txtArea=new TextArea(10,40);
		txtArea.setBounds(20, 180, 300, 100);

		add(txtArea);
		add(txtFile);
		add(b1);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser fileChooser=new JFileChooser();
		FileFilter filter1=new FileNameExtensionFilter("Immagini  (.jpg)","jpg");
		FileFilter filter2=new FileNameExtensionFilter("Immagini  (.gif)","gif");
		fileChooser.setFileFilter(filter1);
		fileChooser.setFileFilter(filter2);
		int response = fileChooser.showOpenDialog(this);

		if(response==JFileChooser.APPROVE_OPTION) {
			try {
				File f = fileChooser.getSelectedFile();
				System.out.println(f.getAbsolutePath());
				txtFile.setText(f.getAbsolutePath());
				txtArea.append(f.getAbsolutePath()+"\n");
			}
			catch(Exception e_3) {
				System.out.println("errore nella selezione del file"+e_3.getStackTrace());
			}
	}
}
}
