
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

import org.bson.*;
import org.bson.types.*;

public class LeggiBson {

public static void main(String[] args) {

	long startTime=System.currentTimeMillis();
	
	try {
	FileInputStream x=new FileInputStream("vocabolario.bson");
    ObjectInputStream ois =new ObjectInputStream(x);
    
    BasicBSONObject obj = (BasicBSONObject) ois.readObject();    
   
    BasicBSONList list=(BasicBSONList) obj.get("records");
    

    int i=0;
    
    for (i=0; i<list.size(); i++) {
    BasicBSONObject rigaVoc = (BasicBSONObject) list.get(i);
    
    
    byte[] r=(byte []) rigaVoc.get("richiesta");
    byte[] ri=(byte[]) new String("rich199999").getBytes();
    
    if (Arrays.equals(r, ri)) {
    	 System.out.println(new String((byte[]) rigaVoc.get("risposta")));
   }
    
 
  
    }

long endTime=System.currentTimeMillis();
long tempo=endTime-startTime;
System.out.println("Ho impiegato " + tempo + " millisecondi");
	
	}  catch (Exception e1) 
	   {
		   e1.printStackTrace();
		  } 
 	
}
	
	
}