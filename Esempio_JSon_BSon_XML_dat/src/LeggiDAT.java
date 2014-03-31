import java.io.*;
import java.util.Arrays;


public class LeggiDAT {
	
public static void main(String args[]){

   int i;
   
   try 
   { 
	   long startTime = System.currentTimeMillis();
	   
	   FileInputStream x=new FileInputStream("vocabolario.dat");
       ObjectInputStream ois =new ObjectInputStream(x);
  
     
       DataObject[] ddd=(DataObject[]) ois.readObject();
     
       
         
   for (i=0; i<ddd.length; i++) {
	   
	
	   
	   byte[] r=ddd[i].richiesta;
	   byte[] ri=(byte[]) new String("rich199999").getBytes(); 
	   
	   if (Arrays.equals(r, ri)) {
	    	 System.out.println(new String(ddd[i].risposta));
	   }
	   

   }
   
   
   ois.close();
   x.close();
   
   long endTime = System.currentTimeMillis();
   long tempo = (endTime - startTime);
   System.out.println("Ho impiegato " + tempo + " millisecondi");
   
   }
   catch (Exception e1) 
   {
   e1.printStackTrace();
   } 
}
}
   
  