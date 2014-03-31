public class NumeroComplesso{
	
	protected double a;
	protected double b;
	
	
	//costruttori
	public NumeroComplesso(){
		a=0;
		b=0;
	}
	
	public NumeroComplesso(double x, double y){
		a=x;
		b=y;
	}
	
	//metodi per l'interfaccia
	public void set_a(double x){
		a=x;
	}
	
	public void set_b(double y){
		b=y;
	}
	
	public double get_a(){
		return a;
	}
	
	public double get_b(){
		return b;
	}
	
	public String toString(){
		String v=super.toString();//richiama il toString di Object
		String s;
		
		if (b>=0)	s=v+"  --> "+a+" +"+b+"i";	
		else		s=v+"  --> "+a+" "+b+"i";
		
		return s;
	}
	
	//metodi 
	public boolean equals(Object o){
		boolean controllo;
		if(!(o instanceof NumeroComplesso)) controllo=false;
		else{
			NumeroComplesso x=(NumeroComplesso)o;
			if ((a==x.a)&&(b==x.b))	controllo=true;
			else					controllo=false;
			}
		return controllo;
	}
	
	public NumeroComplesso clone(){
		NumeroComplesso t = new NumeroComplesso(a,b);
		return t;
	}
	
	public NumeroComplesso somma(NumeroComplesso t){
		double x,y;
		NumeroComplesso n;
		
		x=a+t.get_a();
		y=b+t.get_b();
		
		n=new NumeroComplesso(x,y);
		
		return n;
	}
	
	
	public NumeroComplesso quadrato(){
		double x,y;
		NumeroComplesso n;
		
		x=a*a-b*b;
		y=2*a*b;
		
		n= new NumeroComplesso(x,y);
		
		return n;	
	}
	
	public NumeroComplesso reciproco(){
		double r=a/(a*a+b*b);
		double i=-b/(a*a+b*b);
		NumeroComplesso c=new NumeroComplesso(r,i);
		return c;
	}

	public NumeroComplesso prodotto(NumeroComplesso t){
		double r=a*t.a-b*t.b;
		double i=b*t.a+a*t.b;
		NumeroComplesso c=new NumeroComplesso(r,i);
		return c;		
	}
	
	public double modulo(){
		return Math.sqrt(a*a+b*b);
	}
	

	public NumeroComplesso rapporto(NumeroComplesso t){
		double r=(a*t.a+b*t.b)/(t.a*t.a+t.b*t.b);
		double i=(t.a*b-a*t.b)/(t.a*t.a+t.b*t.b);
		NumeroComplesso c=new NumeroComplesso(r,i);
		return c;
	}
	
	public NumeroComplesso coniugato(){
		NumeroComplesso c=new NumeroComplesso(a,-b);
		return c;
	}
	
	public NumeroComplesso opposto(){
		return new NumeroComplesso(-a,-b);
	}
}