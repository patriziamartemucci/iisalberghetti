/**
 * @(#)SimpleServer.java
 *
 *
 * @author 
 * @version 1.00 2007/4/8
 */
 
//SimpleServer.java: un semplice programma mail-server
import java.net.*;
import java.io.*;
import java.util.StringTokenizer;
// il server utilizza due file per memorizzare 
// i messaggi in entrata (MailBoxIN.dat)
// i messaggi in uscita (MailBoxOUT.dat)
// Questi parametri potevano essere passati dal client come primo messaggio subito dopo la connessione,
// username+password possono per esempio essere il prefisso del nome del file contenente i messaggi + postfisso
// IN o OUT per la posta in entrata e in uscita. 
// Es: Username:Patrizia; Pass=SSRI; 
// nome file posta IN : PatriziaSSRI_IN.dat
// nome file posta OUT : PatriziaSSRI_OUT.dat.

public class SimpleServer{

   public static void main(String args[])throws IOException {
	// Registra il servizio sulla porta 1234 
		ServerSocket s = new ServerSocket(1234);
	
		Messaggio mess=new Messaggio();
		String messClient="";
	
		while(true){
		Socket s1_out=s.accept(); // Aspetta e accetta una connessione
		//per ogni connessione si può creare e lanciare un nuovo thread. Questa parte non l'ho sviluppata.

    	// Ottiene un flusso di comunicazione in OUT associato al socket
		OutputStream s1out = s1_out.getOutputStream();
		DataOutputStream dosOut = new DataOutputStream(s1out);
		// Invia un messaggio di saluto al client
		dosOut.writeUTF("Hi there. Pronto per ricevere/inviare Messaggi");
		
		//Ottiene un flusso di comunicazione in IN associato al socket
		InputStream sIn = s1_out.getInputStream();
		DataInputStream dis = new DataInputStream(sIn);
		
		//mentre il client è connesso al server
		while(true){
		String st = new String (dis.readUTF());//leggi i dati provenienti dal client
		System.out.println("Messaggio ricevuto dal client: "+st);
		//analizza la stringa ricevuta
		StringTokenizer t=new StringTokenizer(st,":");
		String comando=t.nextToken();//estrai il comando
		System.out.println("Il comando è "+comando);
		
		//se il comando è "Send"
		if(comando.equals("Send")){
			String s2=st.substring(comando.length()+1);//togli dalla stringa il comando
			//salva il messaggio nel file di messaggi in uscita
			messClient=ScriviMess(s2);
			StringTokenizer t2=new StringTokenizer(s2,",");
			//ho inserito i dati nell'oggetto mess della classe Messaggio perchè volevo salvare l'oggetto, non la stringa...
			mess.from=t2.nextToken();
			mess.to=t2.nextToken();
			mess.subject=t2.nextToken();
			mess.body=t2.nextToken()+",";
			while(t2.hasMoreTokens()){
				mess.body=mess.body+t2.nextToken()+",";
			}
			mess.body=mess.body.substring(0,mess.body.length()-1);
			System.out.println("\n\nMessaggio: "+mess);
			//salva il messaggio nel file di messaggi in uscita
			//ScriviMess(mess);
			dosOut.writeUTF(messClient);//comunica al client OK: messaggio inviato, oppure errore
		}
		
		//se il comando è "List"
		if(comando.equals("List")){
			messClient=recuperaLista();//recupera la lista dei messaggi
			dosOut.writeUTF(messClient);//inviala al client
		}
		
		//comando "Read"
		if(comando.equals("Read")){
			String numMes=t.nextToken();//estrai il numero del messaggio da leggere
			int nMes=Integer.parseInt(numMes);
			messClient=recuperaMessaggio(nMes);//recupera il messaggio
			dosOut.writeUTF(messClient);//invialo al client
		}
		
		//comando "Delete"
		if(comando.equals("Delete")){
			String numMes=t.nextToken();//estrai il numero del messaggio da cancellare
			int nMes=Integer.parseInt(numMes);
			messClient=cancellaMessaggio(nMes);//cancella il messaggio
			dosOut.writeUTF(messClient);//invia un messaggio al client sull'esito del comando
		}
		//comando "Exit"
		if(comando.equals("Exit")){
		// Chiude la connessione, ma non il socket server
			dis.close();
			sIn.close();
			dosOut.close();
			s1out.close();
			s1_out.close();
			System.out.println("\nConnessione chiusa");
			break;	//esce dal ciclo while interno
		}
		}
		//resta in attesa di altre connessioni	
		}
	}
	
	public static String ScriviMess(String mess){
		//il parametro mess contiene il messaggio completo da salvare
		String errore="OK. Messaggio inviato";
		FileWriter fileout;
		PrintWriter fout;
		try{
			fileout=new FileWriter("MailBoxOUT.dat",true);//apri il file in append
			fout=new PrintWriter(fileout);
			fout.println(mess);//scrivi il messaggio nel file
			fout.close();
		}
		catch(IOException e){
			System.out.println(e);
			errore="Errore nell'invio del messaggio";
		}
		return errore;
	}
	
	public static String recuperaLista(){
		String invia=new String("");
		String s="";
		FileReader filein;
		BufferedReader fin=null;
		boolean fineFile=false;
		Messaggio mess=new Messaggio();
		int i=0;
		//legge tutti i dati dal file della posta in entrata
		try{
			filein=new FileReader("MailBoxIN.dat");
			fin=new BufferedReader(filein);
			System.out.println("Lista messaggi");
			while((s=fin.readLine())!=null){
					StringTokenizer t2=new StringTokenizer(s,",");
		
					String from=t2.nextToken();
					String to=t2.nextToken();
					String subject=t2.nextToken();
					i++;
					invia+=i+","+from+","+subject+"\n";	//inserisci nella stringa solo i dati di interesse
				}
				fin.close();
			}
		catch(IOException ioe){
			System.out.println(ioe);
			return "Errore";
		}
		if(invia.length()==0) invia="vuota";//se la lista è vuota...
		return invia;
	}
	
	public static void aspetta(){
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader tastiera=new BufferedReader(input);
		System.out.println("Invio ");
		try{
			String s=tastiera.readLine();
		}
		catch(Exception e){
			System.out.println("Errore");
		}
	}
	
	public static String recuperaMessaggio(int nMes){
		String invia=new String("");
		String s="";
		FileReader filein;
		BufferedReader fin=null;
		boolean fineFile=false;
		//Messaggio mess=new Messaggio();
		int i=0;
		
		try{
			filein=new FileReader("MailBoxIN.dat");
			fin=new BufferedReader(filein);
			//leggi i dati dal file
			while((s=fin.readLine())!=null){
					i++;
					//cerca il mess di ordine nMes
					if(i==nMes){
						//Estrai le info che ti servono e concatenale nella stringa invia
						StringTokenizer t2=new StringTokenizer(s,",");
						String from=t2.nextToken();
						String to=t2.nextToken();
						String subject=t2.nextToken();
						String body=t2.nextToken()+",";
						while(t2.hasMoreTokens()){
							body=body+t2.nextToken()+",";
						}
						body=body.substring(0,body.length()-1);
						invia="\nFROM: "+from+"\n"+"SUBJECT: "+subject+"\n"+"BODY: "+body+"\n";	
						//System.out.println("\n\nMessaggio da inviare: "+invia);
						break;//esci dal ciclo while
					}
				}
				fin.close();
			}
		catch(IOException ioe){
			System.out.println(ioe);
			return "Errore";
		}
		if(invia.length()==0) invia="vuota";//se non ho trovato il messaggio di ordine nMes...
		return invia;
	}
	
public static String cancellaMessaggio(int nMes){
		String invia=new String("");
		String s="";
		FileReader filein;
		BufferedReader fin=null;
		FileWriter fileout=null;
		PrintWriter fout=null;
		int n=0;
		//System.out.println("Numero messaggio da cancellare: "+nMes);
		boolean fineFile=false;
		Messaggio mess=new Messaggio();
		int i=0;
		String vet[]=new String[100];
		//inserisci in un vettore tutti i messaggi contenuti nel file. Sarebbe stato meglio usare un Vector per non avere limiti
		//sulla dimensione.
		try{
			filein=new FileReader("MailBoxIN.dat");
			fin=new BufferedReader(filein);
			System.out.println("Lista messaggi");
			while((s=fin.readLine())!=null){
					vet[i++]=s;
					System.out.println(s);
					}
				fin.close();
			}
		catch(IOException ioe){
			System.out.println(ioe);
			return "Errore";
		}
		// cancella dal vettore il messaggio di ordine nMes, shiftando verso sinistra di una posizione
		//tutti gli elementi a destra di nMes
		nMes--;
		n=i;
		//controlla che nMes sia in un intervallo valido
		if(nMes<n && nMes>=0){
			for(i=nMes;i<(n-1);i++){
				vet[i]=vet[i+1];
			}
			n--;
			//riscrivi il file di dati
			try{
				fileout=new FileWriter("MailBoxIN.dat",false);//sovrascrivi il file con i dati aggiornati
				fout=new PrintWriter(fileout);
				for(i=0;i<n;i++){
					fout.println(vet[i]);
				}
				fout.close();
				invia="Messaggio cancellato";
			}
			catch(IOException e){
				System.out.println(e);
				return "Errore";
			}
		}
		else invia="vuota";//nMes non è conpreso nell'intervallo valido
		return invia;
	}
	

}