/**
 * @(#)SimpleCient.java
 *
 *
 * @author 
 * @version 1.00 2007/4/8
 */

// SimpleClient.java: un semplice programma mail-client 
import java.net.*;
import java.io.*;


public class SimpleClient{
	public static void main(String args[]) throws IOException{
		int scelta=0;
		Messaggio mess=new Messaggio();
		String msg;
		String st;
		int nMes;
		// Apre la connessione a un server, sulla porta 1234  
		// Per collaudare il programma ho messo localhost, altrimenti si può far passare come parametro del main il nome del server
		// per es. String nomeServer=argv[0]; 
		// e anche il Il numero di porta 
		// int numPorta=Integer.parseInt(args[1]);
		
		
		Socket s=null;	
		s = new Socket("localhost",1234);

		// Ottiene un file handle dal socket e legge l’input
		//Stream per l'input	
		InputStream sIn = s.getInputStream();
		DataInputStream dis = new DataInputStream(sIn);
		st = new String (dis.readUTF());
		System.out.println(st);//messaggio di benvenuto dal server
		//Stream per l'output
		OutputStream sOUT=s.getOutputStream();
		DataOutputStream dos=new DataOutputStream(sOUT);
			
		while(true){
		scelta=menu();//cosa vuoi fare?
		switch(scelta){
			case 1: //SEND
					boolean err=false;
					//inserisci i dati della mail
					err=invioMail(mess);
					if(err){
						System.out.println("Errore nel formato del messaggio.");
					}
					else{//invia mail
			       		msg="Send:"+mess.toString();
			       		System.out.println("Messaggio da inviare al Server"+msg);
			       		dos.writeUTF(msg);
			       		//leggi messaggio di ritorno dal server
			       		try{
			       			st = dis.readUTF();
			       			System.out.println("\n\nMessaggio di ritorno dal server: "+st);//OK
			       			}
			       		catch(Exception e){
			       			System.out.println("recv failed! :"+e);
			       		}	
					}
			       break;
			case 2:	//LIST
					msg="List:";
					System.out.println("Messaggio da inviare al Server "+msg);
			       	dos.writeUTF(msg);//richiesta di LIST al server
			       	st = new String (dis.readUTF());//messaggio ritornato
				   	System.out.println("\n\nMessaggio di ritorno dal server: "+st);
				   	if(st.equals("Errore")){
				   		System.out.println("\nSi è verificato un errore. Non riesco a inviarti la lista dei messaggi.");
				   	}
				   	else if(st.equals("vuota")){
				   		System.out.println("\nNon ci sono messaggi nuovi");
				   	}
				   	else{
				   		System.out.println("\nLista messaggi\n"+st);//OK
				   	}
			       	break;
			case 3:	//READ
					System.out.println("Insersci il Numero del messaggio che vuoi leggere");
					nMes=leggiInt();
					msg="Read:"+nMes+":";
					System.out.println("Messaggio da inviare al Server "+msg);
			       	dos.writeUTF(msg);//invia comando READ
			       	st = new String (dis.readUTF());//messaggio ritornato
			       	System.out.println("\n\nMessaggio di ritorno dal server: "+st);
			       	if(st.equals("Errore")){
			       		System.out.println("Errore nella lettura del messaggio");
			       	}
			       	else if(st.equals("vuota")){
			       		System.out.println("Numero messaggio non corretto");
			       	}
			       	else System.out.println("Messaggio dal server: "+st);//OK
					break;
			case 4: //DELETE
					System.out.println("Insersci il Numero del messaggio che vuoi cancellare");
					nMes=leggiInt();
					msg="Delete:"+nMes+":";
					System.out.println("Messaggio da inviare al Server "+msg);
			       	dos.writeUTF(msg);//invia al server il comando DELETE
			       	st = new String (dis.readUTF());//messaggio ritornato
			       	System.out.println("\n\nMessaggio di ritorno dal server: "+st);
			       	if(st.equals("Errore")){
			       		System.out.println("Errore nella cancellazione del messaggio");
			       	}
			       	else if(st.equals("vuota")){
			       		System.out.println("Numero messaggio non corretto");
			       	}
			       	else System.out.println("Messaggio dal server: "+st);//OK
					break;
			case 5:// Alla fine, chiude la connessione e esce
					msg="Exit:";
					System.out.println("Messaggio da inviare al Server "+msg);
			       	dos.writeUTF(msg);
				   	dis.close();
					sIn.close();
					sOUT.close();
					dos.close();	
					s.close();
					System.exit(0);
		}	
		}
	}

public static int menu(){
	//per l'inserimento del comando. Ritorna un valore intero corrispondente alla scelta, oppure 0 in caso di errore
	int val=0;
	System.out.println("\n\n1-Invio email\n2-Lista messaggi\n3-Leggi messaggio\n4-Calcella email\n5-Esci\n\nComando: ");
	val=leggiInt();
	return val;
}

public static int leggiInt(){
	//lettura di un valore intero
	InputStreamReader input=new InputStreamReader(System.in);
	BufferedReader tastiera=new BufferedReader(input);
	int val=0;
	
	try{
		val=Integer.parseInt(tastiera.readLine());
	}
	catch(Exception e){
		System.out.println("Errore");
	}
	return val;
}

public static boolean invioMail(Messaggio mess){
	//inserimento dati della mail
	InputStreamReader input=new InputStreamReader(System.in);
	BufferedReader tastiera=new BufferedReader(input);
	boolean err=false;
	System.out.println("Invio EMAIL: inserisci i dati. Nei campi FROM TO SUBJECT non inserire virgole");//questo tipo di errore non è controllato!
	try{
		System.out.print("FROM: ");
		mess.from=tastiera.readLine();
		if(mess.from.length()==0) err=true;
		System.out.print("TO: ");
		mess.to=tastiera.readLine();
		if(mess.to.length()==0) err=true;
		System.out.print("SUBJECT: ");
		mess.subject=tastiera.readLine();
		if(mess.subject.length()==0) err=true;
		System.out.print("TESTO: ");
		mess.body=tastiera.readLine();
		if(mess.body.length()==0) err=true;
	}
	catch(Exception e){
		System.out.println("Errore");
		return true;
	}
	if(err) System.out.println("Devi riempire tutti i campi della mail. Riprova!");
	return err;
}

}


    
    
