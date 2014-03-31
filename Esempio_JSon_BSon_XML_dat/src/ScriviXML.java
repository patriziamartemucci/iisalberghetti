import org.jdom2.*; 
import org.jdom2.output.*; 
import java.io.*; 

public class ScriviXML { 

  public static void main(String[] args) { 
    try { 
      //Elemento radice 
      Element root = new Element("VOCABOLARIO"); 
      //Documento 
      Document document = new Document(root); 
     
      long i;
      
      for (i=0; i<=200000; i++) {
    	  Element item1 = new Element("RIGAVOCABOLARIO"); 
    	  Element item2=new Element("RICHIESTA");
    	  Element item3=new Element("RISPOSTA");
    	  root.addContent(item1); 
    	  item2.setText("rich"+Long.toString(i));
    	  item3.setText("risp"+Long.toString(i));
    	  item1.addContent(item2);
    	  item1.addContent(item3);
          item1=null;
          item2=null;
          item3=null;
      }
       
      
      
      XMLOutputter outputter = new XMLOutputter(); 
      
      outputter.setFormat(Format.getPrettyFormat()); 
    
      outputter.output(document, new FileOutputStream("vocabolario.xml")); 
      System.out.println("File creato:"); 
      
      
    }  
    catch (IOException e) { 
      System.err.println("Errore creazione documento"); 
      e.printStackTrace(); 
    } 

} 
}