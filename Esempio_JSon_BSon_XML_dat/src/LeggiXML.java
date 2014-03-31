 import java.io.*; 
import java.util.*; 

import org.jdom2.*; 
import org.jdom2.input.*; 

public class LeggiXML { 

  public static void main(String[] args) { 
    try { 
    	
    	long Tempo1;
		long Tempo2;
		long Tempo;
		
		Tempo1=System.currentTimeMillis();	
    
      SAXBuilder builder = new SAXBuilder(); 
      Document document = builder.build(new File("vocabolario.xml")); 
      
      
      Element root = document.getRootElement(); 
      
      List children = root.getChildren(); 
      Iterator iterator = children.iterator(); 
      
      while(iterator.hasNext()){ 
         Element item = (Element)iterator.next(); 
         Element description = item.getChild("RICHIESTA"); 
         if (description.getText().compareTo("rich199999")==0){
        	 System.out.println(item.getChild("RISPOSTA").getText()); 
         }
         item=null;
         description=null;
      }
      
      Tempo2=System.currentTimeMillis();

		//tempo in millisecondi
		Tempo=Tempo2-Tempo1;

      System.out.println(Tempo);		
      
    }  
    catch (Exception e) { 
      System.err.println("Errore durante la lettura dal file"); 
      e.printStackTrace(); 
    } 

} 
}