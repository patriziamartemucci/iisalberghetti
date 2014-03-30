import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;


public class LetturaFileConfig {
public static void main(String args[]){
	 String nomeFileProprieta="./client.properties";
	 File f1=new File(nomeFileProprieta);	
	 
	 if(!f1.exists()){
		 JOptionPane.showMessageDialog(null,"Il file "+nomeFileProprieta+" non è presente nella cartella!" +
		 		"\nL'applicazione verrà terminata");
		 System.exit(1);
	 }
	 
	 Properties configFile = new Properties();
	 try {
			configFile.load(new FileInputStream(nomeFileProprieta));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Impossibile caricare i dati dal file di configurazione. L'applicazione verrà terminata ", 
					"Esempio lettura file config", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} 
		
	//carica i dati dal file di configurazione
	 int PORT_NO  = Integer.parseInt(configFile.getProperty("PORT_NO").trim());
	 String SERVER_IP = configFile.getProperty("SERVER_IP").trim();
	 String typeConn=configFile.getProperty("TYPE_CONNECTION").trim();
	 
	 System.out.println("IP del server: "+SERVER_IP);
	 System.out.println("Porta: "+PORT_NO);
	 System.out.println("Tipo connessione: "+typeConn);
}
}
