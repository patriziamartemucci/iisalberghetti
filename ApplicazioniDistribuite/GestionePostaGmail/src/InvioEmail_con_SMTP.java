import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import java.util.Properties;

//Esempio di invio email 
public class InvioEmail_con_SMTP {

    private static final String SMTP_HOST_NAME = "out.alice.it";
    private  String SMTP_AUTH_USER ;
    private String SMTP_AUTH_PWD;
    private String destinatario;
    private String mittente;
  
    public static void main(String[] args) throws Exception{
       new InvioEmail_con_SMTP().test(args[0],args[1],args[2],args[3]);
    }

    public void test(String username,String password,String destinatario,String mittente) throws Exception{
        
    	SMTP_AUTH_USER=username;
    	SMTP_AUTH_PWD=password;
    	this.destinatario=destinatario;
    	this.mittente=mittente;
    	Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);
        // uncomment for debugging infos to stdout
        // mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.setContent("This is a test", "text/plain");
        message.setFrom(new InternetAddress(this.mittente));
        message.addRecipient(Message.RecipientType.TO,
             new InternetAddress(this.destinatario));
        message.setSubject("prova invio email da alice");
        transport.connect();
        transport.sendMessage(message,
            message.getRecipients(Message.RecipientType.TO));
        transport.close();
        System.out.println("Messaggio inviato");
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String username = SMTP_AUTH_USER;
           String password = SMTP_AUTH_PWD;
           return new PasswordAuthentication(username, password);
        }
    }
}