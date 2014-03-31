import java.io.*;


public class DataObject implements Serializable
 {

	public byte[] richiesta;
	public byte[] risposta;
	
	
public DataObject (){
		
		
	}

public DataObject (byte[] rich, byte[] risp){
		
		richiesta=rich;
		risposta=risp;
		
	}
		
}
