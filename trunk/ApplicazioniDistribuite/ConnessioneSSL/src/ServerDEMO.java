

	import javax.net.ssl.SSLServerSocket;
	import javax.net.ssl.SSLServerSocketFactory;
	import javax.net.ssl.SSLSocket;
	public class ServerDEMO {
	  public static void main(String[] argv) throws Exception {
	    SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	    SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(7070);
	    String[] suites = serverSocket.getSupportedCipherSuites();
	    System.out.println("\nCipherSuite supportate:\n");
	    for (int i = 0; i < suites.length; i++) {
	      System.out.println(suites[i]);
	    }
	    serverSocket.setEnabledCipherSuites(suites);
	    String[] protocols = serverSocket.getSupportedProtocols();
	    System.out.println("\n\n\nProtocolli supportati:\n");
	    for (int i = 0; i < protocols.length; i++) {
	      System.out.println(protocols[i]);
	    }
	    /*
	    SSLSocket socket = (SSLSocket) serverSocket.accept();
	    socket.startHandshake();
	    System.out.println(socket.getRemoteSocketAddress());
*/	  
	  }
	}
