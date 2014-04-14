import java.awt.GraphicsEnvironment;

public class ListFonts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListFonts lf = new ListFonts();
		lf.printFonts();

	}

	 public void printFonts(){
		 GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		 String[] fonts=ge.getAvailableFontFamilyNames();
		 System.out.println("Numero di fonts disponibili "+ fonts.length);
		 System.out.println("Elenco dei fonts disponibili ");
		 for(int i=0; i<fonts.length;i++){
			 System.out.println("\t"+fonts[i]);
		 }
	 }
}
