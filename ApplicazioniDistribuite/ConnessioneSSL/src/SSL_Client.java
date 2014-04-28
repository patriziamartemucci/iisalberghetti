
//Per eseguirlo:
//java -Djavax.net.ssl.trustStore=serverTrustStore.jks -Djavax.net.ssl.keyStorePassword=serverPassword SSL_Client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class SSL_Client {
  public SSL_Client() {
    try {
      SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
      SSLSocket socket = (SSLSocket) socketFactory.createSocket("localhost", 443);
      PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
      //String userName = "MyUser";
      String userName = "Java";
      output.println(userName);
      //String password = "MyPassword";
      String password = "HowToProgram";
      output.println(password);
      output.flush();
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String response = input.readLine();
      System.out.println(response);

      output.close();
      input.close();
      socket.close();
    } catch (IOException ioException) {
      ioException.printStackTrace();
    } finally {
      System.exit(0);
    }
  }

  public static void main(String args[]) {
    new SSL_Client();
  }
}

