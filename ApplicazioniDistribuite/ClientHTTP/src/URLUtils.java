import java.net.*;
import java.io.*;

public class URLUtils {
  public static void main(String s[]) {
    
    //URLUtils.dump("http://www.imolug.org");
    URLUtils.dump("http://tools.whois.net/yourip/");
    System.out.println("\n**************");
  }

  public static void dump(String URLName){
    try {
      DataInputStream di = null;
      FileOutputStream fo = null;
      byte [] b = new byte[1];

      // PROXY TOR
      
      //System.setProperty("socksProxyHost", "127.0.0.1");
      //System.setProperty("socksProxyPort","9050");
      URL u = new URL(URLName);
      HttpURLConnection con = (HttpURLConnection) u.openConnection();
      con.addRequestProperty("User-Agent", "Mozilla/4.76"); 


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
