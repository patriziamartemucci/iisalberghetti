
import java.io.*;

/**
 * La classe GestioneFile permette di <br>
 * - salvare i dati contenuti in una stringa nel file <br>
 * - leggere i dati contenuti in un file e salvarli in una stringa<br>
 * Il nome del file viene passato come parametro al costruttore.
 * @author Patrizia Martemucci
 * @version 1.00 2007/10/26
 */
public class GestioneFile{
	private File file;
	/**
	 *Il costruttore imposta il nome del file in cui verranno salvate le informazioni contenute in una stringa
	 *@param nomeFile nome del file
	 */
	public GestioneFile(String nomeFile){
		this.file=new File(nomeFile);
	}

    	/**
	 *Salva nel file il contenuto di una stringa passata come parametro.
	 * Se il parametro append � true, apre il file in append, altrimenti apre il file in scrittura e lo sovrascrive.
	 *@param contenuto stringa da salvare nel file
	 *@return Restituisce true se la scrittura nel file ha avuto successo, false altrimenti
	 */
	public boolean salvaFile(String contenuto, boolean append){
		try{
			FileWriter scriviFile;
			if(append)
				scriviFile=new FileWriter(file,true);
			else
				scriviFile=new FileWriter(file);
			PrintWriter streamFile=new PrintWriter(scriviFile);
			for(int i=0;i<contenuto.length();i++){
				streamFile.print(contenuto.charAt(i));
			}
			streamFile.close();
		}
		catch(IOException e){
			System.out.println("Errore "+e.getMessage());
			return false;
		}
		return true;
    }
    /**
	 *Legge il contenuto di un file, il cui nome � indicato nel costruttore, 
	 * e lo inserisce in una stringa. In caso di errore, restituisce una stringa vuota.
	 *@return contenuto del file
	 */
    	public String leggiFile(){
    		String contenuto=new String();
    		int carattere;
    		FileReader streamFile;
			try{
				streamFile=new FileReader(file);
				while((carattere=streamFile.read())!=-1){
					contenuto=contenuto+(char)carattere;
				}
				streamFile.close();
			}
			catch(IOException e){
				System.out.println("Errore "+e.getMessage());
				return (new String());//restituisci una stringa vuota
			}
		return contenuto;
    }
}