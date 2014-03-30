
public class MonteCarlo {

	/**
	 * @param args
	 */
	public static double monteCarloApprox(double epsilon){
		long n=1000,cont=0,init=0;
		double prec=0;
		double pigreco=0;
		do{
			prec=pigreco;
			for(long i=init;i<n;i++){
				double x=Math.random();
				double y=Math.random();
				if(x*x+y*y<1) cont++;
			}
			pigreco=(cont/(double)n)*4;
			init=n;
			n=n*10;
			System.out.println("prec: "+prec+"    pigreco:"+pigreco);
		}while(Math.abs(prec-pigreco)>=epsilon);
		System.out.println("n vale "+n);
		return pigreco;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pigreco=0,epsilon=0.001;
		/*
		double x,y;
		long n=100000000,i,cont=0;
		for(i=0;i<n;i++){
			x=Math.random();
			y=Math.random();
			if(x*x+y*y<1) cont++;
		}
		pigreco=(cont/(double)n)*4;
		*/
		pigreco=monteCarloApprox(epsilon);
		System.out.println("Pigreco: "+pigreco);
	}

}
