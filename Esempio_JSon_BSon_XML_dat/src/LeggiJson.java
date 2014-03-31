import java.io.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class LeggiJson {
     public static void main(String[] args) {
 
	JSONParser parser = new JSONParser();
 
	try {
		
		long Tempo1;
		long Tempo2;
		long Tempo;
		
		
		
		Tempo1=System.currentTimeMillis();
	
		   FileInputStream x=new FileInputStream("vocabolario.json");
	       ObjectInputStream ois =new ObjectInputStream(x);
		
		
		JSONObject jsonObject = (JSONObject) ois.readObject();
 
		
		JSONArray msg = (JSONArray) jsonObject.get("records");
		
		
		int i=0;
		JSONObject jsonObjectRich;
	
		while (i<msg.size()) {
			    jsonObjectRich=(JSONObject) msg.get(i) ;
			    
			    byte[] r=(byte []) jsonObjectRich.get("richiesta");
			    byte[] ri=(byte[]) new String("rich200000").getBytes();
			    
			    if (Arrays.equals(r, ri)) {
			    	 System.out.println(new String((byte[]) jsonObjectRich.get("risposta")));
			    }
			    
			 
				i++;
		}
		
		Tempo2=System.currentTimeMillis();

		//tempo in millisecondi
		Tempo=Tempo2-Tempo1;

        System.out.println("Ho impiegato " + Tempo + " millisecondi");		
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception  e) {
		e.printStackTrace();
	}
 
     }
 
}