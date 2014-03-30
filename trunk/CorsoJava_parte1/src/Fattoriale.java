
public class Fattoriale {

	public static int fattoriale(int m){
		if(m==0) return 1;
		else return m*fattoriale(m-1);
	}
	
	public static void main(String[] args) {
		int n=100000,f;
		f=fattoriale(n);
		System.out.println("Il fattoriale di "+n+" è "+f);
	}
}
