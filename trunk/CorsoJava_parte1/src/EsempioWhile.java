
public class EsempioWhile {
	public static void main(String args[]){
		int x=30;
		//questo ciclo non verrà eseguito perchè la condizione è falsa
		while(x<30){
			System.out.println("ciclo 1 eseguito");
		}
		//questo ciclo verrà eseguito almeno una volta 
		//perchè la condizione viene verificata solo alla fine del blocco
		do{
			System.out.println("ciclo 2 eseguito");
		}while(x<30);
		
		//esempio di ciclo for: esegue 10 volte il blocco
		for(int i=0;i<10;i++){
			System.out.println("i vale "+i);
		}
		
		// ciclo for scritto con while (perchè il for deriva dal while)
		int i=0;//inizializzazione
		while(i<10){//verifica della condizione
			System.out.println("i vale "+i);
			i++;//aggiornamento della variabile i
		}
		//ciclo for con più variabili
		int j;
		for(i=0,j=10;i<10;i=i+2,j--){
			System.out.println("i vale "+i+"  e j vale "+j);
		}
		
	}
}
