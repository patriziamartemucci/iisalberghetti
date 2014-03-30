
public class EsempioArithmeticException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x;
		double y = 0;
		Double d;
		
		x=0;
		System.out.println("\n\nOperazioni con i numeri DOUBLE. y=1/x\n");
		try{
			y=1/x;
		}
		catch(ArithmeticException e){
			//e.printStackTrace();
			System.out.println("Eccezione 1 catturata : "+e.getMessage());
		}
		
		System.out.println("y vale "+y);
		if(y==Double.POSITIVE_INFINITY){
			System.out.println("y vale POSITIVE_INFINITY");
		}
		d=new Double(y);
		if(d.isInfinite())
			System.out.println("Valore non valido. Infinito");
	
		System.out.println("\n\nOperazioni con i numeri DOUBLE. y=sqrt(x)\n");
		x=-1;
		
		try{
			y=Math.sqrt(x)+2;
		}
		catch(Exception e1){
			e1.printStackTrace();
			System.out.println("Eccezione 2 catturata");
		}
		//y=(int)(Math.sqrt(x)+2);
		
		System.out.println("\n\ny vale "+y);
		//l'if sulla riga successiva  falso, non stampa niente
		if(y==Double.NaN){
			System.out.println("y vale NOT A NUMBER. ");
		}
		d=new Double(y);
		if(d.isNaN())
			System.out.println("Valore non valido. NaN");
		
		
		int xx,yy = 0;
		xx=0;
		System.out.println("\n\nOperazioni con i numeri INTERI. y=1/x\n");
		try{
			yy=1/xx;
		}
		catch(ArithmeticException e){
			//e.printStackTrace();
			System.out.println("Eccezione 1 catturata : "+e.getMessage());
		}
		
		System.out.println("yy  vale "+yy);
		
		System.out.println("\n\nOperazioni con i numeri INTERI. y=sqrt(x)\n");
		xx=-1;
		
		try{
			yy=(int)(Math.sqrt(xx)+2);
			y=Math.sqrt(xx)+2;
		}
		catch(Exception e1){
			e1.printStackTrace();
			System.out.println("Eccezione 2 catturata");
		}
		
		System.out.println("\n\nyy vale "+yy);
		System.out.println("y vale "+y);
	}

	
}
