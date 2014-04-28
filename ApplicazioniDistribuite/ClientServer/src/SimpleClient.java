/**
 * @(#)SimpleCient.java
 *
 *
 * @author 
 * @version 1.00 2007/4/8
 */

// SimpleClient.java: un programma client semplice
import java.net.*;
import java.io.*;

public class SimpleClient{
	public static void main(String args[]) throws IOException{
		// Apre la connessione a un server, alla porta 1234
		Socket s1=null;	
		s1 = new Socket("localhost",1234);

		// Ottiene un file handle dal socket e legge l’input
	
		InputStream s1In = s1.getInputStream();
		DataInputStream dis = new DataInputStream(s1In);
		String st = new String (dis.readUTF());
		System.out.println(st);
		dis.close();
		s1In.close();	
		s1.close();
	
		// Alla fine, chiude la connessione e esce
		
	
}
}


    
    
