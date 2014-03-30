import java.io.Console;
import java.io.IOException;
public class LeggereDaConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char password[] = null;
		
		//due modi per leggere la password da terminale
		System.out.println("Con System.console()");
		Console cons=System.console();
		if(cons!=null){
			password=cons.readPassword("[%s]", "Enter password:");
		}
		
		/*
		System.out.println("Con la classe PasswordField()");
			try {
				password = PasswordField.getPassword(System.in, "Enter password: ");
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		*/
		
		if(password==null){
			System.out.println("\n\nPassword inserita nulla");
     	}
	}

}
