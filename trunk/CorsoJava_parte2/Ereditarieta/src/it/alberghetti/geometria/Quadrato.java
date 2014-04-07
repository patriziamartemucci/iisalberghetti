package it.alberghetti.geometria;

public class Quadrato extends Rettangolo implements Cloneable{
	public Quadrato(){
		super();
		System.out.println("Classe Quadrato: costruttore senza parametri");
	}
	
	public Quadrato(int x){
		this(x,0);
		System.out.println("Classe Quadrato: costruttore con 1 parametro");
	}
	
	public Quadrato(int x, int colore){
		super(x,x,colore);
		System.out.println("Classe Quadrato: costruttore con 2 parametri");
	}
	
	public String toString(){
		System.out.println("Classe Quadrato: metodo toString");
		return "Quadrato["+a+","+colore+"]";
	}
	
	public Object clone()throws CloneNotSupportedException{
		System.out.println("Classe Quadrato: metodo clone");
		
		try{
			return (Quadrato)super.clone();
		}
		catch(CloneNotSupportedException e){
			throw e;
		}
	}
	
	public boolean equals(Object o){
		System.out.println("Classe Quadrato: metodo equals");
		Quadrato q;
		if(o instanceof Quadrato){
			q=(Quadrato)o;
			if(q.a==this.a && q.colore==this.colore)return true;
			else return false;
		}
		else return false;
	}
}
