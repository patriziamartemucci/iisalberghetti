
public class EsempioAppunti {
//programma
	public static int somma(int a, int b){
		int x;
		x=a+b;
		return x;
	}
	
	public static void stampaSomma(int a, int b){
		int x;
		x=a+b;
		System.out.println("Funzione stampaSomma: "+x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//richiama la funzione somma passando come parametri le variabili x e y
		int x=3,y=6;
		int totale=somma(x,y);
		System.out.println("Somma: "+totale);
		
		//richiama la funzione stampaSomma
		stampaSomma(4,8);
	}
}
