public class MassimoComuneDivisore {
	public static int mcd(int a, int b){
		int r=0;
		do{
			r=a%b;
			a=b;
			b=r;
		}while(r!=0);
		return a;
	}

	public static void main(String[] args) throws Exception {
		int x=3,b=7,massimoComuneDivisore;
		massimoComuneDivisore=mcd(x,b);
		System.out.println("mcd: "+massimoComuneDivisore);
	}
}
