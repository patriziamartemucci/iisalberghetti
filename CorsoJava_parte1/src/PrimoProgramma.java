
import java.io.*;
class PrimoProgramma{
	public static void main(String args[]) throws Exception{
		int hd,cd,mouse;
		float prezzohd,prezzocd,prezzomouse;
		
		final float prezzoUhd=50;
		final float prezzoUcd=1.5F;
		final float prezzoUmouse=5;
		
		BufferedReader br=new BufferedReader(
			new InputStreamReader(System.in));
		
		System.out.println("Inserisci il numero di HD: ");
		String s=br.readLine();
		hd=Integer.parseInt(s);
		//Double.parseDouble(s)
		//Float.parseFloat(s)
		
	
		System.out.println("Inserisci il numero di CD: ");
		s=br.readLine();
		cd=Integer.parseInt(s);

		System.out.println("Inserisci il numero di mouse: ");
		s=br.readLine();
		mouse=Integer.parseInt(s);
		
		prezzohd=hd*prezzoUhd;
		prezzocd=prezzoUcd*cd;
		prezzomouse=prezzoUmouse*mouse;

		float tot=prezzohd+prezzocd+prezzomouse;
		System.out.println("Mediaworld\n");
		System.out.println("HD x "+hd+"\t\t"+ prezzohd);
		System.out.println("CD x "+cd+"\t\t"+ prezzocd);
		System.out.println("mouse x "+mouse+"\t"+ prezzomouse);
		System.out.println("\tTot:\t"+tot);
		
	}
}
