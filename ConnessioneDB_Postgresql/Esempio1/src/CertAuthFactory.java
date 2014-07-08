import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import java.util.StringTokenizer;

public class CertAuthFactory extends SSLSocketFactory {
	//public static String CONFIG_KEYSTORE_PATH="org.postgresql.jdbc.keystore.path";
	private static String CONFIG_KEYSTORE_PWD = "org.postgresql.jdbc.keystore.password";
	//public static String CONFIG_TRUSTSTORE_PATH = "org.postgresql.jdbc.truststore.path";
	private static  String CONFIG_TRUSTSTORE_PWD = "org.postgresql.jdbc.truststore.password";
	private  static String SSL_PROTOCOL_NAME = "SSL";
	private final static String SECURE_RANDOM_NAME = "SHA1PRNG";

	protected SSLSocketFactory _internalFactory;

	public CertAuthFactory(String passwords) 
	{
		
		StringTokenizer st=new StringTokenizer(passwords,",");
		String passwordP12=st.nextToken();
		String passwordTrust=st.nextToken();
		System.out.println("Costruttore di CertAuthFactory");
		SSLContext context;
		CONFIG_KEYSTORE_PWD =passwordP12;
		CONFIG_TRUSTSTORE_PWD = passwordTrust;
		_internalFactory = null;
		try {
			context = buildSSLContext();
			_internalFactory = context.getSocketFactory();
		} catch (IOException e) {
 
			e.printStackTrace();
		} catch (GeneralSecurityException e) {

			e.printStackTrace();
		}
		
	}


	protected static SSLContext buildSSLContext() throws IOException,
			GeneralSecurityException {
		FileInputStream fInKeyStore = null;
		FileInputStream fInTrustStore = null;
		SSLContext context = null;
		try {
			
			// Load configuration
			String trustPath =null;
			String trustPwd = null;
			String keyPath =null;
			String keyPwd = null;
			//String keyPwdP12=null;

			trustPath = "./serverTrustStore.jks";
			trustPwd = CONFIG_TRUSTSTORE_PWD;
			keyPath = "./postgresql.p12";
			keyPwd = CONFIG_KEYSTORE_PWD;
			
			KeyManagerFactory managerFactory = null;
			TrustManagerFactory trustFactory = null;
			if (keyPath != null && !"".equals(keyPath)) {
				// Load the Key Managers
				KeyStore ks = KeyStore.getInstance("PKCS12");
				fInKeyStore = new FileInputStream(keyPath);
				ks.load(fInKeyStore, keyPwd.toCharArray());
				managerFactory = KeyManagerFactory.getInstance("SunX509");
				managerFactory.init(ks, keyPwd.toCharArray());
			}
			if (trustPath != null && !"".equals(trustPath)) {
				// Load the trust store
				KeyStore trustKs = KeyStore.getInstance(KeyStore
						.getDefaultType());
				fInTrustStore = new FileInputStream(trustPath);
				trustKs.load(fInTrustStore, trustPwd.toCharArray());
				trustFactory = TrustManagerFactory
						.getInstance(TrustManagerFactory.getDefaultAlgorithm());
				trustFactory.init(trustKs);
			}
			// Create + Initialize TLS context
			context = SSLContext.getInstance(SSL_PROTOCOL_NAME); 
			context.init(managerFactory.getKeyManagers(), trustFactory
					.getTrustManagers(), SecureRandom
					.getInstance(SECURE_RANDOM_NAME));
			
		} 
		finally {
			try {
				if (fInKeyStore != null)
					fInKeyStore.close();
				if (fInTrustStore != null)
					fInTrustStore.close();
			} catch (IOException e) {
			
			}
		}
		return context;			
	}

	/**
	 * Enables the client mode and the client authentication
	 * */
	protected SSLSocket enableClientAuth(SSLSocket sock) {
		sock.setNeedClientAuth(true);
		sock.setUseClientMode(true);
		return sock;
	}

	@Override
	public Socket createSocket() throws IOException {
		SSLSocket sock = (SSLSocket) _internalFactory.createSocket();
		return enableClientAuth(sock);
	}

	@Override
	public Socket createSocket(InetAddress address, int port,
			InetAddress localhost, int localPort) throws IOException {
		SSLSocket sock = (SSLSocket) _internalFactory.createSocket(address,
				port, localhost, localPort);
		return enableClientAuth(sock);
	}

	@Override
	public Socket createSocket(InetAddress host, int port) throws IOException {
		SSLSocket sock = (SSLSocket) _internalFactory.createSocket(host, port);
		return enableClientAuth(sock);
	}

	@Override
	public Socket createSocket(Socket s, String host, int port,
			boolean autoClose) throws IOException {
		SSLSocket sock = (SSLSocket) _internalFactory.createSocket(s, host,
				port, autoClose);
		return enableClientAuth(sock);
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException,
			UnknownHostException {
		SSLSocket sock = (SSLSocket) _internalFactory.createSocket(host, port);
		return enableClientAuth(sock);
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort) throws IOException, UnknownHostException {
		SSLSocket sock = (SSLSocket) _internalFactory.createSocket(host, port,
				localAddress, localPort);
		return enableClientAuth(sock);
	}

	@Override
	public String[] getDefaultCipherSuites() {
		return _internalFactory.getDefaultCipherSuites();
	}

	@Override
	public String[] getSupportedCipherSuites() {
		return _internalFactory.getSupportedCipherSuites();
	}

}
