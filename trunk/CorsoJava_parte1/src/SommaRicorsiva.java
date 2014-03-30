
public class SommaRicorsiva {
	public static int sommaRicorsiva(int x,int y,int cont){
		System.out.println("cont: "+cont);
		cont++;
		if(y==0) return x;
		else return sommaRicorsiva(x,y-1,cont)+1;
	}
	
	public static void main(String[] args) {
		int a=5,b=10000,risultato;
		risultato=sommaRicorsiva(a,b,0);
		System.out.println(a+" + "+b+" vale "+risultato);
	}
}
