
public class EsempioWhile {
	public static void main(String args[]){
		int x=30;
		//questo ciclo non verr� eseguito perch� la condizione � falsa
		while(x<30){
			System.out.println("ciclo 1 eseguito");
		}
		//questo ciclo verr� eseguito almeno una volta 
		//perch� la condizione viene verificata solo alla fine del blocco
		do{
			System.out.println("ciclo 2 eseguito");
		}while(x<30);
		
		//esempio di ciclo for: esegue 10 volte il blocco
		for(int i=0;i<10;i++){
			System.out.println("i vale "+i);
		}
		
		// ciclo for scritto con while (perch� il for deriva dal while)
		int i=0;//inizializzazione
		while(i<10){//verifica della condizione
			System.out.println("i vale "+i);
			i++;//aggiornamento della variabile i
		}
		//ciclo for con pi� variabili
		int j;
		for(i=0,j=10;i<10;i=i+2,j--){
			System.out.println("i vale "+i+"  e j vale "+j);
		}
		
	}
}
