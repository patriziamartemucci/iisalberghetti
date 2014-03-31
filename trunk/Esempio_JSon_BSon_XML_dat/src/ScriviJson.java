import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class ScriviJson {
     public static void main(String[] args) {
 
    long i;
	JSONObject obj = new JSONObject();
	JSONArray list = new JSONArray();
	
	
	
	for (i=1; i<=200000; i++) {
		JSONObject objRich = new JSONObject();
		objRich.put("richiesta", ("rich" + Long.toString(i)).getBytes());
		objRich.put("risposta", ("risp" + Long.toString(i)).getBytes());
		list.add(objRich);
		objRich=null;
	}
	
	
	obj.put("records", list);
	 
	try {
 
		 FileOutputStream x=new FileOutputStream("vocabolario.json");
	     ObjectOutputStream oos =new ObjectOutputStream(x);
	     oos.writeObject(obj);
	     oos.close();
	     x.close();
 
	} catch (IOException e) {
		e.printStackTrace();
	}
	
     }
 
}