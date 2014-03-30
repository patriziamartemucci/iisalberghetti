import java.io.*;

public class NumeriPrimi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new 
				BufferedReader(new InputStreamReader(System.in));
		
		int n,i,conta=0;
	
		do{
			n=Integer.parseInt(br.readLine());
			if(n<2){
				System.out.println("Valore non valido. Inserisci un valore maggiore di 1.");
			}
		}while(n<2);
		
		//metodo 1
		System.out.println("Metodo 1");
		for(i=2;i<n;i++){
			if(n%i==0)conta++;
		}
		if(conta==0){
			System.out.println(n+" è primo.");
		}
		else{
			System.out.println(n+" non è primo.");
		}
		
		//metodo 2
		System.out.println("Metodo 1");
		boolean primo=true;
		for(i=2;i<n && primo; i++){
			if(n%i==0)primo=false;
		}
		if(primo){
			System.out.println(n+" è primo.");
		}
		else{
			System.out.println(n+" non è primo.");
		}
	}

}
