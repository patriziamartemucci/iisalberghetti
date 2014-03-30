
public class NumeroNepero {
	public static void main(String[] args) {
		long n=1000000,i;
		double e=0;
		for(i=0;i<n;i++){
			e=Math.pow(1+1.0/n,n);
		}
		System.out.println("e: "+e);
	}
}
