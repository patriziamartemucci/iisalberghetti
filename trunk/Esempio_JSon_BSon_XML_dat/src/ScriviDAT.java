import java.io.*;


public class ScriviDAT {
	
public static void main(String args[]){

   int i;
   
   try 
   { 
	   FileOutputStream x=new FileOutputStream("vocabolario.dat");
       ObjectOutputStream oos =new ObjectOutputStream(x);
  
       DataObject[] dt=new DataObject[200000];
   for (i=0; i<200000; i++) {
	   
	   dt[i] = new DataObject (("rich"+Integer.toString(i)).getBytes(), ("risp"+Integer.toString(i)).getBytes());
	  
   }
   
   oos.writeObject(dt);
   
   oos.close();
   x.close();
   System.out.println("finito");
   }
   catch (IOException e1) 
   {
   e1.printStackTrace();
   } 
   
   
   
  

}
}

