import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
//Per eseguirlo:
//java -Djavax.net.ssl.keyStore=server.jks -Djavax.net.ssl.keyStorePassword=serverPassword SSL_Server_Socket
import java.io.PrintWriter;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSL_Server_Socket {
	private static final String CORRECT_USER_NAME = "Java";

	  private static final String CORRECT_PASSWORD = "HowToProgram";

	  private SSLServerSocket serverSocket;

	  public SSL_Server_Socket() throws Exception {
	    SSLServerSocketFactory socketFactory = (SSLServerSocketFactory) SSLServerSocketFactory
	        .getDefault();
	    //serverSocket = (SSLServerSocket) socketFactory.createServerSocket(7070);
	    serverSocket = (SSLServerSocket) socketFactory.createServerSocket(443);
	  }

	  private void runServer() {
	    while (true) {
	      try {
	        System.err.println("Waiting for connection...");
	        SSLSocket socket = (SSLSocket) serverSocket.accept();
	        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	        String userName = input.readLine();
	        String password = input.readLine();

	        if (userName.equals(CORRECT_USER_NAME) && password.equals(CORRECT_PASSWORD)) {
	          output.println("Welcome, " + userName);
	        } else {
	          output.println("Login Failed.");
	        }
	        output.close();
	        input.close();
	        socket.close();

	      } catch (IOException ioException) {
	        ioException.printStackTrace();
	      }
	    }
	  }

	  public static void main(String args[]) throws Exception {
	    SSL_Server_Socket server = new SSL_Server_Socket();
	    server.runServer();
	  }
	}