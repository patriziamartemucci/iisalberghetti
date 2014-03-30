import java.io.*;

public class ProvaEccezzioni {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader
				(new InputStreamReader(System.in));
		String linea = "";
		int x;
		do{
		try {
			linea=br.readLine();
			x=Integer.parseInt(linea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			x=0;
		} catch(NumberFormatException e2) {
			// e2.printStackTrace();
			String s=e2.getMessage();
			System.out.println("messaggio di errore :"+s);
			x=0;
		} catch(Exception e3){
			e3.printStackTrace();
			x=0;
		}
		
		}while(x<=0 || x>10);
		
		
	}

}
