
public class MinimoComuneMultiplo {
	public static void main(String args[]){
		int a=4,b=10;
		System.out.println("mcm: "+mcm(a,b,a,b));
	}
	
	public static int mcm(int sa,int sb, int a,int b){
		if(sa==sb) return sb;
		else
			if(sa>sb) return mcm(sa,sb+b,a,b);
			else return mcm(sa+a,sb,a,b);
	}
}
