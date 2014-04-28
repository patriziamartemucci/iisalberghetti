import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public final class ClientIRC
{
	comandiIrc irc;

	public static void main(String[] args){
		new ClientIRC();
	}

	public ClientIRC(){
		//System.setProperty("socksProxyHost", "127.0.0.1");
	    //System.setProperty("socksProxyPort","9050");
		irc=new comandiIrc();
		new ircGui();
	}
	
	//trovaParola cerca la parola in frase. Restituisce true/false
	private boolean trovaParola(String frase, String parola){
		try{
			String result;
			StringTokenizer tokenizer;
			boolean continua=true;

			tokenizer = new StringTokenizer(frase);

			do{
				result = tokenizer.nextToken();
				if (result.compareTo(parola) == 0)
					continua=false;
			}while(continua);

			return true;

		}
		catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	//interfaccia grafica
	private class ircGui extends JFrame{
	 	String server;
	 	String nick;
	 	String canale;
	 	boolean torBool;
	 	
	 	//campi di edit
	 	JTextField JTFurl;//url server
	 	JTextField JTFnick;//nick
	 	JTextField JTFcanale;//canale
	 	JTextField JTFMess;//messaggio da inviare
	 	JTextField JTFComando;
	 	
        //TextArea
	 	JTextArea JTAricevuti;//storio messaggi ricevuti - sola lettura
        JTextArea JTAinviati;//Storico dei messaggi inviati - sola lettura
        
        //bottoni
        JButton JBconnetti;
        JButton JBdisconnetti;
        JButton JBcambiaNick;
        JButton JBinviaMess;
        JButton JBinviaComando;
        JButton JBcambiaCanale;
        
        //radio button
        JRadioButton torSi;
        JRadioButton torNo;
        ButtonGroup torGroup;
        
         
        //costruttore
        public ircGui(){
        	JTFurl=new JTextField("",20);
        	JTFnick=new JTextField("",20);
        	JTFcanale=new JTextField("",20);
        	JTFMess=new JTextField("",40);
        	JTFComando=new JTextField("",40);
        	 	
        	 	
        	JTAricevuti=new JTextArea("");
        	JTAricevuti.setEditable(false);//sola lettura
        	JTAinviati=new JTextArea("");
        	JTAinviati.setEditable(false);//sola lettura
        	
        	//ScrollPane associato alla TextArea dei messaggi ricevuti
        	JScrollPane areaScrollPane = new JScrollPane(JTAricevuti);
        	areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        	areaScrollPane.setPreferredSize(new Dimension(150,240));
        	areaScrollPane.setBorder(
        			BorderFactory.createCompoundBorder(
        					BorderFactory.createCompoundBorder(
        					BorderFactory.createTitledBorder("Stato Ricezione"),
        					BorderFactory.createEmptyBorder(5,5,5,5)),
        					areaScrollPane.getBorder()));

        	//ScrollPane associato alla TextArea dei messaggi inviati
        	JScrollPane areaScrollPane2 = new JScrollPane(JTAinviati);
        	areaScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        	areaScrollPane2.setPreferredSize(new Dimension(150,240));
        	areaScrollPane2.setBorder(
        			BorderFactory.createCompoundBorder(
        			BorderFactory.createCompoundBorder(
        			BorderFactory.createTitledBorder("Stato Trasmissione"),
        			BorderFactory.createEmptyBorder(5,5,5,5)),
        			areaScrollPane2.getBorder()));
        	
        	
        	//dichiara i radio button
        	//radio button
            torGroup=new ButtonGroup();
            torSi=new JRadioButton("Collegati con TOR");
            torNo=new JRadioButton("Collegati senza TOR",true);
            torGroup.add(torSi);
            torGroup.add(torNo);
            torSi.addActionListener(new gestoreBottoni());
            torNo.addActionListener(new gestoreBottoni());
            
        	// dichiara i bottoni e associali al gestore di eventi
        	JBconnetti=new JButton("CONNETTI");
        	JBconnetti.addActionListener( new gestoreBottoni() );

        	JBdisconnetti=new JButton("DISCONNETTI");
        	JBdisconnetti.addActionListener( new gestoreBottoni() );
                        
        	JBcambiaNick=new JButton("CAMBIA NICK");
        	JBcambiaNick.addActionListener( new gestoreBottoni() );
        	
        	JBcambiaCanale=new JButton("CAMBIA CANALE");
        	JBcambiaCanale.addActionListener( new gestoreBottoni() );
        	
        	JBinviaMess=new JButton("INVIA MESSAGGIO");
        	JBinviaMess.addActionListener( new gestoreBottoni() );

        	
        	JBinviaComando=new JButton("INVIA COMANDO");
        	JBinviaComando.addActionListener( new gestoreBottoni() );
        	
            //composizione pannelli            
        	JPanel PanelAlto=new JPanel();
        	PanelAlto.setLayout(new GridLayout(4,3));
        	PanelAlto.add(new JLabel("URL Server:"));
        	PanelAlto.add(JTFurl);
        	PanelAlto.add(new JLabel(""));
        	PanelAlto.add(new JLabel("NickName:"));
        	PanelAlto.add(JTFnick);
        	PanelAlto.add(new JLabel(""));
        	PanelAlto.add(new JLabel("Canale:"));
        	PanelAlto.add(JTFcanale);
        	PanelAlto.add(new JLabel(""));
        	PanelAlto.add(new JLabel("Come ti vuoi collegare? "));
        	PanelAlto.add(torSi);
        	PanelAlto.add(torNo);
                        
        	JPanel PanelBasso=new JPanel();
        	PanelBasso.setLayout(new GridLayout(2,2));
        	PanelBasso.add(new JLabel("Scrivi qui il messaggio da inviare: "));
        	PanelBasso.add(JTFMess);
        	PanelBasso.add(new JLabel("Modalità esperti - Scrivi qui direttamente il comando: "));
        	PanelBasso.add(JTFComando);
        	//PanelBasso.add(JBinviaMess);
                        
        	JPanel Panel = new JPanel();
        	Panel.setLayout(new GridLayout(1,2));
        	Panel.add(areaScrollPane);
        	Panel.add(areaScrollPane2);

        	JPanel Panel2 = new JPanel();
        	Panel2.setLayout(new GridLayout(11,1));
        	Panel2.add(JBconnetti);
        	Panel2.add(new JLabel("   "));
        	Panel2.add(JBdisconnetti);
        	Panel2.add(new JLabel("   "));
        	Panel2.add(JBcambiaNick);
        	Panel2.add(new JLabel("   "));
        	Panel2.add(JBcambiaCanale);
        	Panel2.add(new JLabel("   "));
        	Panel2.add(JBinviaMess);
        	Panel2.add(new JLabel("   "));
        	Panel2.add(JBinviaComando);

        	//Pannello contenitore
        	JPanel pannelloGrande=new JPanel();
        	pannelloGrande.setLayout(new BorderLayout());
        	pannelloGrande.add(BorderLayout.NORTH,PanelAlto);
        	pannelloGrande.add(BorderLayout.CENTER,Panel);
        	pannelloGrande.add(BorderLayout.SOUTH,PanelBasso);
                        
        	//chiusura finestra dal pulsante di default
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	getContentPane().setLayout(new BorderLayout());//layout del frame
        	//aggiunta pannelli al frame
        	getContentPane().add(BorderLayout.CENTER,pannelloGrande);
        	getContentPane().add(BorderLayout.EAST,Panel2);

        	setTitle("Client irc");
        	setSize(700,500);
        	setVisible(true);
         }
        
        //gestore di eventi
        private class gestoreBottoni implements ActionListener{
        	public void actionPerformed(ActionEvent e){
        		String bottone=e.getActionCommand();
        		System.out.println("Hai premuto il bottone: "+bottone);
        		if(bottone.equals("CONNETTI")){
        			System.out.println("bottone = CONNETTI");
        			
        			try{
        				JTAricevuti.append("> connessione...\n");
        				if(JTFurl.getText().equals("") || JTFnick.getText().equals("") || 
        						JTFcanale.getText().equals("") ){
        					System.out.println("Uno dei campi necessari per la connessione è vuoto");
        					JTAricevuti.append("Uno dei campi necessari per la connessione è vuoto\n\n");
        					return;
        				}
        				server=JTFurl.getText();
        				nick=JTFnick.getText();
        				canale=JTFcanale.getText();  
        				if(torSi.isSelected()){
            				torBool=true;
            			}
            			else {
            				torBool=false;
            			}
        				connectIrc vai=new connectIrc("connettiIRC");
        				vai.start();//avvia il Thread
        				
        			}
        		catch (SecurityException ex){}
        		}//fine if bottone = CONNETTI
        		
        		if(bottone.equals("DISCONNETTI")){
        			System.out.println("bottone = DISCONNETTI");
        			try{
               		 JTAricevuti.append("> ...disconnesso.\n");
               		 irc.esciChan();
               		 irc.disconnetti();
               	 }
               	 catch (Exception ex){}
     
        		}//fine bottone = DISCONNETTI
        		
        		if(bottone.equals("INVIA MESSAGGIO")){
        			System.out.println("bottone = INVIA MESSAGGIO");
        			try{
            			irc.scriviChan(JTFMess.getText());
            			System.out.println("Ho scritto sul canale il messaggio: "+
            					">"+nick+": "+JTFMess.getText()+"\n\n");
            			JTAinviati.append(nick+" > "+JTFMess.getText()+"\n\n");
            			JTFMess.setText("");//resetta la TextField
            		}
            		catch (Exception ex){}
        		}//fine bottone = INVIA MESSAGGIO
        		
        		if(bottone.equals("INVIA COMANDO")){
        			System.out.println("bottone = INVIA COMANDO");
        			try{
            			irc.scriviComando(JTFComando.getText());
            			System.out.println("Ho scritto sul canale il messaggio: "+
            					">"+nick+": "+JTFComando.getText()+"\n\n");
            			JTAinviati.append(nick+" > "+JTFComando.getText()+"\n\n");
            			JTFComando.setText("");//resetta la TextField
            		}
            		catch (Exception ex){}
        		}//fine bottone = INVIA COMANDO
        		
        		if (bottone.equals("CAMBIA CANALE")){
        			System.out.println("bottone = CAMBIA CANALE");
        			String nuovoCanale=JTFcanale.getText();
        			if(nuovoCanale.equals("")){
        				System.out.println("Il campo canale è vuoto");
        				JTAricevuti.append("\nIl campo canale è vuoto.\n\n");
        			}
        			else{
        				irc.esciChan();
        				canale=nuovoCanale;
        				irc.entraChan(canale);
    					//JTAricevuti.append("\n\nInvio il messaggio \"Ciao a tutti\" \n\n");
    					//irc.scriviChan("Ciao a tutti!");
        			}
        		}//fine bottone = CAMBIA CANALE
        		
        		if(bottone.equals("CAMBIA NICK")){
        			System.out.println("bottone = CAMBIA NICK");
        			String nuovoNick=JTFnick.getText();
        			if(nuovoNick.equals("")){
        				System.out.println("Campo nick vuoto");
        				JTAricevuti.append("\nCampo Nick Vuoto\n\n");
        			}
        			else{
        				nick=nuovoNick;
        				irc.cambiaNick(nick);
        			}
        		}//fine bottone = CAMBIA NICK
        	}
        }
        
        
        private class connectIrc extends Thread{
        	//costruttore
        	public connectIrc(String name){
        		super(name);
        	}

        	public void run(){
        		try{
        			String line;
        			//boolean continua;
        			boolean connesso=irc.connetti(server,nick,canale,torBool);
        			
        			if(connesso){
        				System.out.println("Connessione riuscita.");
        					irc.entraChan();
        					System.out.println("Sono entrato nel canale "+canale);
        					line = irc.ricevi();
        					JTAricevuti.append(line+"\n");
        					//JTAinviati.append("\n\n"+nick+" >  Ciao a tutti! \n\n");
        					//irc.scriviChan("Ciao a tutti!");
                            
        					//ciclo di lettura dei messaggi. Esce solo quando riceve il valore "-1" da irc.riceri()
        					// (disconnessione o altri problemi nella lettura dal socket)
        					for(;;){
        						line = irc.ricevi();
        						JTAricevuti.append(line+"\n");
        						if(trovaParola(line,"PING")){
        							JTAricevuti.append("Ho ricevuto un PING\n");
        							System.out.println("Ho ricevuto un PING");
        							irc.pong(line);
        							JTAinviati.append(nick+" > invio un PONG\n");
        							System.out.println("Rispondo PONG");
        						}
        						if(line.equals("-1")){
        							System.out.println("Ho letto il valore -1"); 
        							connesso=false;
        							break;//termina l'esecuzione del Thread
        						}

        					}
        			}//fine if connesso
        			else{
        				JTAricevuti.append("Connessione non riuscita.\n");
        			}
        		}
        		catch(Exception ex){
        			System.out.println("Op. non riuscita. Sono in run di connectIrc.");
        		}
    
        	}//fine run
        } // fine classe connectIrc
	}// fine classe ircGui
} 




