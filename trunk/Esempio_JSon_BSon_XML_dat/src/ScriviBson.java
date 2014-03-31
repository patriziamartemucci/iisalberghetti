import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.bson.*;

import org.bson.types.*;


public class ScriviBson {


public static void main(String[] args) {

// TODO Auto-generated method stub


int i=0;


	BasicBSONObject obj = new BasicBSONObject();
	BasicBSONList list = new BasicBSONList();


	String domanda="";
	String risposta="";

	for (i=0; i<200000; i++) {

		domanda="rich"+Integer.toString(i);
		risposta="risp"+Integer.toString(i);

		byte[] bytesRich = domanda.getBytes();
		byte[] bytesRisp = risposta.getBytes();

		BasicBSONObject rigaVoc = new BasicBSONObject();

		rigaVoc.put("richiesta", bytesRich);
		rigaVoc.put("risposta", bytesRisp);

		list.put(i, rigaVoc);
}


obj.put("records", list);

try {
	 
	 FileOutputStream x=new FileOutputStream("vocabolario.bson");
     ObjectOutputStream oos =new ObjectOutputStream(x);
     oos.writeObject(obj);
     oos.close();
     x.close();
     
} catch (IOException e) {
	e.printStackTrace();
}

}
}

