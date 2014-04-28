/**
 * @(#)SimpleServer.java
 *
 *
 * @author 
 * @version 1.00 2007/4/8
 */
 
//SimpleServer.java: un semplice programma server
import java.net.*;
import java.io.*;


public class SimpleServer{

   public static void main(String args[])throws IOException {
	// Registra il servizio sulla porta 1234
		ServerSocket s = new ServerSocket(1234);
		while(true){
		
		Socket s1=s.accept(); // Aspetta e accetta una
		// connessione

    	// Ottiene un flusso di comunicazione associato al
		// socket
		OutputStream s1out = s1.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);
		// Invia una stringa!
		dos.writeUTF("Hi there");
		// Chiude la connessione, ma non il socket server
		dos.close();
		s1out.close();
		s1.close();
		}
	}
}