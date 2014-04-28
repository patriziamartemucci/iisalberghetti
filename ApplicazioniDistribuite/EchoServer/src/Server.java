//Example 24
//    http://www.ase.md/~aursu/ClientServerThreads.html
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {

// declaration section:
// declare a server socket and a client socket for the server
// declare an input and an output stream

        ServerSocket echoServer = null;
        String line;
        DataInputStream is;
        PrintStream os;
        Socket clientSocket = null;
           

// Try to open a server socket on port 2222
// Note that we can't choose a port less than 1023 if we are not
// privileged users (root)

        try {
           echoServer = new ServerSocket(2222);
        }
        catch (IOException e) {
           System.out.println(e);
        }   

// Create a socket object from the ServerSocket to listen and accept 
// connections.
// Open input and output streams
        
       
        while(true){
        try {
        	System.out.println("Server in attesa di connessioni:");
           clientSocket = echoServer.accept();
           System.out.println("Connessione accettata");
           is = new DataInputStream(clientSocket.getInputStream());
           os = new PrintStream(clientSocket.getOutputStream());

// As long as we receive data, echo that data back to the client.

           while (true) {
             line = is.readLine();
             os.println("From server: "+ line); 
             if(line.toLowerCase().indexOf("quit")!=-1) break;
           }
        }   
        catch (IOException e) {
           System.out.println(e);
        }
        }
    }
}

