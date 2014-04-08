package it.alberghetti.geometria;


public class Rettangolo extends Quadrilatero implements Cloneable{
	protected int colore;
	
	public Rettangolo(){
		this(0,0,0);
		System.out.println("Classe Rettangolo: costruttore senza parametri");
	}
	
	public Rettangolo(int x,int y,int c){
		super(x,y,x,y);
		this.colore=c;
		System.out.println("Classe Rettangolo: costruttore con 3 parametri parametri");
	}
	
	public Rettangolo(int x ,int y){
		this(x,y,0);
		System.out.println("Classe Rettangolo: costruttore con 2 parametri");
	}
	
	public int getColore(){
		System.out.println("Classe Rettangolo: metodo getColore");
		return colore;
	}
	
	public void setColore(int colore){
		System.out.println("Classe Rettangolo: metodo setColore");
		this.colore=colore;
	}
	
	public double area(){
		System.out.println("Classe Rettangolo: metodo area");
		return a*b;
	}
	
	public String toString(){
		System.out.println("Classe Rettangolo: metodo toString");
		return "Rettangolo["+a+","+b+","+colore+"]";
	}
	
	public Object clone() throws CloneNotSupportedException{
		System.out.println("Classe Rettangolo: metodo clone");
		try{
			return (Rettangolo)super.clone();
		}
			
		catch(CloneNotSupportedException e){
			throw e;
		}
		
	}
	
	public boolean equals(Object o){
		System.out.println("Classe Rettangolo: metodo equals");
		Rettangolo q;
		if(o instanceof Rettangolo){
			q=(Rettangolo)o;
			if(q.a==this.a && q.b==this.b && q.colore==this.colore)return true;
			else return false;
		}
		else return false;
	}

}
