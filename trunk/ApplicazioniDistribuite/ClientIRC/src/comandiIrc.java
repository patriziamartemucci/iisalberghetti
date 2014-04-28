import java.net.*;
import java.io.*;

public class comandiIrc{
        private String Server;
        private String Nick;
        private String Chan;

        private Socket socket;
        private OutputStream output;
        private InputStream input;
        private BufferedWriter writer;
        private BufferedReader reader;
        private PrintWriter print;

        private String comUser;
        private String comNick;
        private String comPing;
        private String comPong;
        private String comJoin;
        private String comPrivMsg;
        private String comPart;
        private String comQuit;
    
        private final String CRLF = "\r\n";
        private final char SP = ' ';
        
        public comandiIrc(){
        	//inizializza il vocabolario comandi
        	comUser = "USER";
            comNick = "NICK";
            comPing = "PING";
            comPong = "PONG";
            comJoin = "JOIN";
            comPrivMsg = "PRIVMSG";
            comPart = "PART";
            comQuit = "QUIT";
        }
        
        public comandiIrc(String nomeFileVocaboli){
        	//inizializza dal file nomeFileVocaboli il vocabolario comandi 
        }

        public boolean connetti(String server, String nick, String chan,boolean torBool){
        	Server=server;
        	Nick=nick;
        	Chan=chan;
        	
        	
        	try{
        		System.out.println("tor: "+torBool);
        		if(!torBool){// No TOR
        			socket=new Socket(Server,6667);
        		}
        		else{//Sì TOR
        			//SocketAddress addr = new InetSocketAddress("socks.localhost", 9050); //x TOR
        			SocketAddress addr = new InetSocketAddress("127.0.0.1", 9050); //x TOR	
        			Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr);
        			socket = new Socket(proxy);
        			InetSocketAddress dest = new InetSocketAddress(Server, 6667);
        			socket.connect(dest);
        		}
        	
        		output= socket.getOutputStream();
        		input= socket.getInputStream();

        		writer = new BufferedWriter(new OutputStreamWriter(output));
        		reader = new BufferedReader(new InputStreamReader(input));

        		print = new PrintWriter(writer);

        		print.print(comNick+SP+Nick+CRLF);
        		print.print(comUser+SP+Nick+SP+"hostname"+SP+Server+" :Realname"+CRLF);
        		print.flush();

        	}
        	catch(Exception ex){
        		//System.out.println("Connessione non riuscita.");
        		return false;
        	}
        	return true;
        }

        public void disconnetti(){
        	try{
        		print.print(comQuit+SP+CRLF);
            	print.flush();
        		socket.close();
        	}
        	catch(IOException e){}
        }

        public String ricevi(){
        	try{
        		String line = reader.readLine();
        		return line;
        	}
        	catch(IOException e){
        		return "-1";
        	}
        }

        public void pong(String line){
        	int n=line.indexOf(":");
        	String sottostringa=line.substring(n);
        	System.out.println(comPong+SP+sottostringa+CRLF);
        	print.print(comPong+SP+sottostringa+CRLF);
        	print.flush();
        }
        
        public void entraChan(){
        	print.print(comJoin+SP+"#"+Chan+CRLF);
        	print.flush();
        }
        
        public void entraChan(String chan){
        	Chan=chan;
        	print.print(comJoin+SP+"#"+Chan+CRLF);
        	print.flush();
        }

        public void esciChan(){
        	print.print(comPart+SP+"#"+Chan+CRLF);
        	print.flush();
        }


        public void scriviChan(String messaggio){
        	print.print(comPrivMsg+SP+"#"+Chan+" :"+messaggio+CRLF);
        	print.flush();
        }
        
        public void scriviComando(String messaggio){
        	print.print(messaggio+CRLF);
        	print.flush();
        }
       
        public void cambiaNick(String nick){
        	Nick=nick;
        	print.print(comNick+SP+nick+CRLF);
        	print.flush();
        }
} 

