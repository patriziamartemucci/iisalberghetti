
public class Fibonacci {
	public static int fibonacci(int n){
		if(n==0 || n==1) return n;
		else return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static int somma(int a,int b){
		if(b==0)return a;
		else return somma(a,b-1)+1;
	}
	public static void main(String[] args) {
		int n=6;
		System.out.println("Termine di fibonacci n."+n+": "+fibonacci(n));
		System.out.println("Somma ricorsiva: "+somma(3,7));
	}

}
