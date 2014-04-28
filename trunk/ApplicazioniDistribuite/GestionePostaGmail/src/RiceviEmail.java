import java.io.InputStreamReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class RiceviEmail {

  public static void main(String args[]) {
    String pop3="",username="",password="";
    try {
    
      if (args.length<3) {
      	System.out.println("Inserire i parametri POP3 USERNAME PASSWORD");
	System.exit(0);
      }
      else
      
      {
	pop3=args[0];
	username=args[1];
	password=args[2];
      }
    }
    
    catch (Exception ex) {
      System.out.println(ex.toString());
    }
    
    ricevi(pop3,username,password);
    
  }

public static void ricevi(String pop3, String username, String password) {
	Store store=null;
	Folder folder=null;
	try {

	Properties props = System.getProperties();
	Session session = Session.getDefaultInstance(props, null);
	
	// Inizializziamo uno Store, che rappresenta il vero e proprio
	// repository dei nostri messaggi. In questo caso ci colleghiamo
	// ad uno Store POP3, ma JavaMail permette di collegarsi anche a 
	// server IMAP4
	store = session.getStore("pop3");
	store.connect(pop3, username, password);
	
	// Una volta collegati carichiamo la directory INBOX 
	// della nostra posta elettronica. Inoltre settiamo la cartella come READ_ONLY
	// per indicare che stiamo per leggere soltanto l'email
	folder = store.getDefaultFolder();
	folder = folder.getFolder("INBOX");
	folder.open(Folder.READ_ONLY);
	
	// Otteniamo quindi tutti i messaggi e stampiamo semplicemente a schermo quanti sono
	Message[] messaggi = folder.getMessages();

	System.out.println("Ci sono "+messaggi.length+" messaggi di posta nella tua casella email");
	if (messaggi.length!=0) {
		int nmes=messaggi.length-1;
		InputStreamReader im=new InputStreamReader(messaggi[nmes].getInputStream());
		System.out.println("\nLeggo il messaggio n."+nmes+": \nContentType: "+messaggi[nmes].getContentType()+
				"\nMittente: "+messaggi[nmes].getFrom()[0]);
		
		System.out.println("\nSubject: "+messaggi[nmes].getSubject()+"\nContenuto: ");
		//stampa il contenuto del messaggio 0
		int x;
		do{
			x =im.read();
			System.out.print((char)x);
		}while(x!=-1);
	}
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	
	finally {
	// Cerchiamo di chiudere il Folder e lo Store, anche perch�
	// ci sono alcuni server POP3 che lasciano bloccata l'email
	// se non effettuiamo questa operazione correttamente.
		try {
		if (folder!=null) folder.close(false);
		if (store!=null) store.close();
		}
		catch (Exception ee) {System.out.println(ee.toString());}
	}
}

}