import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class EsempioFunzioni {

//	Esempio di funzione con un parametro e che restituisce un valore
	public static int doppio(int x){
		int d;
		d=2*x;
		return d;
	}
	//Esempio di funzione senza parametri e senza valore di ritorno
	public static void stampaIntestazione(){
		System.out.println("Liceo scientifico Tecnologico Alberghetti");
		System.out.println("Via Pio IX");
		System.out.println("Imola");
	}
	
	//Esempio di funzione che restituisce un valore
	public static int random(){
		int x;
		x=(int)(Math.random()*100);
		return x;
	}
	
	//Esempio di funzione che restituisce un valore. Riceve due parametri
	public static int random(int min, int max){
		int x;
		x=(int)(Math.random()*(max-min))+min;
		return x;
	}
	
	
	//Esempio di funzione con parametro che non restiusce niente
	public static void salutoPersonalizzato(String nome){
		System.out.println("Ciao "+nome);
	}
	
	//esempio di funzione per il calcolo del fattoriale
	public static int fattoriale(int n){
		int f=1,i;
		for(i=1;i<=n;i++){
			f=f*i;
		}
		return f;
	}
	
	//WRAPPER
	public static void scambia(AtomicInteger a, AtomicInteger b){
		int temp=a.get();
		 a.set(b.get());
		 b.set(temp);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Richiama la funzione Intestazione\n");
		stampaIntestazione();
		System.out.println("\nDopo la chiamata Intestazione riprende l'esecuzione del main");
		
		//richiama la funzione random100
		int num;
		num=random();
		System.out.println("\n\nNumero casuale compreso tra 0 e 99: "+num);
		
		
		//richiama la funzione randomIntervallo
		int num2;
		int minimo=-5,massimo=10;
		num2=random(minimo,massimo);
		System.out.println("\n\nNumero casuale compreso tra "+minimo+" e "+massimo+" : "+num2+"\n\n");
	
		
		//richiama la funzione salutoPersonalizzato
		String nome="Pippo";
		salutoPersonalizzato(nome);
		
		//richiama la funzione doppio
		int risultato1=doppio(num);
		int risultato2=doppio(15);
		System.out.println("\n\nIl doppio di "+num+" � "+risultato1+"\nIl doppio di 15 � "+risultato2);
		int n=5;
		System.out.println("\n\n"+n+"! = "+fattoriale(n));
		
		AtomicInteger x = new AtomicInteger(10),y = new AtomicInteger(20);
		System.out.println("Prima\nx vale "+x.intValue()+"    y vale "+y.intValue());
		scambia(x,y);
		System.out.println("Dopo\nx vale "+x.intValue()+"    y vale "+y.intValue());
		
		Vector vetInt=new Vector();
		vetInt.add(10);
		vetInt.add(20);
		for(int i=0;i<vetInt.size();i++){
			int a=(int)vetInt.elementAt(i);
			System.out.println("Valore vetInt["+i+"]: "+a);
		}
		
		//WRAPPER
		Vector <Integer> vet= new Vector<Integer>() ;
		vet.add(Integer.valueOf(10));
		vet.add(Integer.valueOf(20));
		for(int i=0;i<vet.size();i++){
			Integer a=(Integer)vet.elementAt(i);
			System.out.println("Valore vet["+i+"]: "+a.intValue());
		}
		
	}

}
