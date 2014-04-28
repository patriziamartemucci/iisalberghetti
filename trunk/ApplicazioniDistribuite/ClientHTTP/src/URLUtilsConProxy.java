import java.net.*;
import java.io.*;

public class URLUtilsConProxy {
  public static void main(String s[]) {
	  //passare come parametri al main username e password per l'accesso al proxy
    //URLUtilsScuola.dump("http://www.alberghetti.it",s[0],s[1]);
    System.out.println("**************");
    URLUtilsConProxy.dump("http://www.imolug.org",s[0],s[1]);
    System.out.println("**************");
  }

  public static void dump(String URLName, final String nomeUtente, final String password){
    try {
      DataInputStream di = null;
      FileOutputStream fo = null;
      byte [] b = new byte[1];

      // PROXY
      System.getProperties().put("proxySet", "true");
      System.setProperty("http.proxyHost","192.168.1.253") ;
      System.setProperty("http.proxyPort", "8080") ;

      URL u = new URL(URLName);
      HttpURLConnection con = (HttpURLConnection) u.openConnection();
      con.addRequestProperty("User-Agent", "Mozilla/4.76"); 

      Authenticator.setDefault(new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new
               PasswordAuthentication(nomeUtente,password.toCharArray());
               //PasswordAuthentication("mydomain\\username","password".toCharArray());

        }});
     
      di = new DataInputStream(con.getInputStream());
      while(-1 != di.read(b,0,1)) {
         System.out.print(new String(b));
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

}
