import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ApriFinestraDialogoFile extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	private JButton apri;
	private JButton salva;
	private JFileChooser fa;
	private JFileChooser fs;

	
	public ApriFinestraDialogoFile(){
		super("Esempio di finestra di dialogo APRI FILE");
		apri=new JButton("APRI FILE");
		apri.addActionListener(this);
		//add(apri);
		
		salva=new JButton("SALVA FILE");
		salva.addActionListener(this);
		//add(salva);
		
		 JPanel buttonPanel = new JPanel(); 
		 buttonPanel.add(apri);
		 buttonPanel.add(salva);
		 
		 add(buttonPanel, BorderLayout.PAGE_START);
		
		setSize(400,400);
		setVisible(true);
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApriFinestraDialogoFile ap=new ApriFinestraDialogoFile();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==apri){
			fa=new JFileChooser();
			//FileFilter filter1=new FileNameExtensionFilter("Java KeyStore","jks");
			//fa.setFileFilter(filter1);
			//per aggiungere un filtro
			//fileChooser.addChoosableFileFilter(filter1);
		
			int response = fa.showOpenDialog(ApriFinestraDialogoFile.this);
			
			System.out.println("Response: "+response);
			if(response==JFileChooser.APPROVE_OPTION) {
				try {
					File f = fa.getSelectedFile();
					System.out.println(f.getName());
					System.out.println(f.getAbsolutePath());
				}
				catch(Exception e_3) {
					System.out.println("Errore"+e_3.getStackTrace());
				}
			}
		}
		
		if(e.getSource()==salva){
			fs=new JFileChooser();
			fs.setDialogType(JFileChooser.SAVE_DIALOG);
		
			int response = fs.showSaveDialog(ApriFinestraDialogoFile.this);
			System.out.println("Response: "+response);
			if(response==JFileChooser.APPROVE_OPTION) {
				try {
					File f = fs.getSelectedFile();
					System.out.println(f.getName());
					System.out.println(f.getAbsolutePath());
				}
				catch(Exception e_3) {
					System.out.println("Errore"+e_3.getStackTrace());
				}
			}
		}
	}

}
